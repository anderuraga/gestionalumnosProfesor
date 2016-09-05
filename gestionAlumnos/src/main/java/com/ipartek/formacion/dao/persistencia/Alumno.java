package com.ipartek.formacion.dao.persistencia;

public class Alumno {
	private int codigo;
	private String nombre;
	private String apellidos;
	
	public Alumno() {
		super();
		setCodigo(-1);
		setNombre("");
		setApellidos("");
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
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
}
