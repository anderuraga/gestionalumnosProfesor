package com.ipartek.formacion.dao.persistence;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

public class Alumno {

	private int codigo;
	@NotNull
	private String nombre;
	@NotNull
	private String apellidos;
	@NotNull @Past @DateTimeFormat(pattern="dd/MM/yyyy")
	private Date fNacimiento;
	private String telefono;
	
	


	public Alumno() {
		super();
		this.setCodigo(-1);
		this.setNombre("");
		this.setApellidos("");
		this.setfNacimiento(new Date());
		
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
		if (fNacimiento.compareTo(new Date())>0) {
			
		}else {
			this.fNacimiento = fNacimiento;
		}
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
	
}
