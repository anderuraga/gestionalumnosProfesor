package com.ipartek.formacion.controller;

import java.io.IOException;
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
 * Servlet implementation class DepartServlet
 */
public class DepartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int operacion = -1;
	private int id = -1;
	private RequestDispatcher rd = null;
	private EmpleadoService eService = EmpleadoServiceImp.getInstance();
	private DepartamentoService dService = DepartamentoServiceImp.getInstance();
	private List<Empleado> empleados = null;
	private List<Departamento> departamentos = null;
	private Empleado emple = null;
	private Departamento dpto = null;
	private final static Logger LOG = Logger.getLogger(DepartServlet.class);
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
				rd = request.getRequestDispatcher(props.getProperty("dpto.jsp"));
			} else {
				getById(request);
			}
		} catch (Exception e) {
			getAll(request);
		}
		rd.forward(request, response);
	}

	private void getAll(HttpServletRequest request) {
		departamentos = dService.getAll();
		request.setAttribute(props.getProperty("listadptos.att"), departamentos);
		rd = request.getRequestDispatcher(props.getProperty("listadodptos.jsp"));
	}

	private void getById(HttpServletRequest request) {
		dpto = dService.getById(id);
		request.setAttribute(props.getProperty("dpto.att"), dpto);
		rd = request.getRequestDispatcher(props.getProperty("dpto.jsp"));
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
		dpto = new Departamento();
		recogerId(request);
		dpto.setCodDept(id);
		String nombre = request.getParameter(props.getProperty("nombre.par"));
		dpto.setNombre(nombre);
		String descripcion = request.getParameter(props.getProperty("descripcion.par"));
		dpto.setDescripcion(descripcion);
		// emples???

	}

}
