package com.ipartek.formacion.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dao.interfaces.AlumnoDAO;
import com.ipartek.formacion.dao.mappers.AlumnoMapper;
import com.ipartek.formacion.dao.persistencia.Alumno;

//Anotacion para indicar que accede a BB.DD.
@Repository("alumnoDAOImp")
public class AlumnoDAOImp implements AlumnoDAO {

	// objeto de conexion a BB.DD.
	@Autowired
	private DataSource dataSource;
	/*
	 * El JdbcTemplate, se va a encargar de coger cada uno de los datos de
	 * alumno y los va a unir para formar el objeto java
	 */
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Alumno> getAll() {

		List<Alumno> alumnos = null;
		final String SQL = "SELECT codAlumno, nombre, apellidos FROM alumno";

		/*
		 * La primera excepcion es para asegurarnos de que la BB.DD. devuelve
		 * algun alumno. La segunda excepcion es la generica y controla que la
		 * sentencia sql este bien
		 */
		try {
			alumnos = jdbcTemplate.query(SQL, new AlumnoMapper());
		} catch (EmptyResultDataAccessException e) {
			alumnos = new ArrayList<Alumno>();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alumnos;
	}

	@Override
	public Alumno create(Alumno alumno) {
		final String SQL = "INSERT INTO alumno (codigo,nombre,apellidos) VALUES (?,?,?)";
		this.jdbcTemplate.update(SQL, new Object[]{alumno.getNombre(), alumno.getApellidos()});
		return null;
	}

	@Override
	public void delete(int id) {
		final String SQL = "DELETE FROM alumno WHERE codAlumno = ?";
		this.jdbcTemplate.update(SQL, new Object[] { id });

	}

	/*
	 * Pasarle los parametros a la BB.DD. se puede hacer de dos maneras, como
	 * hemos visto anteriormente, haciendo un array de tipo objeto y rellenar el
	 * paramentro, y por otro lado puedes meterle a pelo, cada uno de los
	 * parametros, como hemos hecho en el metodo update
	 */
	@Override
	public Alumno update(Alumno alumno) {

		final String SQL = "UPDATE alumno SET(nombre = ?, apellidos = ?) WHERE codAlumno = ?";
		this.jdbcTemplate.update(SQL, alumno.getNombre(),
				alumno.getApellidos(), alumno.getCodigo());
		return alumno;
	}

	/*
	 * Para pasarle a la BB.DD. la id, tenemos que hacer un array de objetos,
	 * (segundo parametro del queryforobject)
	 */
	@Override
	public Alumno getById(int id) {

		Alumno alumno = null;
		final String SQL = "SELECT codAlumno, nombre, apellidos FROM alumno WHERE codAlumno=?";
		try {
			alumno = jdbcTemplate.queryForObject(SQL, new Object[] { id },
					new AlumnoMapper());
		} catch (EmptyResultDataAccessException e) {
			alumno = new Alumno();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alumno;
	}

	/*
	 * Esto viene de DAOSetter. Tenemos que inyectarle la conexion a la BB.DD
	 */
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {

		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}
}
