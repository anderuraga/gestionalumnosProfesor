package com.ipartek.formacion.pojo;

import java.util.List;

import org.apache.log4j.Logger;

public class Departamento {

	public static final int CODIGO_DEPARTAMENTO = -1;
	private static final Logger LOG = Logger.getLogger(Departamento.class);

	protected int codigo;
	protected String nombre, descripcion;
	protected List<Empleado> empleados;

	/**
	 * @param codigo
	 * @param nombre
	 * @param descripcion
	 */
	public Departamento(int codigo, String nombre, String descripcion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	/**
	 * 
	 */
	public Departamento() {
		super();
		setCodigo(CODIGO_DEPARTAMENTO);
		setNombre("");
		setDescripcion("");
		// TODO Auto-generated constructor stub
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
