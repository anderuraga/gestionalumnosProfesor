package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.service.DepartamentoService;
import com.ipartek.formacion.service.DepartamentoServiceImp;

/**
 * Servlet implementation class DepartamentoServlet
 */
public class DepartamentoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private Logger LOG = Logger.getLogger(DepartamentoServlet.class);
  private Properties props = null;
  private DepartamentoService dService = DepartamentoServiceImp.getInstance();
  private RequestDispatcher rd = null;

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      int id = Integer.parseInt(request.getParameter(props.getProperty("id")));
    } catch (Exception e) {
      getAll(request);
    }
    rd.forward(request, response);
  }

  private void getAll(HttpServletRequest request) {
    request.setAttribute(props.getProperty("listadoDep"), dService.getAll());
    rd = request.getRequestDispatcher(props.getProperty("listadoDepartamentoJSP"));
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
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
   */
  public void init() throws ServletException {
    props = (Properties) getServletContext().getAttribute("constantes");
    super.init();
  }

}
