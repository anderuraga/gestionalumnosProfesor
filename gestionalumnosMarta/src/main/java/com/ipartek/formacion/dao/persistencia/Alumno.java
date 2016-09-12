package com.ipartek.formacion.dao.persistencia;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

public class Alumno {
	@Min(0)
	private int codigo;
	@NotNull(message="El campo nombre es obligatorio") 
	private String nombre;
	@NotNull(message="El campo apellidos es obligatorio") 
	private String apellidos;
	@NotNull(message="El campo fecha es obligatorio") 
	@Past 
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date fNacimiento;
	@NotNull(message="El campo email es obligatorio")  
	@Pattern(regexp = "[A-Za-z0-9+_.-]+@(.+)$")
	private String email;
	
	@Phone(message="El telefono no es válido") 
	private int telefono;
	
	
	public Alumno() {
		super();
		this.setCodigo(-1);
		this.setNombre("");
		this.setApellidos("");
		this.setfNacimiento(new Date());
		this.setEmail("");
		this.setTelefono(0);
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
