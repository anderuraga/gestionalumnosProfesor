package com.ipartek.formacion.dao.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

public class Alumno implements Serializable{
	
	private int codigo;
	@NotNull
	private String nombre;
	@NotNull // se puede poner en el get o en la creacion de la vble
	private String apellidos;
	@NotNull (message="La fecha no puede ser nula")
	@Past @DateTimeFormat(pattern="dd/MM/yyyy")
	private Date fNacimiento;
	@Phone
	private String telefono; 
	private String DNI;
	private String email;
	
	
	private int codGenero;
	

	/**
	 * 
	 */
	public Alumno() {
		super();
		setCodigo(-1);
		setNombre("");
		setApellidos("");
		setCodGenero(1);
		
	}

	/**
	 * @param codigo
	 * @param nombre
	 * @param apellidos
	 */
	public Alumno(int codigo, String nombre, String apellidos, Date fNacimiento, int codGenero) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fNacimiento = fNacimiento;
		this.codGenero = codGenero;
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

	public Date getfNacimiento() {
		return fNacimiento;
	}

	public void setfNacimiento(Date fNacimiento) {
		this.fNacimiento = fNacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getCodGenero() {
		return codGenero;
	}

	public void setCodGenero(int codGenero) {
		this.codGenero = codGenero;
	}

}
