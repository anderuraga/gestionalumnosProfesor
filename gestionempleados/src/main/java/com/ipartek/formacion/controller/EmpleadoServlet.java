package com.ipartek.formacion.controller;

/**
 * Servlet de Empleado
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.controller.listener.InitListener;
import com.ipartek.formacion.pojo.Empleado;
import com.ipartek.formacion.service.EmpleadoService;
import com.ipartek.formacion.service.EmpleadoServiceImp;

/**
 * Servlet implementation class EmpleadoServlet
 */
public class EmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = Logger.getLogger(EmpleadoServlet.class);
	
	private RequestDispatcher rwd = null;
	private int id = -1;
	private Properties props = null;
	private static EmpleadoService eService = new EmpleadoServiceImp().getInstance();
	private Empleado empleado = null;
	private List<Empleado> empleados = null;
	
	@Override
	public void destroy() {
		props = null;
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		props = (Properties) getServletContext().getAttribute(InitListener.PROPS_NAME);
		super.init();
	}

	private void recogerId(HttpServletRequest request) {
		id = Integer.parseInt(request.getParameter(props.getProperty("parCodigo")));
		LOG.trace("id/codigo del alumno: " + id);
	}
    
    private void getAll(HttpServletRequest request) {
		empleados = eService.getAll();
		request.setAttribute(props.getProperty("listadoEmpleados"), empleados);
		rwd = request.getRequestDispatcher(props.getProperty("JSPlistadoEmpleados"));
	}

	private void getById(HttpServletRequest request) {
		empleado = eService.getById(id);
		request.setAttribute(props.getProperty("attEmpleado"), empleado);
		rwd = request.getRequestDispatcher(props.getProperty("JSPempleado"));
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			//request.setAttribute(Constantes.ATT_LISTADO_CURSOS, cService.getAll());
			recogerId(request);
			
			if(id < 0){
				// Se redirige para realizar un CREATE
				rwd = request.getRequestDispatcher(props.getProperty("JSPempleado"));
			} else{
				// Se redirige para realizar un UPDATE
				getById(request);
			}
		} catch(Exception e){
			// Visualizamos todos
			getAll(request);
		}

		rwd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
