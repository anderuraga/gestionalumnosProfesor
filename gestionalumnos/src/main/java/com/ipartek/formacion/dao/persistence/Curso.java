package com.ipartek.formacion.dao.persistence;

public class Curso {

	private int codigo;
	private int codTipoCurso;
	private String nombre;
	private String codPatrocinador;

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

	public String getCodPatrocinador() {
		return codPatrocinador;
	}

	public void setCodPatrocinador(String codPatrocinador) {
		this.codPatrocinador = codPatrocinador;
	}


	public int getCodTipoCurso() {
		return codTipoCurso;
	}

	public void setCodTipoCurso(int codTipoCurso) {
		this.codTipoCurso = codTipoCurso;
	}

	/**
	 * @param codigo
	 * @param nombre
	 */
	public Curso(int codigo, int codTipoCurso, String nombre, String codPatrocinador) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.codPatrocinador = codPatrocinador;
		this.codTipoCurso = codTipoCurso;
	}

	/**
	 * 
	 */
	public Curso() {
		super();
		setCodigo(-1);
		setNombre("");
		setCodPatrocinador("");
		setCodTipoCurso(0);

	}

}
