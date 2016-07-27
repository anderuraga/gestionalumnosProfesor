package com.ipartek.formacion.service;

public enum NombreDepartamento {

	SISTEMAS(1, "Sistemas", "encargados de reparar lo que rompen otros"), CONTABILIDAD(2, "Contabilidad",
			"encargados de llevar las cuentas de la empresa"), DIRECCION(3, "Dirección", "Los jefes");

	private int codigo;
	private String nombre;
	private String descripcion;

	/**
	 * @param codigo
	 * @param nombre
	 * @param descripcion
	 */
	private NombreDepartamento(int codigo, String nombre, String descripcion) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
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
