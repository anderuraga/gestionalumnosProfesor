package com.ipartek.formacion.dao.persistence;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Curso implements Serializable{
	private int codigo;
	@Min(3)
	@NotNull
	@Pattern( regexp = "(a-z|A-Z])")
	private String nombre;
	private int codTipoCurso;
	private String codPatrocinador;
	public Curso() {
		super();
		setCodigo(-1);
		setNombre("");
		setCodTipoCurso(1);
		
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

	public String getCodPatrocinador() {
		return codPatrocinador;
	}

	public void setCodPatrocinador(String codPatrocinador) {
		this.codPatrocinador = codPatrocinador;
	}
	
}
