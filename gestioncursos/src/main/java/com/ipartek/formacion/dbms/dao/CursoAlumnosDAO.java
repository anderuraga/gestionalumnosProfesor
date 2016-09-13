package com.ipartek.formacion.dbms.dao;

import java.util.List;

import com.ipartek.formacion.pojo.CursoAlumnos;
/**
 * Interfaz que define los metodos de consulta a BD de la calse <code>CursoAlumnos</code>.
 * @author Curso
 *
 */
public interface CursoAlumnosDAO {

	/**
	 * Metodo encargado de dar de alta modulos y alumnos en la Base de Datos. 
	 * @param cursoAlumnos
	 * @return cursoAlumnos
	 */
	
	public void createCursoAlumnos(CursoAlumnos cursoAlumnos);
	/**
	 * Metedo encargado de  borrar Moudlos y alumnos
	 * @param cursoAlumnos
	 */
	public void deleteEmitidos(int codigoCurso);
	public void deleteCalificacion(CursoAlumnos cursoAlumno);
	
	/**
	 * 
	 */
	public void updateCursoAlumnos(CursoAlumnos cursoAlumnos);
	/**
	 * Vista en detalle del curso con alumnos y modulos. Permitira:
	 * <ul>
	 * <li></li>
	 * <li></li>
	 * <li></li>
	 * <li></li>
	 * </ul>
	 * @param codCurso <code>int</code> el codigo del curso emitido
	 * @return
	 */
	
	
	public CursoAlumnos getById(int codCurso);
	
	/**
	 * 
	 * @return
	 */
	public List<CursoAlumnos>getAll();
	
	public CursoAlumnos getByAlumnoId(int codigoAlumno);
	
	
	
}
