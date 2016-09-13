package com.ipartek.formacion.dao.persistence;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Curso {

	private int codCurso;
	@NotNull
	@Pattern(regexp="([0-9-a-z-A-Z]{4,})")
	private String nombreCurso;
	private String codPatrocinador;
	private int tipoCurso;
	
	public Curso() {
		super();
		this.setCodCurso(-1);
		this.setNombreCurso("");
		this.setCodPatrocinador("");
		this.setTipoCurso(-1);
	}

	public int getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public String getCodPatrocinador() {
		return codPatrocinador;
	}

	public void setCodPatrocinador(String codPatrocinador) {
		this.codPatrocinador = codPatrocinador;
	}

	public int getTipoCurso() {
		return tipoCurso;
	}

	public void setTipoCurso(int tipoCurso) {
		this.tipoCurso = tipoCurso;
	}
	
	
	
	
}
