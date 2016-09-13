package com.ipartek.formacion.dao.persistence;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Modulo {

	private int codModulo;
	@NotNull
	private String nombreModulo;
	private String uFormativa;
	
	@Min(value=0, message="La duracion no puede ser menor que 0")
	@Max(value=125,message="La duracion no puede ser mayor de 125")
	private int duracion;
	
	public Modulo() {
		super();
		this.setCodModulo(-1);
		this.setNombreModulo("");
		this.setuFormativa("");
		this.setDuracion(0);
	}
	public int getCodModulo() {
		return codModulo;
	}
	public void setCodModulo(int codModulo) {
		this.codModulo = codModulo;
	}
	public String getNombreModulo() {
		return nombreModulo;
	}
	public void setNombreModulo(String nombreModulo) {
		this.nombreModulo = nombreModulo;
	}
	public String getuFormativa() {
		return uFormativa;
	}
	public void setuFormativa(String uFormativa) {
		this.uFormativa = uFormativa;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	
}
