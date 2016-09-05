package com.ipartek.formacion.dao.persistence;

public class Curso {
	private int codigo;
	private String nombre;
	private String patrocinador;

	public Curso() {
		super();
		setCodigo(-1);
		setNombre("");
		setPatrocinador("");
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

	public String getPatrocinador() {
		return patrocinador;
	}

	public void setPatrocinador(String patrocinador) {
		this.patrocinador = patrocinador;
	}

}
