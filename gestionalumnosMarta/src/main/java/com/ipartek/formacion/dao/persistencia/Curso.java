package com.ipartek.formacion.dao.persistencia;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Curso {
	@Min(0)
	private int codigo;
	@NotNull 
	@Size(min=3)
	private String nombre;
	private String referencia;
	private int codTipo;
	
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

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public int getCodTipo() {
		return codTipo;
	}

	public void setCodTipo(int codTipo) {
		this.codTipo = codTipo;
	}
	
	

}
