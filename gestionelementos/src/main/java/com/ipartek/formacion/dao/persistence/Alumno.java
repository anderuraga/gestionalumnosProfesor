package com.ipartek.formacion.dao.persistence;
/**
 * @author Erasmo
 */
public class Alumno {
	private int		codigo;
	private String	Nombre;
	private String	Apellidos;
	public Alumno() {
		super();
		setCodigo(-1);
		setNombre("");
		setApellidos("");
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
		
	}
}
