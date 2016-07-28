package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.Departamento;

/**
 * Interfaz del departamento donde se declaran las operacines CRUD.
 * 
 * @author Neli
 *
 */
public interface DepartamentoService {
	public Departamento createDpto(Departamento dpto);

	public Departamento getById(int codDpto);

	public void deleteDpto(int codDpto);

	public Departamento updateDpto(Departamento dpto);

	public List<Departamento> getAll();
}
