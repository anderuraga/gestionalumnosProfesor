package com.ipartek.formacion.dao.persistencia;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

public class Alumno {

	/*
	 * Todas las etiquetas que hay en esta clase son para la validacion de los
	 * datos, condiciones que van a darse
	 */
	private int codigo;
	@NotNull
	private String nombre;
	@NotNull
	private String apellidos;
	@NotNull
	@Past
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fNacimiento;
	private String email;
	private int telefono;

	public Alumno() {
		super();
		setCodigo(-1);
		setNombre("");
		setApellidos("");
	}

	@Min(value = 0)
	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return this.apellidos;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	
	
}
