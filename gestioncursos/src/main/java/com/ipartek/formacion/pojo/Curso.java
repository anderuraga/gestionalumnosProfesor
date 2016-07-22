package com.ipartek.formacion.pojo;

import com.ipartek.formacion.services.TipoCurso;

public class Curso {
	public static final int CODIGO_CURSO = -1;
	protected int codigo;
	protected String nombre;
	protected TipoCurso tc;

	/*
	 * Mapa de Alumnos dni (String) ServiceCurso(I) ---> Imp darDeAlta (int
	 * codigo,Alumno alumno) void ---> Imp darDeBaja (int codigo,String dni)
	 * void
	 * 
	 */
	public Curso() {
		super();
		setCodigo(CODIGO_CURSO);
		setNombre("");
		setTc(tc.LANBIDE);

	}

	@Override
	public boolean equals(Object obj) {
		boolean bool = false;
		if (obj instanceof Curso) {
			Curso c = (Curso) obj;
			if (c.getCodigo() == this.codigo) {
				bool = true;
			}
		}
		return bool;
	}

	public TipoCurso getTc() {
		return tc;
	}

	public void setTc(TipoCurso tc) {
		this.tc = tc;
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
}
