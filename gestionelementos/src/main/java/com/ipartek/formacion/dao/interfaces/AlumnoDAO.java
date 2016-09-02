package com.ipartek.formacion.dao.interfaces;
import java.util.List;
import javax.sql.DataSource;
import com.ipartek.formacion.dao.persistence.Alumno;
public interface AlumnoDAO {
	List<Alumno> getAll();

	void setDataSource(DataSource dataSource);
}
