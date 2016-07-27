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

import com.ipartek.formacion.pojo.Empleado;
import com.ipartek.formacion.service.EmpleadoService;
import com.ipartek.formacion.service.EmpleadoServiceImp;
import com.ipartek.formacion.service.Idioma;
import com.ipartek.formacion.service.Util;

/**
 * Servlet implementation class EmpleadoServlet
 */
public class EmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int id = -1;
	private RequestDispatcher rd = null;
	private EmpleadoService eService = EmpleadoServiceImp.getInstance();
	private List<Empleado> empleados = null;
	private Empleado empleado = null;
	private int operacion = -1;
	private final static Logger LOG = Logger.getLogger(EmpleadoServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpleadoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

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
			LOG.fatal(e.getMessage());
			getAll(request);
		}
		rd.forward(request, response);
	}

	private void recogerId(HttpServletRequest request) {
		// if (Util.tryParseInt(request.getParameter(Constantes.PAR_CODIGO))){
		id = Integer.parseInt(request.getParameter(Constantes.PAR_CODIGO));
		// }
	}

	private void getAll(HttpServletRequest request) {
		empleados = eService.getAll();
		request.setAttribute(Constantes.ATT_LISTADO_ALUMNOS, empleados);
		rd = request.getRequestDispatcher(Constantes.JSP_LISTADO_ALUMNOS);
	}

	private void getById(HttpServletRequest request) {
		empleado = eService.getById(id);
		request.setAttribute(Constantes.ATT_ALUMNO, empleado);
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
			switch (operacion) {
			case Constantes.OP_CREATE:
				recogerDatosAlumno(request);
				eService.createEmpleado(empleado);
				break;
			case Constantes.OP_DELETE:
				eService.delete(id);
				break;
			case Constantes.OP_UPDATE:
				recogerDatosAlumno(request);
				eService.update(empleado);
				break;
			default:
				LOG.error("No entra por CRUD");
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

	private void recogerDatosAlumno(HttpServletRequest request) {
		empleado = new Empleado();
		String nombre = request.getParameter(Constantes.PAR_NOMBRE);
		String dni = request.getParameter(Constantes.PAR_DNI);
		String apellidos = request.getParameter(Constantes.PAR_APELLIDOS);
		String[] idiomas = request.getParameterValues(Constantes.PAR_IDIOMA);
		List<Idioma> idi = Util.parseIdioma(idiomas);
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		String day = request.getParameter(Constantes.PAR_DIA);
		String month = request.getParameter(Constantes.PAR_MES);
		String anyo = request.getParameter(Constantes.PAR_ANYO);
		int mes = Integer.parseInt(month);
		int dia = Integer.parseInt(day);
		int year = Integer.parseInt(anyo);
		calendar.set(Calendar.MONTH, mes - 1);
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.DAY_OF_MONTH, dia);
		Date date = calendar.getTime();

		empleado.setCodigo(id);
		empleado.setNombre(nombre);
		empleado.setApellidos(apellidos);
		empleado.setDNI(dni);
		empleado.setIdiomas(idi);
		empleado.setfNacimiento(date);

	}

}
