package com.ipartek.formacion.control;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.pojo.Alumno;
import com.ipartek.formacion.pojo.Curso;
import com.ipartek.formacion.pojo.excepciones.CandidatoException;
import com.ipartek.formacion.services.AlumnoService;
import com.ipartek.formacion.services.AlumnoServiceImp;
import com.ipartek.formacion.services.Idioma;
import com.ipartek.formacion.services.Util;

/**
 * Servlet implementation class AlumnoServlet
 */
public class AlumnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int id = -1;
	private RequestDispatcher rd = null;
	// private CursoService cService = CursoServiceImp.getInstance();
	private AlumnoService aService = AlumnoServiceImp.getInstance();
	private List<Alumno> alumnos = null;
	private Alumno alumno = null;
	private int operacion = -1;
	private final static Logger LOG = Logger.getLogger(AlumnoServlet.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			// request.setAttribute(Constantes.ATT_LISTADO_CURSOS,
			// cService.getAll());
			recogerId(request);

			if (id < 0) {// REDIGIRIMOS PARA UN CREATE

				rd = request.getRequestDispatcher(Constantes.JSP_ALUMNO);
			} else {// REDIGIMOS PARA UNA UPDATE
				getById(request);
			}

		} catch (Exception e) {
			LOG.trace(e.getMessage());
			getAll(request);
		}
		rd.forward(request, response);
	}

	private void recogerId(HttpServletRequest request) {
		// if (Util.tryParseInt(request.getParameter(Constantes.PAR_CODIGO))){
		id = Integer.parseInt(request.getParameter(Constantes.PAR_CODIGO));
		// }
		LOG.trace(id + "ID");
	}

	private void getAll(HttpServletRequest request) {
		alumnos = aService.getAll();
		request.setAttribute(Constantes.ATT_LISTADO_ALUMNOS, alumnos);
		rd = request.getRequestDispatcher(Constantes.JSP_LISTADO_ALUMNOS);
	}

	private void getById(HttpServletRequest request) {
		alumno = aService.getById(id);
		request.setAttribute(Constantes.ATT_ALUMNO, alumno);
		rd = request.getRequestDispatcher(Constantes.JSP_ALUMNO);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter(Constantes.PAR_OPERACION);
		try {
			if (Util.tryParseInt(op)) {
				operacion = Integer.parseInt(op);
			}

			recogerId(request);
			LOG.trace(operacion + "ID tras el recoger id " + id);
			if (operacion == 3) {
				LOG.trace("Hola");
				aService.delete(id);
			}
			switch (operacion) {
			case Constantes.OP_CREATE:
				recogerDatosAlumno(request);
				aService.createAlumno(alumno);
				break;
			case Constantes.OP_DELETE:
				LOG.trace(alumno.getCodigo() + " delete");
				aService.delete(id);

				break;
			case Constantes.OP_UPDATE:
				recogerDatosAlumno(request);
				aService.update(alumno);
				break;
			default:
				LOG.trace("Se ha roto");
				break;
			}
			getAll(request);
		} catch (NumberFormatException e) {
			LOG.error(e.getMessage());
		} catch (NullPointerException e) {
			LOG.error(e.getMessage());
		} catch (Exception e) {
			LOG.error(e.getMessage());

		}
		rd.forward(request, response);
	}

	private void recogerDatosAlumno(HttpServletRequest request) throws CandidatoException {
		alumno = new Alumno();
		String nombre = request.getParameter(Constantes.PAR_NOMBRE);
		String dni = request.getParameter(Constantes.PAR_DNI);
		String apellidos = request.getParameter(Constantes.PAR_APELLIDOS);
		String genero = request.getParameter(Constantes.PAR_GENERO);
		String[] idiomas = request.getParameterValues(Constantes.PAR_IDIOMA);
		String idCurso = request.getParameter(Constantes.PAR_CURSO);
		List<Idioma> idi = Util.parseIdioma(idiomas);
		Curso curso = new Curso();
		curso.setCodigo(Integer.parseInt(idCurso));
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		LOG.trace("antes de mes");
		String day = request.getParameter(Constantes.PAR_DIA);
		String month = request.getParameter(Constantes.PAR_MES);
		String anyo = request.getParameter(Constantes.PAR_ANYO);
		LOG.trace(day);
		int mes = Integer.parseInt(month);
		int dia = Integer.parseInt(day);
		int year = Integer.parseInt(anyo);
		LOG.trace(mes);
		calendar.set(Calendar.MONTH, mes - 1);
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.DAY_OF_MONTH, dia);
		Date date = calendar.getTime();

		alumno.setCodigo(id);
		alumno.setNombre(nombre);
		alumno.setApellidos(apellidos);
		alumno.setDni(dni);
		alumno.setCurso(curso);
		alumno.setIdiomas(idi);
		alumno.setGenero(Util.parseGenero(genero));
		alumno.setfNacimiento(date);

	}

}
