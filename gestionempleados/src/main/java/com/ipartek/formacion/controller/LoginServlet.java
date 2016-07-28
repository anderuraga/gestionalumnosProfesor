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
  private static final Logger LOG = Logger.getLogger("ACCESOS");
  private Properties props = null;
  private RequestDispatcher rd = null;
  private Usuario user = null;
  private HttpSession session = null;

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

  private void doProcess(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    recogerParametros(request);
    if ("".equals(user.getUsername()) && "".equals(user.getPassword())) {
      procesarLogin(request);
      rd.forward(request, response);
    } else {
      LOG.error("Usuario y/o contraseña incorrecta");
    }

  }

  private void procesarLogin(HttpServletRequest request) {
    createSession(request);
    user.setIdSession(session.getId());
    session.setAttribute(props.getProperty("attUsuario"), user);
    rd = request.getRequestDispatcher(props.getProperty("empleadoJSP"));
  }

  private void createSession(HttpServletRequest request) {
    session = request.getSession(true);
    session.setMaxInactiveInterval(60 * 60 * 10);

  }

  private void recogerParametros(HttpServletRequest request) {
    user = new Usuario();
    user.setUsername(request.getParameter(props.getProperty("username")));
    user.setPassword(request.getParameter(props.getProperty("password")));
  }

  /**
   * @Override
   */
  public void destroy() {
    props = null;
    super.destroy();
  }

  /**
   * @Override
   * @throws ServletException
   *           Excepcion al inicializar el servlet <code>LoginServlet</code>.
   */
  public void init() throws ServletException {
    props = (Properties) getServletContext().getAttribute("constantes");
    super.init();
  }

}
