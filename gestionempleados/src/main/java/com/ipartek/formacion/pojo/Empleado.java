package com.ipartek.formacion.pojo;

import java.util.Date;

public class Empleado {
	public static final int COD_EMPLE = -1;
	private int codEmple;
	private String nombre;
	private String apellidos;
	private String dni;
	private Date fechaNacim;
	private Date fechaContratacion;
	private String numSS;
	private String cuentaCorriente;
	private String direccion;
	private String localidad;
	private int cp;
	private Departamento dpto;

	/**
	 * 
	 */
	public Empleado() {
		super();
		setCodEmple(COD_EMPLE);
		setNombre("");
		setApellidos("");
		setDni("");
		setFechaNacim(new Date());
		setFechaContratacion(new Date());
		setNumSS("");
		setCuentaCorriente("");
		setDireccion("");
		setLocalidad("");
		setCp(0);

	}

	public int getCodEmple() {
		return codEmple;
	}

	public void setCodEmple(int codEmple) {
		this.codEmple = codEmple;
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

	public Date getFechaNacim() {
		return fechaNacim;
	}

	public void setFechaNacim(Date fechaNacim) {
		this.fechaNacim = fechaNacim;
	}

	public Date getFechaContratacion() {
		return fechaContratacion;
	}

	public void setFechaContratacion(Date fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}

	public String getNumSS() {
		return numSS;
	}

	public void setNumSS(String numSS) {
		this.numSS = numSS;
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

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public Departamento getDpto() {
		return dpto;
	}

	public void setDpto(Departamento dpto) {
		this.dpto = dpto;
	}

}
