package com.ipartek.formacion.dao;
import com.ipartek.formacion.dao.interfaces.AlumnoDAO;
import com.ipartek.formacion.dao.mappers.AlumnoMapper;
import com.ipartek.formacion.dao.persistence.Alumno;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository public class AlumnoDAOImp implements AlumnoDAO {
	private DataSource		dataSource;
	private JdbcTemplate	jdbctemplate;
	@Override public List<Alumno> getAll() {
		List<Alumno> alumnos = null;
		final String sql = "SELECT codigo FROM alumnos";
		try {
			alumnos = jdbctemplate.query(sql, new AlumnoMapper());
			return alumnos;
		}
		catch (EmptyResultDataAccessException e) {
			alumnos = new ArrayList<Alumno>();
		}
		catch (Exception e) {}
		return alumnos;
	}
	@Override public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbctemplate = new JdbcTemplate(dataSource);
	}
}
