package com.ipartek.formacion.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dao.interfaces.ModuloDAO;
import com.ipartek.formacion.dao.mapas.ModuloMapper;
import com.ipartek.formacion.dao.persistence.Modulo;

@Repository
public class ModuloDAOImp implements ModuloDAO {
  private static final Logger logger = LoggerFactory.getLogger(ModuloDAOImp.class);
  @Autowired
  private DataSource dataSource = null;
  private JdbcTemplate jdbctemplate = null;

  @Autowired
  @Override
  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
    jdbctemplate = new JdbcTemplate(dataSource);

  }

  @Override
  public List<Modulo> getAll() {
    List<Modulo> modulos = new ArrayList<Modulo>();
    final String SQL = "SELECT codModulo, nombre FROM modulo;";
    try {
      modulos = jdbctemplate.query(SQL, new ModuloMapper());
    } catch (EmptyResultDataAccessException e) {
      modulos = new ArrayList<Modulo>();
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
    return modulos;
  }

  @Override
  public Modulo getById(int id) {
    Modulo modulo = null;
    final String SQL = "SELECT codModulo, nombre FROM modulo WHERE codModulo = ?";
    try {
      modulo = jdbctemplate.queryForObject(SQL, new Object[] { id }, new ModuloMapper());
    } catch (EmptyResultDataAccessException e) {
      modulo = new Modulo();
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
    return modulo;
  }

  @Override
  public Modulo create(Modulo modulo) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Modulo update(Modulo modulo) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void delete(int id) {
    final String SQL = "DELETE FROM modulo WHERE codModulo = ?;";
    jdbctemplate.update(SQL, id);
  }
}
