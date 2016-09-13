/**
 * 
 */
package com.ipartek.formacion.pojo;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Curso
 *
 */
public class Curso {

	public static final int CODIGO_CURSO=-1;
	private int codigo;
	private String nombre;
	
	private TipoCurso tipoCurso;
	private Duracion duracionCurso;
	private String codPatrocinador;
	
	
	/**
	 * Mapa de alumnos dni(String)
	 * ServiceAlumno(i)--->IMP
	 * void darDeAlta(alumno)/void dar de baja(String dni)
	 * 
	 */
	public Curso() {
		super();
		this.setCodigo(CODIGO_CURSO);
		this.setNombre("");
		
		
		setTipoCurso(TipoCurso.LANBIDE);
		setDuracionCurso(Duracion.CUARENTAYCINCO);
		this.setCodPatrocinador("");
	}
	public TipoCurso getTipoCurso() {
		return tipoCurso;
	}
	public void setTipoCurso(TipoCurso tipoCurso) {
		this.tipoCurso = tipoCurso;
	}
	public Duracion getDuracionCurso() {
		return duracionCurso;
	}
	public void setDuracionCurso(Duracion duracionCurso) {
		
		this.duracionCurso = duracionCurso;
	}
	public String getCodPatrocinador() {
		return codPatrocinador;
	}
	public void setCodPatrocinador(String codPatrocinador) {
		this.codPatrocinador = codPatrocinador;
	}
	
	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public boolean equals(Object obj) {
		boolean igual=false;
		if (obj instanceof Curso) {
			Curso c=(Curso)obj;
			if (c.getCodigo()==this.codigo) {
				igual=true;
			}
		}
		return igual;
	}
	@Override
	public String toString() {
		return "Curso [codigo=" + codigo + ", nombre=" + nombre +  ", tipoCurso=" + tipoCurso + ", duracionCurso=" + duracionCurso + ", codPatrocinador="
				+ codPatrocinador + "]";
	}

	
	
	
}
