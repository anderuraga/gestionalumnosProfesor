package com.ipartek.formacion.dao.persistence;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Modulo {

	private int codigo;
	@NotNull
	private String nombre;
	@Min(value=0)
	@Max(value=125)
	private int duracion;
	@NotNull
	private String uFormativa;

	@Min(value=0)
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

	public String getuFormativa() {
		return uFormativa;
	}

	public void setuFormativa(String uFormativa) {
		this.uFormativa = uFormativa;
	}

	/**
	 * @param codigo
	 * @param nombre
	 */
	public Modulo(int codigo, String nombre, int duracion, String uFormativa) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.duracion = duracion;
		this.uFormativa = uFormativa;
	}

	/**
	 * 
	 */
	public Modulo() {
		super();
		setCodigo(-1);
		setNombre("");
		setDuracion(0);
		setuFormativa("");
	}

}
