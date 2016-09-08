package com.ipartek.formacion.dao.persistence;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @author Curso
 *
 */
public class Alumno {
	private int codigo;
	@NotNull
	private String nombre;
	@NotNull
	private String apellidos;
	@NotNull @Past @DateTimeFormat(pattern="dd/MM/yyyy")
	private Date fNacimiento;
	private int telefono;
	
	/**
	 * 
	 */
	public Alumno() {
		super();
		setCodigo(-1);
		setNombre("");
		setApellidos("");
	}
	
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
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
}
