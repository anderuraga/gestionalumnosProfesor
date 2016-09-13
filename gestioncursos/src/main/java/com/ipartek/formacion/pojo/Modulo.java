/**
 * 
 */
package com.ipartek.formacion.pojo;

import java.io.Serializable;

/**
 * @author Curso
 *
 */
public class Modulo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int CODIGO_MODULO=-1;
	private int codModulo;
	private String nombreModulo;
	private String uFormativa;
	private Duracion durModulo;
	
	
	/**
	 * 
	 */
	public Modulo() {
		super();
		setCodModulo(CODIGO_MODULO);
		setNombre("");
		
	}
	/**
	 * @return the codigoModulo
	 */
	public int getCodModulo() {
		return codModulo;
	}
	/**
	 * @param codigoModulo the codigoModulo to set
	 */
	public void setCodModulo(int codigo) {
		this.codModulo = codigo;
	}
	/**
	 * @return the nombreModulo
	 */
	public String getNombreModulo() {
		return nombreModulo;
	}
	/**
	 * @param nombreModulo the nombreModulo to set
	 */
	public void setNombre(String nombre) {
		this.nombreModulo = nombre;
	}
	
	public String getUFormativa() {
		return uFormativa;
	}
	public void setUFormativa(String uFormativa) {
		this.uFormativa = uFormativa;
	}
	public Duracion getDurModulo() {
		return durModulo;
	}
	public void setDurModulo(Duracion durModulo) {
		this.durModulo = durModulo;
	}
	
	
	
	
	
}
