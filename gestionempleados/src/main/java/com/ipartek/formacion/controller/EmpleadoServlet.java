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

import com.ipartek.formacion.pojo.Empleado;
import com.ipartek.formacion.service.EmpleadoService;
import com.ipartek.formacion.service.EmpleadoServiceImp;


/**
 * Servlet implementation class EmpleadoServlet
 */
public class EmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private RequestDispatcher rwd = null;
	 private int id = -1;   
	 private int operacion = -1;   
	 private Properties props = null;
	 private static EmpleadoService eService = EmpleadoServiceImp.getInstance();
	 private Empleado empleado = null;
	 private List<Empleado> empleados = null;
	 private static final Logger LOG = Logger.getLogger(EmpleadoServlet.class);		 
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
  			recogerId(request); 
  			request.setAttribute(props.getProperty("listadoEmpleados"), eService.getAll());
  			if(id<0){ //REDIRIGIMOS PARA UN CREATE
  				rwd = request.getRequestDispatcher(props.getProperty("jspEmpleados")); 
  			}else{ //REDIRIGIMOS PARA UNA UPDATE
  				getById(request); //si recibe un parametro (un id)hace getById
  			}
  		}
  		catch (Exception e){
  			getAll(request);//si lo anterior falla xq no recibe parametro (un id), entra aqui y hace getAll
  		}
  		
  		rwd.forward(request,response);
	}

	
	private void getById(HttpServletRequest request) {
		empleado = eService.getById(id);
  		request.setAttribute(props.getProperty("attEmpleado"), empleado);
  		rwd = request.getRequestDispatcher(props.getProperty("jspEmpleados"));
		
	}


	private void getAll(HttpServletRequest request) {
		empleados = eService.getAll();
  		request.setAttribute(props.getProperty("listadoEmpleados"), empleados);
  		rwd = request.getRequestDispatcher(props.getProperty("jspListaEmp"));
		
	}


	private void recogerId(HttpServletRequest request) {
		id = Integer.parseInt(request.getParameter(props.getProperty("parCodigo")));
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String op = request.getParameter(props.getProperty("parOperacion"));
			/*
			try{
				if(Util.tryParseInt(op)){
					operacion = Integer.parseInt(op);
				}
				
				recogerId(request);
				switch (operacion) {
				
				case 0:
						recogerDatos(request);
						eService.createEmpleado(empleado);
					break;
					
				case 2:
						recogerDatos(request);
						eService.updateEmpleado(empleado);
					break;
					
				case 3:
						eService.deleteEmpleado(id);
				break;
	
				default:
					break;
			}
				getAll(request);
					
			}catch(NumberFormatException e){
				LOG.error("number");
			}catch(NullPointerException e){
				LOG.error("null");
			}
	*/
		rwd.forward(request, response);
				
	}


	private void recogerDatos(HttpServletRequest request) {
		
		empleado = new Empleado();
		
		recogerId(request);
		
		String nombre = request.getParameter(props.getProperty("parNombre"));
		String apellidos = request.getParameter(props.getProperty("parApellidos"));
		String dni = request.getParameter(props.getProperty("parDni"));


		
	}

}
