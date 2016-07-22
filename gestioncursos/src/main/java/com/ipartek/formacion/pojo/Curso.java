package com.ipartek.formacion.pojo;

public class Curso {
	public static final int CODIGO_CURSO = -1;
	private int codigo;
	private String nombre;
	private TipoCurso tipo;
	private String codPatrocinador;

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
		tipo = TipoCurso.LANBIDE;
		setCodPatrocinador("");
	}

	public TipoCurso getTipo() {
		return tipo;
	}

	public void setTipo(TipoCurso tipo) {
		this.tipo = tipo;
	}

	public String getCodPatrocinador() {
		return codPatrocinador;
	}

	public void setCodPatrocinador(String codPatrocinador) {
		this.codPatrocinador = codPatrocinador;
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

	@Override
	public boolean equals(Object obj) {
		boolean igual = false;
		if (obj instanceof Curso) {
			// Curso c = (Curso) obj;
			if (((Curso) obj).getCodigo() == this.codigo) {
				igual = true;
			}

		}
		return igual;
	}

}
