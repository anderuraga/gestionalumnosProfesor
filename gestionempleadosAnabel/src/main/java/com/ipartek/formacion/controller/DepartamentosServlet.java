package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DepartamentosServlet
 */
public class DepartamentosServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private int id = -1;
  private int operacion = -1;
  private Properties props = null;

  @Override
  public void init() throws ServletException {
    this.props = (Properties) getServletContext().getAttribute("properties");
    super.init();
  }

  /**
   * Metodo que se va a encargar de mostrar los departamentos, bien sea solo un departamento
   * (getById) o el listado de todos los departamentos (getAll).
   * 
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    this.recogerId(request);
  }

  private void recogerId(HttpServletRequest request) {

    // int id = Integer.parseInt(request.getParameter(parCodigo));

  }

  /**
   * Metodo que se va a encargar del resto de operaciones, es decir, crear, eliminar o modificar un
   * departamento.
   * 
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  }

}
