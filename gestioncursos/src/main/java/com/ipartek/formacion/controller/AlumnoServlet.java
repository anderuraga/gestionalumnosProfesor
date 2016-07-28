package com.ipartek.formacion.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.controller.exception.AlumnoError;
import com.ipartek.formacion.pojo.Alumno;
import com.ipartek.formacion.pojo.Curso;
import com.ipartek.formacion.pojo.Idioma;
import com.ipartek.formacion.pojo.exception.CandidatoException;
import com.ipartek.formacion.service.AlumnoService;
import com.ipartek.formacion.service.AlumnoServiceImp;
import com.ipartek.formacion.service.CursoService;
import com.ipartek.formacion.service.CursoServiceImp;
import com.ipartek.formacion.service.Util;

/**
 * Servlet implementation class AlumnoServlet
 */
public class AlumnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static AlumnoService aService = new AlumnoServiceImp().getInstance();
	private RequestDispatcher rwd = null;
	private List<Alumno> alumnos = null;
	private Alumno alumno = null;
	private int id = -1;
	private int operacion = -1;
	private CursoService cService = new CursoServiceImp();
	
	private static final Logger LOG = Logger.getLogger(AlumnoServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlumnoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		try{
			//id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute(Constantes.ATT_LISTADO_CURSOS, cService.getAll());
			recogerId(request);
			
			if(id < 0){
				// Se redirige para realizar un CREATE
				rwd = request.getRequestDispatcher(Constantes.JSP_ALUMNO);
			} else{
				// Se redirige para realizar un UPDATE
				getById(request);
			}
		} 		
		catch(Exception e){
			getAll(request);
		}

		rwd.forward(request, response);
	}
	
	private void getAll(HttpServletRequest request) {
		alumnos = aService.getAll();
		request.setAttribute(Constantes.ATT_LISTADO_ALUMNOS, alumnos);
		rwd = request.getRequestDispatcher(Constantes.JSP_LISTADO_ALUMNOS);
	}

	private void getById(HttpServletRequest request) {
		alumno = aService.getById(id);
		request.setAttribute(Constantes.ATT_ALUMNO, alumno);
		rwd = request.getRequestDispatcher(Constantes.JSP_ALUMNO);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter(Constantes.PAR_OPERACION);
		
		try {
			if(Util.tryParseInt(op)){
				operacion = Integer.parseInt(op);
			}

			recogerId(request);
			
			switch(operacion){
				case Constantes.OP_CREATE:
					// CREATE
					recogerDatosAlumno(request);
					aService.createAlumno(alumno);
					break;
				
				case Constantes.OP_DELETE:
					// DELETE
					aService.delete(id);
					break;
					
				case Constantes.OP_UPDATE:
					// UPDATE
					recogerDatosAlumno(request);
					aService.update(alumno);
					break;
				
				default:
					break;
			}
			getAll(request);
		} catch(NumberFormatException e){
			LOG.error("Error NumberFormatException: " + e.getMessage());
		} catch(CandidatoException e){
			// Hay un error en los datos que se nos envia
			try {
				AlumnoError alumnoError = new AlumnoError();
				alumnoError = recogerDatosError(request);
				alumnoError.setMensaje(e.getMessage());
				request.setAttribute(Constantes.ATT_ALUMNO, alumnoError);
				rwd = request.getRequestDispatcher(Constantes.JSP_ALUMNO);
			} catch (CandidatoException e1) {
				LOG.error("Error CandidatoException 1: " + e1.getMessage());
			}
			LOG.error("Error CandidatoException 2: " + e.getMessage());
		} catch (NullPointerException e) {
			LOG.error("Error NullPointerException: " + e.getMessage());
		} catch (Exception e) {
			LOG.error("Error Exception: " + e.getMessage());
		}
		rwd.forward(request, response);
	}

	private AlumnoError recogerDatosError(HttpServletRequest request) throws CandidatoException {
		AlumnoError alError = new AlumnoError();
		
		alError.setCodigo(id);
		
		String nombre = request.getParameter(Constantes.PAR_NOMBRE);
		alError.setNombre(nombre);
		
		String apellidos = request.getParameter(Constantes.PAR_APELLIDOS);
		alError.setApellidos(apellidos);
		
		String dni = request.getParameter(Constantes.PAR_DNI);
		alError.setDni(dni);
		
		return alError;
	}

	private void recogerId(HttpServletRequest request) {
		id = Integer.parseInt(request.getParameter(Constantes.PAR_CODIGO));
		LOG.trace("id/codigo del alumno: " + id);
	}

	private void recogerDatosAlumno(HttpServletRequest request) throws CandidatoException {
		alumno = new Alumno();
		
		alumno.setCodigo(id);
		
		String nombre = request.getParameter(Constantes.PAR_NOMBRE);
		alumno.setNombre(nombre);
		
		String apellidos = request.getParameter(Constantes.PAR_APELLIDOS);
		alumno.setApellidos(apellidos);
		
		String dni = request.getParameter(Constantes.PAR_DNI);
		alumno.setDni(dni);
		
		String dia = request.getParameter(Constantes.PAR_DIA);
		String mes = request.getParameter(Constantes.PAR_MES);
		String anno = request.getParameter(Constantes.PAR_ANYO);
		String fecha = dia + "/" + mes + "/" + anno;
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;

		try {
			date = formatter.parse(fecha);
			//System.out.println(date);
			//System.out.println(formatter.format(date));

		} catch (ParseException e) {
			// LOG DE ERRORES
			LOG.error(e.getMessage());
		}
		
		alumno.setfNacimiento(date);
		
		String genero = request.getParameter(Constantes.PAR_GENERO);
		alumno.setGenero(Util.parseGenero(genero));
		
		String[] idiomas = request.getParameterValues(Constantes.PAR_IDIOMA);
		List<Idioma> idi = Util.parseIdioma(idiomas);
		alumno.setIdiomas(idi);
		
		String idCurso = request.getParameter(Constantes.PAR_CURSO);
		Curso curso = new Curso();
		curso.setCodigo(Integer.parseInt(idCurso));
		alumno.setCurso(curso);
		
		String email = request.getParameter(Constantes.PAR_EMAIL);
		alumno.setEmail(email);
		
		String telefono = request.getParameter(Constantes.PAR_TELEFONO);
		alumno.setTelefono(telefono);
	}

}
