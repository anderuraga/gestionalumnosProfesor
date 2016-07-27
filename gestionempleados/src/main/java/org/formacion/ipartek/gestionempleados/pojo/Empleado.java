package org.formacion.ipartek.gestionempleados.pojo;

import java.util.Date;

import org.apache.log4j.Logger;

public class Empleado {

	public static final int CODIGO_EMPLEADO = -1;
	private static final Logger LOG = Logger.getLogger(Empleado.class);
	protected int codigo, NSS, CC, CP, departamento;
	protected Date fNacimiento = null;
	protected Date fContratacion = null;
	protected String nombre, apellidos, localidad, direccion, DNI;

	/**
	 * 
	 */
	public Empleado() {
		super();
		setCodigo(CODIGO_EMPLEADO);
		setCC(0);
		setCP(0);
		setNSS(0);
		setDepartamento(1);
		setNombre("");
		setApellidos("");
		setDireccion("");
		setLocalidad("");
		setDNI("");
		try {
			setfNacimiento(new Date());
			setfContratacion(new Date());
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}

		// TODO Auto-generated constructor stub
	}

	/**
	 * @param codigo
	 * @param nSS
	 * @param cC
	 * @param cP
	 * @param departamento
	 * @param fNacimiento
	 * @param fContratacion
	 * @param nombre
	 * @param apellidos
	 * @param localidad
	 * @param direccion
	 * @param dNI
	 */
	public Empleado(int codigo, int nSS, int cC, int cP, int departamento, Date fNacimiento, Date fContratacion,
			String nombre, String apellidos, String localidad, String direccion, String dNI) {
		super();
		this.codigo = codigo;
		NSS = nSS;
		CC = cC;
		CP = cP;
		this.departamento = departamento;
		this.fNacimiento = fNacimiento;
		this.fContratacion = fContratacion;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.localidad = localidad;
		this.direccion = direccion;
		DNI = dNI;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getNSS() {
		return NSS;
	}

	public void setNSS(int nSS) {
		NSS = nSS;
	}

	public int getCC() {
		return CC;
	}

	public void setCC(int cC) {
		CC = cC;
	}

	public int getCP() {
		return CP;
	}

	public void setCP(int cP) {
		CP = cP;
	}

	public int getDepartamento() {
		return departamento;
	}

	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}

	public Date getfNacimiento() {
		return fNacimiento;
	}

	public void setfNacimiento(Date fNacimiento) {
		this.fNacimiento = fNacimiento;
	}

	public Date getfContratacion() {
		return fContratacion;
	}

	public void setfContratacion(Date fContratacion) {
		this.fContratacion = fContratacion;
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

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

}
