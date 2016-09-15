package com.ipartek.formacion.dao.persistence;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Modulo {
	private int codigo;
	@NotNull
	@Size(min=1)
	private String nombre;
	@Min(value=1)
	@Max(value=124)
	private int duracion;

	/**
 * 
 */
	public Modulo() {
		super();
		setCodigo(0);
		setNombre("");
		setDuracion(1);
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
