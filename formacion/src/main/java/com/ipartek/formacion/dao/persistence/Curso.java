package com.ipartek.formacion.dao.persistence;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Curso {
	private int codigo;
	@NotNull
	private String nombre;
	@NotNull
	private int codPatrocinador;
	@NotNull
	private int codTipoCurso;
	
	/**
	 * 
	 */
	public Curso() {
		super();
		setCodigo(-1);
		setNombre("");
		setCodPatrocinador(-1);
		setCodTipoCurso(-1);
	}

	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	@Min(value=3)
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getCodPatrocinador() {
		return codPatrocinador;
	}
	
	public void setCodPatrocinador(int codPatrocinador) {
		this.codPatrocinador = codPatrocinador;
	}
	
	public int getCodTipoCurso() {
		return codTipoCurso;
	}
	
	public void setCodTipoCurso(int codTipoCurso) {
		this.codTipoCurso = codTipoCurso;
	}
}
