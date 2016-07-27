package com.ipartek.formacion.pojo;

import java.util.Date;

import com.ipartek.formacion.service.DepartamentoServiceImp;

/**
 * •	Código
•	Fecha Nacimiento
•	Fecha contratación
•	Nombre
•	Apellidos
•	DNI
•	Nº SS.
•	C/C
•	Dirección
•	Localidad
•	Código Postal, int.
•	Tipo departamento

 * @author Curso
 *
 */

public class Empleado {
	
	public static final int CODIGO_EMPLEADO = -1;
	
	protected int codigo;
	private Date fNacimiento;
	private Date fContratación;
	private String nombre;
	private String apellidos;
	private String dni;
	private String nSS;
	private int cc;
	private String direccion;
	private String localidad;
	private int codigoPostal;
	private Departamento tipoDepartamento;
		
	
	public Empleado() {
		super();
		setCodigo(codigo);
		setNombre("");
		setApellidos("");
		setDireccion("");
		setLocalidad("");
		setCodigoPostal(0);
		setnSS("");
		setCc(0);
		this.fNacimiento = new Date();
		setfContratación(new Date());

	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Date getfNacimiento() {
		return fNacimiento;
	}

	public void setfNacimiento(Date fNacimiento) {
		this.fNacimiento = fNacimiento;
	}

	public Date getfContratación() {
		return fContratación;
	}
	public void setfContratación(Date fContratación) {
		this.fContratación = fContratación;
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
	public String getnSS() {
		return nSS;
	}
	public void setnSS(String nSS) {
		this.nSS = nSS;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
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
	public Departamento getTipoDepartamento() {
		return tipoDepartamento;
	}
	public void setTipoDepartamento(int tipoDepartamento) {
		DepartamentoServiceImp departamento = null;
		
		this.tipoDepartamento = departamento.getById(tipoDepartamento);
	}

	
	
	
	
}
