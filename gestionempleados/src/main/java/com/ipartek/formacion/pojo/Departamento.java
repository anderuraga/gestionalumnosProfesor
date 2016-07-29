package com.ipartek.formacion.pojo;

import org.apache.log4j.Logger;

public class Departamento {

	public static final int CODIGO_DEPARTAMENTO = -1;
	private static final Logger LOG = Logger.getLogger(Departamento.class);

	protected int codigo;
	protected String nombre, descripcion;

	/**
	 * @param codigo
	 * @param nombre
	 * @param descripcion
	 */
	public Departamento(int codigo, String nombre, String descripcion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	/**
	 * 
	 */
	public Departamento() {
		super();
		setCodigo(CODIGO_DEPARTAMENTO);
		setNombre("departamento falso");
		setDescripcion("este departamento no existe");
		// TODO Auto-generated constructor stub
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
