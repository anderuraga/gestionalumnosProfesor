package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.pojo.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final Logger log = Logger.getLogger(LoginServlet.class);
	 private static final long serialVersionUID = 1L;  
	 private RequestDispatcher rwd = null;
	 private HttpSession session = null;
	 private Usuario usuario = null;
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
		
	public LoginServlet() {
		  super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}


	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(usuario != null && "marta".equals(usuario.getUserName()) && "marta".equals(usuario.getPassword())){
			procesarLogin(request);
			rwd.forward(request, response);
		}else{
			
		}
		
	}


	private void procesarLogin(HttpServletRequest request) {

		createSession(request);
		usuario.setIdSession(session.getId());
		//session.setAttribute(Constantes.ATT_USUARIO, usuario);
		rwd = request.getRequestDispatcher("index.jsp");
		
	}


	private void createSession(HttpServletRequest request) {
		session = request.getSession(true); 
		session.setMaxInactiveInterval(60*60*15);
		
	}

}
