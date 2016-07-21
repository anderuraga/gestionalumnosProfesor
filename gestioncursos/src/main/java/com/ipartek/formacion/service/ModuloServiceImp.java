package com.ipartek.formacion.service;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.dbms.dao.ModuloDAO;
import com.ipartek.formacion.dbms.dao.ModuloDAOImp;
import com.ipartek.formacion.pojo.Modulo;

public class ModuloServiceImp implements ModuloService {

  private ModuloDAO moduloDAO = ModuloDAOImp.getInstance();

  /*
   * private List<Modulo>modulos; private static int i = 1; private void init(){ Modulo modulo = new
   * Modulo(); modulo.setNombre("Desarrollo Aplicaciones Web"); create(modulo); }
   */
  public ModuloServiceImp() {
    // this.modulos = new ArrayList<Modulo>();
    // init();
  }

  @Override
  public Modulo create(Modulo modulo) {
    /*
     * // le asignamos el codigo al modulo modulo.setCodigo(ModuloServiceImp.i); // lo añadimos a la
     * "BBDD" modulos.add(modulo); i++;
     */
    moduloDAO.create(modulo);
    return modulo;
  }

  @Override
  public Modulo getById(int codigo) {
    Modulo modulo = null;
    /*
     * try { modulo = this.modulos.get(getIndex(codigo)); } catch (ModuloServiceException e) {
     * modulo = new Modulo(); }
     */
    modulo = moduloDAO.getById(codigo);
    return modulo;
  }

  /*
   * private int getIndex(int codigo) throws ModuloServiceException { int index = -1; int i = 0, len
   * = modulos.size(); boolean encontrado = false; while (i < len && encontrado == false) { if
   * (this.modulos.get(i).getCodigo() == codigo) { encontrado = true; index = i; } i++; } if (i ==
   * -1) { throw new ModuloServiceException(ModuloServiceException.CODIGO_MODULO_NO_ECONTRADO,
   * ModuloServiceException.MSG_MODULO_NO_ENCONTRADO); } return index; }
   */
  @Override
  public void delete(int codigo) {
    // DELETE FROM modulo
    // WHERE id = codigo;
    /*
     * try { modulos.remove(getIndex(codigo)); } catch (ModuloServiceException e) { // TODO
     * Auto-generated catch block e.printStackTrace(); }
     */
    moduloDAO.delete(codigo);
  }

  @Override
  public List<Modulo> getAll() {

    List<Modulo> modulos = null;
    modulos = new ArrayList<Modulo>();
    modulos = moduloDAO.getAll();
    return modulos;

  }

  @Override
  public Modulo update(Modulo modulo) {
    /*
     * try { this.modulos.set(getIndex(modulo.getCodigo()), modulo); } catch (ModuloServiceException
     * e) { // TODO Auto-generated catch block e.printStackTrace(); }
     */
    Modulo mod = null;
    mod = moduloDAO.update(modulo);
    return mod;
  }

}
