package com.ipartek.formacion.dao.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ipartek.formacion.controller.ModuloController;

public class Modulo {

	private static final Logger logger = LoggerFactory.getLogger(Modulo.class);

	private int codigo;
	private String nombre;
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
	
	
	
}
