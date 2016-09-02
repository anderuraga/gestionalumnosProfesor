package com.ipartek.formacion.dao.interfaces;

import javax.sql.DataSource;

/**
 * Interfaz que implementa el metodo setter para el objeto dataSource de conexion con la BB.DD. Es
 * necesario para crear el objeto dataSource en el root-context
 * 
 * @author Curso
 *
 */
public interface DAOSetter {

  public void setDataSource(DataSource dataSource);
}
