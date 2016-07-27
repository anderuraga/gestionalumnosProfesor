package com.ipartek.formacion.pojo;

import java.util.Date;

/**
 * Esta clase es la encargada de tratar con los datos del objeto Departamento.
 * 
 * @author Erasmo
 *
 */
public class Departamento {

	public static final int CODIGO_ALUMNO = -1;
	private int codigo;
	private String nombre;
	private String descripcion;

	public Departamento() {

		super();
		this.setCodigo(CODIGO_ALUMNO);
		this.setNombre("");
		this.setDescripcion("");

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
