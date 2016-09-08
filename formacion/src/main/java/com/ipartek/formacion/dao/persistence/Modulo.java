package com.ipartek.formacion.dao.persistence;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Modulo {

	int codigo;
	@NotNull
	String nombre;
	String uFormativa;
	int duracion;
	
	/**
	 * 
	 */
	public Modulo() {
		super();
		
		setCodigo(-1);
		setNombre("");
		setuFormativa("");
		setDuracion(-1);		
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
	
	public String getuFormativa() {
		return uFormativa;
	}
	
	public void setuFormativa(String uFormativa) {
		this.uFormativa = uFormativa;
	}
	
	@Min(value=0) @Max(value=125)
	public int getDuracion() {
		return duracion;
	}
	
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
}
