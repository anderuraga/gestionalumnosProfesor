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
	private static final long serialVersionUID = 1L;
	private Usuario dummy=null;
	private RequestDispatcher rwd=null;
	private HttpSession session=null;
	private String nUsuario="";
	private String pass="";
	private static final Logger LOG=Logger.getLogger(LoginServlet.class);
	private Properties props=null;
	
	
	
	
	
	
       
    /* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#destroy()
	 */
	@Override
	public void destroy() {
		props=null;
		super.destroy();
	}

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {
		props=(Properties)getServletContext().getAttribute("properties");
		super.init();
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doProcess(request,response);
	
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
//		if (request.getParameter(Constantes.PAR_USER)!=null) {
//			cargarParametros(request);
//		}
		
		
	}

	private void cargarParametros(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
