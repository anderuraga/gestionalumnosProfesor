/**
 * 
 */
package com.ipartek.formacion.pojo;

/**
 * @author Curso
 *
 */
public class Departamento {

	public static final int CODIGO_DEPARTAMENTO=-1;
	private int codDpto;
	private String nombreDpto;
	private String descDpto;
	/**
	 * 
	 */
	public Departamento() {
		super();
		this.setCodDpto(CODIGO_DEPARTAMENTO);
		this.setNombreDpto("");
		this.setDescDpto("");
	}
	/**
	 * @return the codDpto
	 */
	public int getCodDpto() {
		return codDpto;
	}
	/**
	 * @param codDpto the codDpto to set
	 */
	public void setCodDpto(int codDpto) {
		this.codDpto = codDpto;
	}
	/**
	 * @return the nombreDpto
	 */
	public String getNombreDpto() {
		return nombreDpto;
	}
	/**
	 * @param nombreDpto the nombreDpto to set
	 */
	public void setNombreDpto(String nombreDpto) {
		this.nombreDpto = nombreDpto;
	}
	/**
	 * @return the descDpto
	 */
	public String getDescDpto() {
		return descDpto;
	}
	/**
	 * @param descDpto the descDpto to set
	 */
	public void setDescDpto(String descDpto) {
		this.descDpto = descDpto;
	}
	
	
	
}
