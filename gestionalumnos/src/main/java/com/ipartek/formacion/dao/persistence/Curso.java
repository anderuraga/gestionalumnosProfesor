package com.ipartek.formacion.dao.persistence;

public class Curso {

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
	public Curso(int codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}

	/**
	 * 
	 */
	public Curso() {
		super();
		setCodigo(-1);
		setNombre("");

	}

}
