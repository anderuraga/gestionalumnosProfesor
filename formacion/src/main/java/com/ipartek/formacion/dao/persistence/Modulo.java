package com.ipartek.formacion.dao.persistence;

public class Modulo {

	int codigo;
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
	
	public int getDuracion() {
		return duracion;
	}
	
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
}
