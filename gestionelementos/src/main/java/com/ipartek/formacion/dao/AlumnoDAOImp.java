package com.ipartek.formacion.dao;
import com.ipartek.formacion.dao.interfaces.AlumnoDAO;
import com.ipartek.formacion.dao.mappers.AlumnoMapper;
import com.ipartek.formacion.dao.persistence.Alumno;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository public class AlumnoDAOImp implements AlumnoDAO {
	@Autowired
	private DataSource		dataSource;
	private JdbcTemplate	jdbctemplate;
	@Override public List<Alumno> getAll() {
		List<Alumno> alumnos = null;
		final String sql = "SELECT codigo FROM alumno";
		try {
			alumnos = jdbctemplate.query(sql, new AlumnoMapper());
		}
		catch (EmptyResultDataAccessException e) {
			alumnos = new ArrayList<Alumno>();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return alumnos;
	}
	@Autowired
	@Override public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbctemplate = new JdbcTemplate(dataSource);
	}
}
