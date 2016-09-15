package com.ipartek.formacion.dao.persistence;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @author Curso
 * 
 */

public class Alumno {

	@Min(value = 0)
	private int codigo;
	@NotNull
	private String nombre;
	@NotNull
	private String apellidos;
	@NotNull
	@Past
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date FechaNacimiento;
	@Pattern(regexp = "[0-9a-zA-Z]+@[a-zA-Z]+.[a-zA-Z]{1,3}")
	private String email;
	@Phone
	private String telefono;
	private String dni;
	
	/**
	 * Constructor de la clase Alumno
	 */
	public Alumno() {
		super();
		setCodigo(0);
		setNombre("");
		setApellidos("");
		setFechaNacimiento(new Date());
		setEmail("");
		setTelefono("");
		setDni("");
	}

	
	/** @return */
	public int getCodigo() {
		return codigo;
	}
	/** @param codigo */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	
	/** @return */
	public String getNombre() {
		return nombre;
	}
	/** @param nombre */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	/** @return */
	public String getApellidos() {
		return apellidos;
	}
	/** @param apellidos */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	
	/** @return */
	public Date getFechaNacimiento() {
		return FechaNacimiento;
	}
	/** @param FechaNacimiento */
	public void setFechaNacimiento(Date FechaNacimiento) {
		this.FechaNacimiento = FechaNacimiento;
	}
	
	
	/** @return */
	public String getEmail() {
		return email;
	}
	/** @param email */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	/** @return */
	public String getTelefono() {
		return telefono;
	}
	/** @param telefono */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	/** @return */
	public String getDni() {
		return dni;
	}
	/** @param dni */
	public void setDni(String dni) {
		this.dni = dni;
	}

}