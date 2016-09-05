package com.ipartek.formacion.dao.persistence;

public class Modulo {

	private int codigo;
	private String nombre;

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

	/**
	 * @param codigo
	 * @param nombre
	 */
	public Modulo(int codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}

	/**
	 * 
	 */
	public Modulo() {
		super();
		setCodigo(-1);
		setNombre("");
	}

}
