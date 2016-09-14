package com.ipartek.formacion.dao.persistence;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Modulo {
	private int codigo;
	@NotNull
	@NotEmpty
	private String nombre;
	@Size(min = 1, max = 125)
	private int duracion;

	public Modulo() {
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

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

}
