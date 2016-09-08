package com.ipartek.formacion.dao.persistencia;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Curso {
	@Min(0)
	private int codigo;
	@NotNull @Pattern(regexp="(")
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
