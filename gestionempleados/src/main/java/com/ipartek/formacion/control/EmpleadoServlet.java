package com.ipartek.formacion.control;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

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
	private Properties props = null;

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

				rd = request.getRequestDispatcher(props.getProperty("JSPempleado"));
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
		id = Integer.parseInt(request.getParameter(props.getProperty("parCodigo")));
		// }
	}

	private void getAll(HttpServletRequest request) {
		empleados = eService.getAll();
		request.setAttribute(props.getProperty("listadoEmpleado"), empleados);
		rd = request.getRequestDispatcher(props.getProperty("JSPlistadoEmpleados"));
	}

	private void getById(HttpServletRequest request) {
		empleado = eService.getById(id);
		request.setAttribute(props.getProperty("attEmpleado"), empleado);
		rd = request.getRequestDispatcher(props.getProperty("JSPempleado"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter(props.getProperty("parOperacion"));

		try {
			if (Util.tryParseInt(op)) {
				operacion = Integer.parseInt(op);
			}
			recogerId(request);
			switch (operacion) {
			case 1: // case props.getProperty("opCreate"):
				recogerDatosEmpleado(request);
				eService.createEmpleado(empleado);
				break;
			case 3: // props.getProperty("opDelete"):
				eService.delete(id);
				break;
			case 2: // props.getProperty("opUpdate"):
				recogerDatosEmpleado(request);
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

	private void recogerDatosEmpleado(HttpServletRequest request) {
		empleado = new Empleado();
		String nombre = request.getParameter(props.getProperty("parNombre"));
		String dni = request.getParameter(props.getProperty("parDni"));
		String apellidos = request.getParameter(props.getProperty("parApellidos"));
		String localidad = request.getParameter(props.getProperty("parLocalidad"));
		String direccion = request.getParameter(props.getProperty("parDireccion"));
		int cp = Integer.parseInt(request.getParameter(props.getProperty("parCP")));
		int nss = Integer.parseInt(request.getParameter(props.getProperty("parNSS")));
		int cc = Integer.parseInt(request.getParameter(props.getProperty("parCC")));
		String[] idiomas = request.getParameterValues(props.getProperty("parIdiomas"));
		List<Idioma> idi = Util.parseIdioma(idiomas);
		// Departamento departamento = Util.
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		String day = request.getParameter(props.getProperty("parDia"));
		String month = request.getParameter(props.getProperty("parMes"));
		String anyo = request.getParameter(props.getProperty("parYear"));
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
		// empleado.setIdiomas(idi);
		empleado.setfNacimiento(date);
		empleado.setfContratacion(date);
		empleado.setDireccion(direccion);
		empleado.setLocalidad(localidad);
		empleado.setCC(cc);
		empleado.setCP(cp);
		empleado.setNSS(nss);
		// empleado.setDepartamento(departamento);

	}

}
