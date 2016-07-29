package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.pojo.Departamento;
import com.ipartek.formacion.service.DepartamentoService;
import com.ipartek.formacion.service.DepartamentoServiceImp;

/**
 * Servlet implementation class DepartamentosServlet
 */
public class DepartamentosServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private int id = -1;
  private int operacion = -1;
  private Properties props = null;
  private RequestDispatcher rd = null;
  private DepartamentoService dService = new DepartamentoServiceImp();
  private Departamento departamento = null;
  private static final Logger LOG = Logger.getLogger(DepartamentosServlet.class);

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
    try {
      if (this.id < 0) {// TE REDIRIGE A UN CREATE
        this.rd = request.getRequestDispatcher(this.props.getProperty("JSP_departamento"));
      } else {// TE REDIRIGE A UN UPDATE
        this.getById(request);
      }
    } catch (Exception e) {
      this.getAll(request);
    }
    this.rd.forward(request, response);
  }

  private void getAll(HttpServletRequest request) {
    List<Departamento> departamentos = this.dService.getAll();
    request.setAttribute(this.props.getProperty("ATT_listado_departamento"), departamentos);
    this.rd = request.getRequestDispatcher(this.props.getProperty("JSP_departamento"));
  }

  private void getById(HttpServletRequest request) {
    Departamento departamento = this.dService.getById(this.id);
    request.setAttribute(this.props.getProperty("ATT_departamento"), departamento);
    this.rd = request.getRequestDispatcher(this.props.getProperty("JSP_lista_departamento"));
  }

  private void recogerId(HttpServletRequest request) {

    this.id = Integer.parseInt(request.getParameter(this.props.getProperty("parCodigo")));

  }

  /**
   * Metodo que se va a encargar del resto de operaciones, es decir, crear, eliminar o modificar un
   * departamento.
   * 
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    this.operacion = Integer.parseInt(request.getParameter(this.props.getProperty("parOperacion")));
    try {
      switch (operacion) {
      case 0:// Integer.parseInt(this.props.getProperty("opCreate")):
        this.departamento = this.cargarDepartamento(request);
        this.dService.create(this.departamento);
        break;

      case 2:// Integer.parseInt(this.props.getProperty("opUpdate")):
        this.departamento = this.cargarDepartamento(request);
        this.dService.update(this.departamento);
        break;

      case 3:// Integer.parseInt(this.props.getProperty("opDelete")):
        this.departamento = this.cargarDepartamento(request);
        this.dService.delete(this.departamento.getCodigo());
        break;

      default:
        break;
      }
    } catch (NumberFormatException e) {
      this.LOG.error(e.getMessage() + "No entra en las operaciones CRUD");
    }
    this.getAll(request);
    this.rd.forward(request, response);
  }

  private Departamento cargarDepartamento(HttpServletRequest request) {
    Departamento departamento = new Departamento();
    departamento.setCodigo(Integer.parseInt(request.getParameter(this.props
        .getProperty("parCodigo"))));
    departamento.setDescripcion(request.getParameter(this.props.getProperty("parDescripcion")));
    departamento.setNombre(request.getParameter(this.props.getProperty("par_Nombre")));
    // Me falta tener en cuenta la lista de empleados dentro de cada departamento
    return departamento;
  }
}
