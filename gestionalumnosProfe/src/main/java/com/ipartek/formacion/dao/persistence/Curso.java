package com.ipartek.formacion.dao.persistence;

public class Curso {
	private int codigo;
	private String nombre;
	

	public Curso() {
		super();
		setCodigo(-1);
		setNombre("");
		
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

}