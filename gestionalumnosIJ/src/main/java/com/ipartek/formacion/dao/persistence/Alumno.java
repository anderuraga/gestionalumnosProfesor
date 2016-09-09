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
	private String apellido;
	@NotNull
	@Past
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fNacimiento;
	@Pattern(regexp = "[0-9a-zA-Z]+@[a-zA-Z]+.[a-zA-Z]{1,3}")
	private String email;
	@Phone
	private String telefono;

	/**
	 * Constructor de la clase Alumno
	 */
	public Alumno() {
		super();
		setCodigo(0);
		setNombre("");
		setApellido("");
		setfNacimiento(new Date());
	}

	/**
	 * 
	 * @return
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * 
	 * @param codigo
	 *            <code>int</code>
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * 
	 * @param apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
