package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.Empleado;

/**
 * Interfaz de Empleado donde se declaran las operaciones CRUD.
 * 
 * @author Neli
 *
 */
public interface EmpleadoService {
	public Empleado createEmple(Empleado emple);

	public Empleado getById(int codEmple);

	public void deleteEmple(int codEmple);

	public Empleado updateEmple(Empleado emple);

	public List<Empleado> getAll();

}
