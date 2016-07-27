package com.ipartek.formacion.empleado.ProyectoGestionEmpleado.pojo;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Empleado {

	public static final int CODIGO_EMPLEADO = -1;
	public static final int CODIGO_POSTAL = -1;
	private int codigo;
	private Date fechaNacimiento;
	private Date fechaContratacion;
	private String nombre;
	private String apellidos;
	private String numeroSS;
	private String cuentaCorriente;
	private String direccion;
	private String localidad;
	private int codigoPostal;
	private String dni;
	private List<Departamento> departamentos;
	
	
	public Empleado() {
		super();
		List<Departamento> depart = new ArrayList<Departamento>();
		setCodigo(CODIGO_EMPLEADO);
		setFechaNacimiento(new Date());
		setFechaContratacion(new Date());
		setNombre("");
		setApellidos("");
		setNumeroSS("");
		setCuentaCorriente("");
		setDireccion("");
		setLocalidad("");
		setCodigoPostal(CODIGO_POSTAL);
		setDni("");
		setDepartamentos(depart);
		
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
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


	public String getNumeroSS() {
		return numeroSS;
	}


	public void setNumeroSS(String numeroSS) {
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


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public List<Departamento> getDepartamentos() {
		return departamentos;
	}


	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}
	
	
}
