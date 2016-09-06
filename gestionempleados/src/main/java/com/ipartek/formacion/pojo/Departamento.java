package com.ipartek.formacion.pojo;

/**
 * Clase que define los atributos del Departamento
 * @author Curso
 *
 */

public class Departamento {
	
	public static final int CODIGO_DEPARTAMENTO = -1;
	
	protected int codigo;
	protected String nombre;
	protected String descripcion;
	
	public Departamento() {
		super();
		setCodigo(CODIGO_DEPARTAMENTO);
		setNombre("");
		setDescripcion("");
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
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
