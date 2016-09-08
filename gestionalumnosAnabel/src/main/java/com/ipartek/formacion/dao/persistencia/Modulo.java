package com.ipartek.formacion.dao.persistencia;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Modulo {

	private int codigo;
	@NotNull
	private String nombre;
	@Min(value=1)
	@Max(value=125)
	private int duracion;

	public Modulo() {
		setCodigo(-1);
		setNombre("");
		setDuracion(0);
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
