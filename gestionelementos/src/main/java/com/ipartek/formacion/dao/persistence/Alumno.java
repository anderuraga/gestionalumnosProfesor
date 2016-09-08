package com.ipartek.formacion.dao.persistence;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Erasmo
 */
public class Alumno {
	private int codigo;
	private String Nombre;
	private String Apellidos;

	@NotNull
	@Past
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date fechaNacimiento;
//	private int telefono;

	public Alumno() {
		super();
		setCodigo(-1);
		setNombre("");
		setApellidos("");
		setFechaNacimiento(fechaNacimiento);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;

	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

//	public int getTelefono() {
//		return telefono;
//	}
//
//	public void setTelefono(int telefono) {
//		this.telefono = telefono;
//	}
}
