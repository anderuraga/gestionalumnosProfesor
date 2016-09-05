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

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final Logger LOG = Logger.getLogger("ACCESOS");
  private Properties props = null;
  private String username = "";
  private String password = "";
  private RequestDispatcher rd = null;
  private Usuario user = null;
  private HttpSession sesion = null;
  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doProcess(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doProcess(request, response);
  }

  private void doProcess(HttpServletRequest request, HttpServletResponse response) {
    recogerParametros(request);

  }

  /**
   * cargar archivo de properties al arrancar la aplicación.
   */
   public void init() throws ServletException {
 	  props = (Properties) getServletContext().getAttribute("properties");
 	  super.init();
   }
   
   /**
    * recoger parámetros de properties.
    * @param request
    */
   private void recogerParametros(HttpServletRequest request) {
    username = request.getParameter(props.getProperty("username"));
    password = request.getParameter(props.getProperty("password"));
  }

  /**
   * @Override
   */
  public void destroy() {
    props = null;
    super.destroy();
  }

  private void procesarLogin(HttpServletRequest request) {
	    createSession(request);
	    user.setIdSession(sesion.getId());
	    sesion.setAttribute(props.getProperty("username"), user);
	    rd=request.getRequestDispatcher(props.getProperty("empleado.jsp"));
	    
	  }

  private void createSession(HttpServletRequest request) {
	    sesion = request.getSession(true);
	    

	  }
 

}
