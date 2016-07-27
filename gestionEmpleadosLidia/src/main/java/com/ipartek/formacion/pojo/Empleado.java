package com.ipartek.formacion.pojo;

import java.util.Date;

public class Empleado {

	public static final int CODIGO_EMPLEADO = -1;
	private int codigo;
	private String nombre;
	private String apellidos;
	private String direccion;
	private String localidad;
	private String cp;
	private String dni;
	private String segSocial;
	private Date fechaNac;
	private Date fechaContrato;
	private String numCuenta;
	private Departamento departamento;
	
	//constructor
	public Empleado() {
		super();
		this.codigo= CODIGO_EMPLEADO;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.localidad = localidad;
		this.cp = cp;
		this.dni = dni;
		this.segSocial = segSocial;
		this.fechaNac = fechaNac;
		this.fechaContrato = fechaContrato;
		this.numCuenta = numCuenta;
		this.departamento=new Departamento();
	}


	public Departamento getDepartamento() {
		return departamento;
	}


	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getSegSocial() {
		return segSocial;
	}

	public void setSegSocial(String segSocial) {
		this.segSocial = segSocial;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public Date getFechaContrato() {
		return fechaContrato;
	}

	public void setFechaContrato(Date fechaContrato) {
		this.fechaContrato = fechaContrato;
	}

	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}
	

}
