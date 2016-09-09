package com.ipartek.formacion.dao.persistencia;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

public class Alumno {
	
	private int codigo;
	@NotNull(message="")//hay que poner el getter, si no las anotaciones no funcionan
	private String nombre;
	@NotNull(message="")
	private String apellidos;
	@NotNull @Past @DateTimeFormat(pattern="dd/MM/yyyy")
	private Date fNacimiento;
	private int telefono;
	private String dni;
	private String email;
	private int codGenero;
	
	public Alumno() {
		super();
		setCodigo(-1);
		setNombre("");
		setApellidos("");
		setfNacimiento(new Date());
		setTelefono(0);
		setDni("");
		setEmail("");
		setCodGenero(0);
	}
	
	@Min(value=0)
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	//@NotNull //también pueden ir antes de la declaración de atributos
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

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCodGenero() {
		return codGenero;
	}

	public void setCodGenero(int codGenero) {
		this.codGenero = codGenero;
	}
}
