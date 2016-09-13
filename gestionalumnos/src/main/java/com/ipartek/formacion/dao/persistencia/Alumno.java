package com.ipartek.formacion.dao.persistencia;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Alumno {
	
	private int codigo;
	@NotNull
	private String nombre;
	@NotNull
	private String apellidos;
	@NotNull 
	@Past 
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date fNacimiento;
	@NotNull
//	@Size(min = 10, max = 12)
//	@Digits(fraction = 0, integer = 12)
//	@Column(name = "telefono")
	@Phone
	private int telefono;
	
	@NotNull
	@NotEmpty
	@Email
	private String email;
	@Pattern(regexp = "[0-9]{4}[A-Z]{1}", 
			message = "El dni debe tener 9 dígitos y 1 letras mayúsculas.")
	@Column(name = "dni")
	private String dni;
	
	public Alumno() {
		super();
		setCodigo(-1);
		setNombre("");
		setApellidos("");
		setDni("");
	}
	@Min(value = 0)
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
	
	
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
}