package com.ipartek.formacion.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.pojo.Departamento;
import com.ipartek.formacion.pojo.Empleado;
import com.ipartek.formacion.service.DepartamentoService;
import com.ipartek.formacion.service.DepartamentoServiceImp;
import com.ipartek.formacion.service.EmpleadoService;
import com.ipartek.formacion.service.EmpleadoServiceImp;

/**
 * Servlet implementation class EmpleServlet
 */
public class EmpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int id = -1;
	private int operacion = -1;
	private RequestDispatcher rd = null;
	private EmpleadoService eService = EmpleadoServiceImp.getInstance();
	private DepartamentoService dService = DepartamentoServiceImp.getInstance();
	private List<Empleado> empleados = null;
	private Empleado emple = null;
	private Departamento dpto = null;
	private final static Logger LOG = Logger.getLogger(EmpleServlet.class);
	private Properties props = null;

	@Override
	public void destroy() {
		props = null;
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		props = (Properties) getServletContext().getAttribute("properties");
		super.init();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			recogerId(request);
			if (this.id < 0) {
				rd = request.getRequestDispatcher(props.getProperty("emples.jsp"));
			} else {
				getById(request);
			}
		} catch (Exception e) {
			getAll(request);
		}
		rd.forward(request, response);
	}

	private void getAll(HttpServletRequest request) {
		empleados = eService.getAll();
		request.setAttribute(props.getProperty("listaemples.att"), empleados);
		rd = request.getRequestDispatcher(props.getProperty("listadoEmple.jsp"));

	}

	private void getById(HttpServletRequest request) {
		emple = eService.getById(id);
		request.setAttribute(props.getProperty("emple.att"), emple);
		rd = request.getRequestDispatcher(props.getProperty("emples.jsp"));
	}

	private void recogerId(HttpServletRequest request) {
		id = Integer.parseInt(props.getProperty("codigo.par"));

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter(props.getProperty("operacion.par"));

		try {

			operacion = Integer.parseInt(op);

			switch (operacion) {
			case 0:
				recogerDatos(request);
				eService.createEmple(emple);
				break;
			case 3:
				recogerId(request);
				eService.deleteEmple(id);
				break;
			case 2:
				recogerDatos(request);
				eService.updateEmple(emple);
				break;
			}
		} catch (NumberFormatException e) {
			LOG.error(e.getMessage());
		}

		getAll(request);
		rd.forward(request, response);
	}

	private void recogerDatos(HttpServletRequest request) {
		emple = new Empleado();
		recogerId(request);
		emple.setCodEmple(id);
		String nombre = request.getParameter(props.getProperty("nombre.par"));
		emple.setNombre(nombre);
		String apellidos = request.getParameter(props.getProperty("apellidos.par"));
		emple.setApellidos(apellidos);

		String diaNacm = request.getParameter(props.getProperty("dia.par"));
		String mesNacim = request.getParameter(props.getProperty("mes.par"));
		String anioNacim = request.getParameter("anyo.par");

		SimpleDateFormat sdfNacim = new SimpleDateFormat("yyyy-MM-dd");
		String fechaStringNacim = anioNacim + "-" + mesNacim + "-" + diaNacm;
		Date fechaNacim = null;

		String diaContrat = request.getParameter(props.getProperty("dia.par"));
		String mesContrat = request.getParameter(props.getProperty("mes.par"));
		String anioContrat = request.getParameter("anyo.par");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fechaString = anioContrat + "-" + mesContrat + "-" + diaContrat;
		Date fechaContrat = null;
		try {
			fechaNacim = sdfNacim.parse(fechaStringNacim);
			fechaContrat = sdf.parse(fechaString);
		} catch (ParseException e) {
			LOG.error(e.getMessage());
		}

		String nss = request.getParameter(props.getProperty("nss.par"));
		emple.setNumSS(nss);
		String cCorriente = request.getParameter(props.getProperty("cuentacorriente.par"));
		emple.setCuentaCorriente(cCorriente);
		String direccion = request.getParameter(props.getProperty("direccion.par"));
		emple.setDireccion(direccion);
		String localidad = request.getParameter(props.getProperty("localidad.par"));
		emple.setLocalidad(localidad);
		int cp = Integer.parseInt(request.getParameter(props.getProperty("cp.par")));
		emple.setCp(cp);
		String dni = request.getParameter(props.getProperty("dni.par"));
		emple.setDni(dni);
		dpto = new Departamento();
		int codDpto = Integer.parseInt(request.getParameter(props.getProperty("dpto.par")));
		dpto.setCodDept(codDpto);

		emple.setDpto(dpto);
	}

}
