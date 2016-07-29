package com.ipartek.formacion.pojo;

import java.util.Date;

/**
 * Clase que define los atributos del Empleado
 * @author Curso
 *
 */

public class Empleado {
	
	public static final int CODIGO_EMPLEADO = -1;
	public static final int CODIGO_DEPARTAMENTO = -1;
	
	protected int codigo;
	protected int codigoDepartamento;
	protected String nombre;
	protected String apellidos;
	protected String dni;
	protected Date fechaNacimiento;
	protected Date fechaContratacion;
	protected int numeroSS;
	protected String cuentaCorriente;
	protected String direccion;
	protected String localidad;
	protected int codigoPostal;
	
	public Empleado() {
		super();
		
		setCodigo(CODIGO_EMPLEADO);
		setCodigoDepartamento(CODIGO_DEPARTAMENTO);
		setNombre("");
		setApellidos("");
		this.dni = "";
		this.fechaNacimiento = new Date();
		this.fechaContratacion = new Date();
		setNumeroSS(0);
		setCuentaCorriente("");
		setDireccion("");
		setLocalidad("");
		setCodigoPostal(0);
	}

	public int getCodigoDepartamento() {
		return codigoDepartamento;
	}

	public void setCodigoDepartamento(int codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
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
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Date getFechaContratacion() {
		return fechaContratacion;
	}
	
	public void setFechaContratacion(Date fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}
	
	public int getNumeroSS() {
		return numeroSS;
	}
	
	public void setNumeroSS(int numeroSS) {
		this.numeroSS = numeroSS;
	}
	
	public String getCuentaCorriente() {
		return cuentaCorriente;
	}
	
	public void setCuentaCorriente(String cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getLocalidad() {
		return localidad;
	}
	
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	public int getCodigoPostal() {
		return codigoPostal;
	}
	
	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	@Override
	public String toString() {
		return "Empleado [codigo=" + codigo + ", codigoDepartamento=" + codigoDepartamento + ", nombre=" + nombre
				+ ", apellidos=" + apellidos + ", dni=" + dni + ", fechaNacimiento=" + fechaNacimiento
				+ ", fechaContratacion=" + fechaContratacion + ", numeroSS=" + numeroSS + ", cuentaCorriente="
				+ cuentaCorriente + ", direccion=" + direccion + ", localidad=" + localidad + ", codigoPostal="
				+ codigoPostal + "]";
	}
}
