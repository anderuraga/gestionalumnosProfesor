package com.ipartek.formacion.dao.persistence;

import javax.validation.constraints.NotNull;

/**
 * @author Erasmo
 */
public class Candidato {
	private int codigo;
	@NotNull
	private String Nombre;
	@NotNull
	private String Apellidos;

	public Candidato() {
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
