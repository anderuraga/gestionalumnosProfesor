package com.ipartek.formacion.dao.persistencia;

public class Alumno {
	private int codigo;
	private String nombre;
	private String Apellidos;

	/**
	 * 
	 */
	public Alumno() {
		super();
		setCodigo(-1);
		setNombre("");
		setApellidos("");
	}

	/**
	 * @param codigo
	 * @param nombre
	 * @param apellidos
	 */
	public Alumno(int codigo, String nombre, String apellidos) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		Apellidos = apellidos;
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

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

}

