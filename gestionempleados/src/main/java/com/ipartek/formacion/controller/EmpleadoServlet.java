package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.pojo.Departamento;
import com.ipartek.formacion.pojo.Empleado;
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

    rd = request.getRequestDispatcher(props.getProperty("empleadoJSP"));
    rd.forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    recogerParametros(request);
    try {
      eService.create(emp);
    } catch (Exception e) {
      LOG.error(e.getMessage());
    }
    rd = request.getRequestDispatcher(props.getProperty("empleadoJSP"));
    rd.forward(request, response);

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
    LOG.info(fecha);
    GregorianCalendar gc = new GregorianCalendar();
    String[] valores = fecha.split("-");
    int year = Integer.parseInt(valores[0]);

    int mes = Integer.parseInt(valores[1]) - 1;
    int dia = Integer.parseInt(valores[2]);

    gc.set(year, mes, dia);
    return gc.getTime();

  }
}
