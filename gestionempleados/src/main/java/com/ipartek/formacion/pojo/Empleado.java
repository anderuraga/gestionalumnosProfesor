package com.ipartek.formacion.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.service.Idioma;

public class Empleado {

	public static final int CODIGO_EMPLEADO = -1;
	private static final Logger LOG = Logger.getLogger(Empleado.class);
	protected int codigo, NSS, CC, CP;
	protected Date fNacimiento = null;
	protected Date fContratacion = null;
	protected String nombre, apellidos, localidad, direccion, DNI;
	protected String sessionId = null;

	protected List<Idioma> idiomas;
	protected Departamento departamento;

	public List<Idioma> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(List<Idioma> idiomas) {
		this.idiomas = idiomas;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * 
	 */
	public Empleado() {
		super();
		setCodigo(CODIGO_EMPLEADO);
		setCC(0);
		setCP(0);
		setNSS(0);
		setNombre("");
		setApellidos("");
		setDireccion("");
		setLocalidad("");
		setSessionId("");
		setDNI("");
		setDepartamento(new Departamento());
		List<Idioma> auxIdiomas = new ArrayList<Idioma>();
		auxIdiomas.add(Idioma.CASTELLANO);
		setIdiomas(auxIdiomas);
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
	public Empleado(int codigo, int nSS, int cC, int cP, Departamento departamento, Date fNacimiento,
			Date fContratacion, String nombre, String apellidos, String localidad, String direccion, String dNI,
			String sessionId) {
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
		this.sessionId = sessionId;
		this.DNI = dNI;
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
