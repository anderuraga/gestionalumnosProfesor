package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.pojo.Empleado;
import com.ipartek.formacion.service.EmpleadoService;
import com.ipartek.formacion.service.EmpleadoServiceImp;

/**
 * Servlet implementation class EmpleadoServlet
 */
public class EmpleadoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private Properties prop = null;
  private int id = -1;
  private RequestDispatcher rd = null;
  private EmpleadoService empleadoService = new EmpleadoServiceImp();
  private int operacion = -1;
  private Empleado empleado;

  /**
   * @see Servlet#init(ServletConfig)
   */
  public void init(ServletConfig config) throws ServletException {
    prop = (Properties) getServletContext().getAttribute("properties");
    super.init();
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) Este metodo va
   *      a sacar tanto la el getAll como el getById.
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    this.id = this.recogerId(request);

    try {
      if (this.id < 0) {
        this.rd = request.getRequestDispatcher(this.prop.getProperty("JSP_empleado"));
      } else {
        this.getById(request);
      }
    } catch (Exception e) {
      this.getAll(request);
    }
  }

  private void getAll(HttpServletRequest request) {

    List<Empleado> empleados = this.empleadoService.getAll();
    request.setAttribute(this.prop.getProperty("ATT_listado_empleado"), empleados);
    this.rd = request.getRequestDispatcher(this.prop.getProperty("JSP_lista_empleado"));
  }

  private void getById(HttpServletRequest request) {

    Empleado empleado = this.empleadoService.getById(id);
    request.setAttribute(this.prop.getProperty("ATT_empleado"), empleado);
    this.rd = request.getRequestDispatcher(this.prop.getProperty("JSP_empleado"));
  }

  private int recogerId(HttpServletRequest request) {

    this.id = Integer.parseInt(request.getParameter(this.prop.getProperty("parCodigo")));
    return this.id;
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) Este metodo
   *      por el contrario, hara el create, delete y update.
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    this.operacion = Integer.parseInt(request.getParameter(this.prop.getProperty("parOperacion")));
    switch (operacion) {
    case 0:
      cargarEmpleado(request);
      break;
    case 2:
      break;
    case 3:
      break;
    default:
      break;
    }

  }

  private void cargarEmpleado(HttpServletRequest request) {
    this.empleado = new Empleado();
    this.empleado.setCodigo(Integer.parseInt(request.getParameter(this.prop
        .getProperty("parCodigo"))));
    this.empleado.setApellidos(request.getParameter(this.prop.getProperty("parApellidos")));
    this.empleado.setNombre(request.getParameter(this.prop.getProperty("parNombre")));
    this.empleado.setDireccion(request.getParameter(this.prop.getProperty("parDireccion")));
    this.empleado
        .setDNI(request.getParameter(request.getParameter(this.prop.getProperty("parDni"))));
    this.empleado.setLocalidad(request.getParameter(this.prop.getProperty("parLocalidad")));
    this.empleado.setCodigoPostal(Integer.parseInt(request.getParameter(this.prop
        .getProperty("parCP"))));
    this.empleado.setCuentaCorriente(Integer.parseInt(request.getParameter(this.prop
        .getProperty("parCC"))));
    this.empleado.setSegSocial(Integer.parseInt(request.getParameter(this.prop
        .getProperty("parSegSocial"))));
    // FALTAN LAS FECHAS Y EL DEPARTAMENTO

  }

}
