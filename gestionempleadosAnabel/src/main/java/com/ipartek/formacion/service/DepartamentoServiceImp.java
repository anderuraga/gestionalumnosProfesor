package com.ipartek.formacion.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.dao.DepartamentoDAO;
import com.ipartek.formacion.dbms.dao.DepartamentoDAOImp;
import com.ipartek.formacion.pojo.Departamento;

/**
 * Clase que define los metodos de la interfaz DepartamentoService, encargados de realizar la
 * logica, para que interactue el controlador y el modelo. Las funcionalidades que va a poder
 * realizar el usuario son:
 * <ul>
 * <li>Crear un nuevo registro de departamento</li>
 * <li>Borrar un registro existente de departamento</li>
 * <li>Modificar un registro existente de un departamento</li>
 * <li>Obtener los datos de un departamento</li>
 * <li>Obtener un listado con todos los datos de los distintos departamentos</li>
 * </ul>
 * 
 * @author Anabel
 *
 */
public class DepartamentoServiceImp implements DepartamentoService {

  private static final Logger LOG = Logger.getLogger(DepartamentoServiceImp.class);
  private static DepartamentoServiceImp INSTANCE = null;
  private DepartamentoDAO departamentoDAO;

  /**
   * Constructor de DepartamentoServiceImp
   */
  public DepartamentoServiceImp() {

    this.departamentoDAO = DepartamentoDAOImp.getInstance();
  }

  public static DepartamentoServiceImp getInstance() {
    if (INSTANCE == null) {
      createInstance();
    }
    return INSTANCE;
  }

  private static synchronized void createInstance() {
    if (INSTANCE == null) {
      INSTANCE = new DepartamentoServiceImp();
    }
  }

  /**
   * Metodo encargado de proporcionarle los datos a la capa Modelo, para que pueda guarda el
   * registro en la BB.DD.
   * 
   * @param departamento
   *          <code>Departamento</code> objeto con los datos proporcionados por el usuario de la
   *          app.
   * @return dep <code>Departamento</code> objeto con los datos que se han guardado en la BB.DD.
   */
  @Override
  public Departamento create(Departamento departamento) {

    Departamento dep = null;
    dep = this.departamentoDAO.create(departamento);
    return dep;
  }

  /**
   * Metodo encargado de indicarle al modelo, cual es el codigo del departamento que quiere ser
   * borrado de la BB.DD.
   * 
   * @param codigo
   *          <code>int</code> codigo del departamento que quiere ser borrado
   */
  @Override
  public void delete(int codigo) {

    this.departamentoDAO.delete(codigo);
  }

  /**
   * Metodo encargado de indicarle al modelo, los datos del departamento que va a ser modificado.
   * 
   * @param departamento
   *          <code>Departamento</code> objeto con los datos que necesita la capa modelo, para poder
   *          modificar el registro en la BB.DD.
   * @return dep <code>Departamento</code> objeto departamento, con todos los datos que han sido
   *         modificados en la BB.DD.
   */
  @Override
  public Departamento update(Departamento departamento) {

    Departamento dep;
    dep = this.departamentoDAO.update(departamento);
    return dep;
  }

  /**
   * Metodo encargado de proporcionarle el codigo a la capa modelo, para obtener los datos de un
   * departamento en concreto.
   * 
   * @param codigo
   *          <code>int</code> codigo del departamento que se quiere obtener.
   * @return dep <code>Departamento</code> objeto de tipo departamento, con todos los datos del
   *         departamento que se quieren obtener.
   */
  @Override
  public Departamento getById(int codigo) {
    Departamento dep;
    dep = this.departamentoDAO.getById(codigo);
    return dep;
  }

  /**
   * Metodo con el cual se quiere obtener todos los registro de departamento.
   * 
   * @return departamentos <code>List<Departamento></code> objeto lista de tipo departamento, que
   *         contiene todos los datos de los distintos departamentos.
   */
  @Override
  public List<Departamento> getAll() {
    List<Departamento> departamentos;
    departamentos = this.departamentoDAO.getAll();
    return departamentos;
  }

}
