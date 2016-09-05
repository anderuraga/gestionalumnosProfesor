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

import com.ipartek.formacion.pojo.Modulo;
import com.ipartek.formacion.service.ModuloService;
import com.ipartek.formacion.service.ModuloServiceImp;
import com.ipartek.formacion.service.Util;

/**
 * @author Curso Servlet implementation class ModuloServlet
 */
public class ModuloServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final Logger LOG = Logger.getLogger(ModuloServlet.class);
  private static ModuloService mService = ModuloServiceImp.getInstance();
  private Modulo modulo = null;
  private List<Modulo> modulos = null;
  private int id = -1;
  private int operacion = -1;
  private RequestDispatcher rwd;
  private Properties props = null;

  /**
   * @Override
   */
  @Override
  public void destroy() {
    props = null;
    super.destroy();
  }

  /**
   * @Override
   * @throws ServletException
   *           excepcion
   */
  @Override
  public void init() throws ServletException {
    props = (Properties) getServletContext().getAttribute("properties");
    super.init();
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   * @param request
   *          peticion
   * @param response
   *          respuesta
   * @throws ServletException
   *           excepcion servlet
   * @throws IOException
   *           excepcion input/output
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      recogerId(request);
      if (this.id < 0) {
        rwd = request.getRequestDispatcher(props.getProperty("JSPmodulo"));
      } else {
        getById(request);
      }

    } catch (Exception e) {
      getAll(request);
    }
    rwd.forward(request, response);
  }

  /**
   *
   * @param request
   *          peticion
   */
  private void getById(HttpServletRequest request) {
    modulo = mService.getById(id);
    request.setAttribute(props.getProperty("attModulo"), modulo);
    rwd = request.getRequestDispatcher(props.getProperty("JSPmodulo"));
  }

  /**
   *
   * @param request
   *          peticion
   */
  private void getAll(HttpServletRequest request) {
    modulos = mService.getAll();
    request.setAttribute(props.getProperty("listadoModulos"), modulos);
    rwd = request.getRequestDispatcher(props.getProperty("JSPlistadoModulos"));
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   * @param request
   *          peticion
   * @param response
   *          respuesta
   * @throws ServletException
   *           excepcion servlet
   * @throws IOException
   *           excepcion input/output
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String op = request.getParameter(props.getProperty("parOperacion"));
    try {
      this.operacion = Integer.parseInt(op);

      switch (this.operacion) {
      case Constantes.OP_CREATE:
        recogerDatos(request);
        mService.createModulo(modulo);
        break;
      case Constantes.OP_UPDATE:
        recogerDatos(request);
        mService.update(modulo);
        break;
      case Constantes.OP_DELETE:
        recogerId(request);
        mService.delete(this.id);
        break;
      default:
        break;
      }
      getAll(request);
    } catch (NumberFormatException e) {
      LOG.error("La operacion " + this.operacion + " no existe");
    } catch (Exception e) {

    }

    rwd.forward(request, response);
  }

  /**
   *
   * @param request
   *          peticion
   */
  private void recogerId(HttpServletRequest request) {
    this.id = Integer.parseInt(request.getParameter(props.getProperty("parCodigo")));

  }

  /**
   *
   * @param request
   *          peticion
   */
  private void recogerDatos(HttpServletRequest request) {
    modulo = new Modulo();
    recogerId(request);
    modulo.setCodigo(this.id);
    String nombre = request.getParameter(props.getProperty("parNombre"));
    String duracion = request.getParameter(props.getProperty("parDuracion"));
    String uFormativa = request.getParameter(props.getProperty("parUFormativa"));
    modulo.setNombre(nombre);
    modulo.setuFormativa(uFormativa);
    modulo.setDuracion(Util.parseDuracion(Integer.parseInt(duracion)));

  }
}
