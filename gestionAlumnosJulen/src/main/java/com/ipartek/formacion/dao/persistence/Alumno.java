package com.ipartek.formacion.dao.persistence;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ipartek.formacion.controller.ModuloController;

/**
 * 
 * @author Curso
 *
 */
public class Alumno {
	
	private static final Logger logger = LoggerFactory.getLogger(Alumno.class);

	private int codigo;
	@NotNull
	private String nombre;
	@NotNull
	private String apellidos;
	//@Phone
	private String telefono;
	
	public Alumno() {
		super();
		setCodigo(-1);
		setNombre("");
		setApellidos("");
	}


	public int getCodigo() {
		return codigo;
	}

	@Min(value=-1)
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	
	
}
