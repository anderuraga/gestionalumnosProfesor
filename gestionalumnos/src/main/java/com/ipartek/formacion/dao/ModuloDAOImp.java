package com.ipartek.formacion.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ipartek.formacion.dao.interfaces.ModuloDAO;
import com.ipartek.formacion.dao.mappers.ModuloMapper;
import com.ipartek.formacion.dao.persistencia.Modulo;

public class ModuloDAOImp implements ModuloDAO {

  @Autowired
  private DataSource dataSource;
  private JdbcTemplate jdbcTemplate;

  @Override
  public Modulo create(Modulo modulo) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void delete(int id) {

    final String SQL = "DELETE FROM modulo WHERE codModulo = ?";
    this.jdbcTemplate.update(SQL, new Object[] { id });
  }

  @Override
  public Modulo update(Modulo modulo) {

    final String SQL = "UPDATE nombre FROM modulo SET(nombre = ?) WHERE codModulo = ?";
    this.jdbcTemplate.update(SQL, new Object[] { modulo.getNombre(), modulo.getCodigo() });
    return modulo;
  }

  @Override
  public Modulo getById(int id) {

    Modulo modulo = null;
    final String SQL = "SELECT codModulo,nombre FROM modulo WHERE codModulo = ?";
    try {
      modulo = this.jdbcTemplate.queryForObject(SQL, new Object[] { id }, new ModuloMapper());
    } catch (EmptyResultDataAccessException e) {
      modulo = new Modulo();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return modulo;
  }

  @Override
  public List<Modulo> getAll() {

    List<Modulo> modulos = null;
    final String SQL = "SELECT codModulo, nombre FROM modulo";
    try {
      modulos = this.jdbcTemplate.query(SQL, new ModuloMapper());
    } catch (EmptyResultDataAccessException e) {
      modulos = new ArrayList<Modulo>();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return modulos;
  }

  @Autowired
  @Override
  public void setDataSource(DataSource dataSource) {

    this.dataSource = dataSource;
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }

}
