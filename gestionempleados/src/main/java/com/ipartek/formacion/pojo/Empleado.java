package com.ipartek.formacion.pojo;

import java.util.Date;

public class Empleado {
	public static final int CODIGO_EMPLEADO = -1;
	
	private int codigo;
	private String nombre;
	private String apellidos;
	private String dni;
	private String numSS;
	private String direccion;
	private String localidad;
	private String cp;
	private String cc;
	private Date fContrato;
	private Date fNacimiento;
	private Departamento dep;

	
	/**
	 * 
	 */
	public Empleado() {
		super();
		this.setCodigo(CODIGO_EMPLEADO);
		this.setNombre("");
		this.setApellidos("");
		this.setDni("");
		this.setNumSS("");
		this.setDireccion("");
		this.setLocalidad("");
		this.setCp("");
		this.setCc("");
		this.setfContrato(new Date());
		this.setfNacimiento(new Date());
		
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
	public String getNumSS() {
		return numSS;
	}
	public void setNumSS(String numSS) {
		this.numSS = numSS;
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
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public Date getfContrato() {
		return fContrato;
	}
	public void setfContrato(Date fContrato) {
		this.fContrato = fContrato;
	}
	public Date getfNacimiento() {
		return fNacimiento;
	}
	public void setfNacimiento(Date fNacimiento) {
		this.fNacimiento = fNacimiento;
	}
	public Departamento getDep() {
		return dep;
	}
	public void setDep(Departamento dep) {
		this.dep = dep;
	}
	
	
	
}
