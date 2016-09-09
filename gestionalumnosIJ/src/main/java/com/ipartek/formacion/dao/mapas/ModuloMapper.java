package com.ipartek.formacion.dao.mapas;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.dao.persistence.Modulo;

public class ModuloMapper implements RowMapper<Modulo> {

  @Override
  public Modulo mapRow(ResultSet rs, int arg1) throws SQLException {
    Modulo modulo = new Modulo();
    modulo.setCodigo(rs.getInt("codModulo"));
    modulo.setNombre(rs.getString("nombre"));
    modulo.setDuracion(rs.getInt("codDuracion"));
    return modulo;
  }
}
