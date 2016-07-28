package com.ipartek.formacion.empleado.ProyectoGestionEmpleado.controller;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.empleado.ProyectoGestionEmpleado.pojo.Empleado;
import com.ipartek.formacion.empleado.ProyectoGestionEmpleado.service.EmpleadoService;
import com.ipartek.formacion.empleado.ProyectoGestionEmpleado.service.EmpleadoServiceImp;

/**
 * Servlet implementation class EmpleadoServlet
 */
public class EmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RequestDispatcher rwd;
	private static final Logger LOG = Logger.getLogger(EmpleadoServlet.class);
	private Properties properties = null;
	
	private static EmpleadoService eService = EmpleadoServiceImp.getInstance();
	
	private List<Empleado> empleados = null;
       
	
	
    @Override
	public void destroy() {
    	properties = null;
    	super.destroy();
	}

	@Override
	public void init() throws ServletException {
		properties = (Properties) getServletContext().getAttribute("properties");
		super.init();
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public EmpleadoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		cargarEmpleados(request);
		rwd.forward(request, response);
	}
	
	private void cargarEmpleados(HttpServletRequest request)
	{
		empleados = eService.getAll();
		request.setAttribute(properties.getProperty("listadoEmpleado"), empleados);
		rwd = request.getRequestDispatcher(properties.getProperty("jspListaEmpleados"));
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
