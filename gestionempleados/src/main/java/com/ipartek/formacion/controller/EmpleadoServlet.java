package com.ipartek.formacion.controller;

/**
 * Servlet de Empleado
 */

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class EmpleadoServlet
 */
public class EmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = Logger.getLogger(EmpleadoServlet.class);
	
	private RequestDispatcher rwd = null;
	private int id = -1;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpleadoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void recogerId(HttpServletRequest request) {
		//id = Integer.parseInt(request.getParameter(Constantes.PAR_CODIGO));
		LOG.trace("id/codigo del alumno: " + id);
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
				rwd = request.getRequestDispatcher("empleados/listadoEmpleados.jsp");
			} else{
				// Se redirige para realizar un UPDATE
				//getById(request);
			}
		} 		
		catch(Exception e){
			//getAll(request);
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
