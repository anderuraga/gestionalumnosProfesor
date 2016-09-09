package com.ipartek.formacion.dao.persistence;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author va00
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
	//@Phone
	private int telefono;
	private String dni;
	public Alumno() {
		super();
		setCodigo(-1);
		setNombre("");
		setApellidos("");
		setDni("");
		setfNacimiento(new Date());
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
	@Override
	public String toString() {
		return "Alumno [codigo=" + codigo + ", nombre=" + nombre
				+ ", apellidos=" + apellidos + "]";
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
	
}
