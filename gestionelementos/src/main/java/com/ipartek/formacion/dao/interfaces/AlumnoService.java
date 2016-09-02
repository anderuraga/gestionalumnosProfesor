package com.ipartek.formacion.dao.interfaces;
import java.util.List;
import com.ipartek.formacion.dao.AlumnoDAOImp;
import com.ipartek.formacion.dao.persistence.Alumno;
/**
 * @author Erasmo
 */
public interface AlumnoService {
	public List<Alumno> getAll();


	void setAlumDAO(AlumnoDAOImp alumDAO);
	
	

}
