package com.ipartek.formacion.pojo;
import java.util.Date;
/**
 * Esta clase es la encargada de tratar con los datos del objeto Empleado.
 * 
 * @author Erasmo
 *
 */
public class Empleado {
	public static final int	CODIGO_ALUMNO	= -1;
	private int				codigo;
	private String			nombre;
	private String			apellido;
	private Date			date_nacimiento;
	private Date			date_contratacion;
	private String			num_seg_soc;
	private String			num_dni;
	private String			cuenta_corriente;
	private String			direccion;
	private String			localidad;
	private int				codigo_postal;
	private Departamento	departamento_empleado;
	public Empleado() {
		super();
		this.setCodigo(CODIGO_ALUMNO);
		this.setNombre("");
		this.setApellidos("");
		this.setDate_nacimiento(new Date());
		this.setDate_contratacion(new Date());
		this.setNum_seg_soc("");
		this.setNum_dni("");
		this.setCuenta_corriente("");
		this.setDireccion("");
		this.setLocalidad("");
		this.setCodigo_postal(-1);
		this.setDepartamento_empleado(new Departamento());
	}
	public int getCodigo() {
		return codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public Date getDate_nacimiento() {
		return date_nacimiento;
	}
	public Date getDate_contratacion() {
		return date_contratacion;
	}
	public String getNum_seg_soc() {
		return num_seg_soc;
	}
	public String getNum_dni() {
		return num_dni;
	}
	public String getCuenta_corriente() {
		return cuenta_corriente;
	}
	public String getDireccion() {
		return direccion;
	}
	public String getLocalidad() {
		return localidad;
	}
	public int getCodigo_postal() {
		return codigo_postal;
	}
	public Departamento getDepartamento_empleado() {
		return departamento_empleado;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public void setApellidos(String apellido) {
		this.apellido = apellido;
	}
	public void setDate_nacimiento(Date date_nacimiento) {
		this.date_nacimiento = date_nacimiento;
	}
	public void setDate_contratacion(Date date_contratacion) {
		this.date_contratacion = date_contratacion;
	}
	public void setNum_seg_soc(String num_seg_soc) {
		this.num_seg_soc = num_seg_soc;
	}
	public void setNum_dni(String num_dni) {
		this.num_dni = num_dni;
	}
	public void setCuenta_corriente(String cuenta_corriente) {
		this.cuenta_corriente = cuenta_corriente;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public void setCodigo_postal(int codigo_postal) {
		this.codigo_postal = codigo_postal;
	}
	public void setDepartamento_empleado(Departamento departamento_empleado) {
		this.departamento_empleado = departamento_empleado;
	}
}
