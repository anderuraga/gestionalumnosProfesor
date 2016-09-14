package com.ipartek.formacion.dao.persistence;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Curso {
	private int codigo;
	@NotNull
	@Size(min=4)
	private String nombre;

	public Curso() {
		super();
		this.setCodigo(-1);
		this.setNombre("");

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
