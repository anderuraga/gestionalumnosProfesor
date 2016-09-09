package com.ipartek.formacion.dao.persistencia;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Curso {
	private int codigo;
	private int codTipoCurso;
	private int codPatrocinador;
	@NotNull(message="") @Pattern (regexp="[a-zA-Z]{3}")
	private String nombre;
	
	public Curso() {
		super();
		setCodigo(-1);
		setNombre("");
		setCodTipoCurso(0);
		setCodPatrocinador(0);
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

	public int getCodTipoCurso() {
		return codTipoCurso;
	}

	public void setCodTipoCurso(int codTipoCurso) {
		this.codTipoCurso = codTipoCurso;
	}

	public int getCodPatrocinador() {
		return codPatrocinador;
	}

	public void setCodPatrocinador(int codPatrocinador) {
		this.codPatrocinador = codPatrocinador;
	}
	
}
