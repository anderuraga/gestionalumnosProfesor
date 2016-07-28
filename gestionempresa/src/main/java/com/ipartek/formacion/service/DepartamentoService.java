/**
 * 
 */
package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.Departamento;

/**
 * @author Curso
 *
 */
public interface DepartamentoService {

	public Departamento getById(int codigo);
	public Departamento updateDpto(Departamento dpto);
	public void deleteDpto(int codigo);
	public Departamento createDepartamento(Departamento dpto);
	public List<Departamento> getAll();
	
	
	
}
