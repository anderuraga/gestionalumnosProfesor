package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.pojo.Departamento;
import com.ipartek.formacion.pojo.Empleado;
import com.ipartek.formacion.service.DepartamentoService;
import com.ipartek.formacion.service.DepartamentoServiceImp;
import com.ipartek.formacion.service.EmpleadoService;
import com.ipartek.formacion.service.EmpleadoServiceImp;

/**
 * Servlet implementation class EmpleadoServlet
 */
public class EmpleadoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private Logger LOG = Logger.getLogger(EmpleadoServlet.class);
  private Properties props = null;
  private RequestDispatcher rd = null;
  private Empleado emp = null;
  private EmpleadoService eService = EmpleadoServiceImp.getInstance();
  private DepartamentoService dService = DepartamentoServiceImp.getInstance();
  private int id = 0;

  /**
   * @Override
   */
  public void destroy() {
    props = null;
    super.destroy();
  }

  @Override
  public void init() throws ServletException {
    props = (Properties) getServletContext().getAttribute("constantes");
    super.init();
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      id = Integer.parseInt(request.getParameter(props.getProperty("id")));
      if (id > 0) {
        cargarListadoDepartamentos(request);
        getById(request);
      } else {
        rd = request.getRequestDispatcher(props.getProperty("empleadoJSP"));
      }
    } catch (Exception e) {
      getAll(request);
    }
    rd.forward(request, response);
  }

  private void getById(HttpServletRequest request) {

    request.setAttribute(props.getProperty("attEmp"), eService.getById(id));
    rd = request.getRequestDispatcher(props.getProperty("empleadoJSP"));
  }

  private void getAll(HttpServletRequest request) {
    request.setAttribute(props.getProperty("listadoEmpleados"), eService.getAll());
    rd = request.getRequestDispatcher(props.getProperty("listadoEmpleadoJSP"));

  }

  private void cargarListadoDepartamentos(HttpServletRequest request) {
    List<Departamento> departamentos = new ArrayList<Departamento>();
    departamentos = dService.getAll();
    request.setAttribute(props.getProperty("listadoDep"), departamentos);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    cargarListadoDepartamentos(request);
    recogerParametros(request);
    try {
      eService.create(emp);
    } catch (Exception e) {
      LOG.error(e.getMessage());
    }
    response.sendRedirect(props.getProperty("empleadoServlet"));
    // rd = request.getRequestDispatcher(props.getProperty("empleadoServlet"));
    // rd.forward(request, response);

  }

  private void recogerParametros(HttpServletRequest request) {
    emp = new Empleado();
    emp.setNombre(request.getParameter(props.getProperty("parNombre")));
    emp.setApellidos(request.getParameter(props.getProperty("parApellidos")));
    emp.setDni(request.getParameter(props.getProperty("parDni")));
    Date fNacimiento = parseFecha(request.getParameter(props.getProperty("parFNacimiento")));
    emp.setfNacimiento(fNacimiento);
    Date fContratacion = parseFecha(request.getParameter(props.getProperty("parFContratacion")));
    emp.setfContratacion(fContratacion);
    emp.setnSeguridadSocial(request.getParameter(props.getProperty("parSS")));
    emp.setnCuentaBancaria(request.getParameter(props.getProperty("parCC")));
    emp.setDireccion(request.getParameter(props.getProperty("parDireccion")));
    emp.setLocalidad(request.getParameter(props.getProperty("parLocalidad")));
    emp.setCodigoPostal(request.getParameter(props.getProperty("parCP")));
    Departamento dep = new Departamento();
    dep.setCodigo(Integer.parseInt(request.getParameter(props.getProperty("parCodDep"))));
    emp.setDepartamento(dep);

  }

  private Date parseFecha(String fecha) {
    GregorianCalendar gc = new GregorianCalendar();
    String[] valores = fecha.split("-");
    int year = Integer.parseInt(valores[0]);
    int mes = Integer.parseInt(valores[1]) - 1;
    int dia = Integer.parseInt(valores[2]);
    gc.set(year, mes, dia);
    return gc.getTime();
  }
}
