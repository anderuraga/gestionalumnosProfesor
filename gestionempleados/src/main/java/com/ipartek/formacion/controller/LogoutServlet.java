package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Properties props = null;
       
	
	@Override
	public void init() throws ServletException {
		props = (Properties) getServletContext().getAttribute("constantes");
		super.init();
	}
	
	@Override
	public void destroy() {
		props = null;
		super.destroy();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession(false);
		
		if(session != null && session.getAttribute(props.getProperty("attUsuario"))!= null){
			session.invalidate(); //borra la sesion
			
		}
	
		response.sendRedirect("index.jsp");
		
	}

}
