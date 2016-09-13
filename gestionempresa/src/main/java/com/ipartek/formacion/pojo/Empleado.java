/**
 * 
 */
package com.ipartek.formacion.pojo;

import java.util.Date;

/**
 * @author Curso
 *
 */
public class Empleado {

	public static final int CODIGO_EMPLEADO=-1;
	private int codEmp;
	private String nombreEmp;
	private String apellidosEmp;
	private String dni_nie;
	private String n_ss;
	private String cCorriente;
	private String direccion;
	private String localidad;
	private int cPostal;
	private Date fNacimiento;
	private Date fContratacion;
	private Departamento dptoEmp;
	/**
	 * 
	 */
	public Empleado() {
		super();
		this.setCodEmp(CODIGO_EMPLEADO);
		this.setNombreEmp("");
		this.setApellidosEmp("");
		this.setDni_nie("");
		this.setN_ss("");
		this.setcCorriente("");
		this.setDireccion("");
		this.setLocalidad("");
		this.setcPostal(-1);
		this.setfNacimiento(new Date());
		this.setfContratacion(new Date());
		this.setDptoEmp(new Departamento());
	}
	/**
	 * @return the codEmp
	 */
	public int getCodEmp() {
		return codEmp;
	}
	/**
	 * @param codEmp the codEmp to set
	 */
	public void setCodEmp(int codEmp) {
		this.codEmp = codEmp;
	}
	/**
	 * @return the nombreEmp
	 */
	public String getNombreEmp() {
		return nombreEmp;
	}
	/**
	 * @param nombreEmp the nombreEmp to set
	 */
	public void setNombreEmp(String nombreEmp) {
		this.nombreEmp = nombreEmp;
	}
	/**
	 * @return the apellidosEmp
	 */
	public String getApellidosEmp() {
		return apellidosEmp;
	}
	/**
	 * @param apellidosEmp the apellidosEmp to set
	 */
	public void setApellidosEmp(String apellidosEmp) {
		this.apellidosEmp = apellidosEmp;
	}
	/**
	 * @return the dni_nie
	 */
	public String getDni_nie() {
		return dni_nie;
	}
	/**
	 * @param dni_nie the dni_nie to set
	 */
	public void setDni_nie(String dni_nie) {
		this.dni_nie = dni_nie;
	}
	/**
	 * @return the n_ss
	 */
	public String getN_ss() {
		return n_ss;
	}
	/**
	 * @param n_ss the n_ss to set
	 */
	public void setN_ss(String n_ss) {
		this.n_ss = n_ss;
	}
	/**
	 * @return the cCorriente
	 */
	public String getcCorriente() {
		return cCorriente;
	}
	/**
	 * @param cCorriente the cCorriente to set
	 */
	public void setcCorriente(String cCorriente) {
		this.cCorriente = cCorriente;
	}
	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * @return the localidad
	 */
	public String getLocalidad() {
		return localidad;
	}
	/**
	 * @param localidad the localidad to set
	 */
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	/**
	 * @return the cPostal
	 */
	public int getcPostal() {
		return cPostal;
	}
	/**
	 * @param cPostal the cPostal to set
	 */
	public void setcPostal(int cPostal) {
		this.cPostal = cPostal;
	}
	/**
	 * @return the fNacimiento
	 */
	public Date getfNacimiento() {
		return fNacimiento;
	}
	/**
	 * @param fNacimiento the fNacimiento to set
	 */
	public void setfNacimiento(Date fNacimiento) {
		this.fNacimiento = fNacimiento;
	}
	/**
	 * @return the fContratacion
	 */
	public Date getfContratacion() {
		return fContratacion;
	}
	/**
	 * @param fContratacion the fContratacion to set
	 */
	public void setfContratacion(Date fContratacion) {
		this.fContratacion = fContratacion;
	}
	/**
	 * @return the dptoEmp
	 */
	public Departamento getDptoEmp() {
		return dptoEmp;
	}
	/**
	 * @param dptoEmp the dptoEmp to set
	 */
	public void setDptoEmp(Departamento dptoEmp) {
		this.dptoEmp = dptoEmp;
	}
	
	
}