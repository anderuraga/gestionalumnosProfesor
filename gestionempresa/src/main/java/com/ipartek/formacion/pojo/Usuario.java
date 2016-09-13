/**
 * 
 */
package com.ipartek.formacion.pojo;

import java.util.Date;

/**
 * @author Curso
 *
 */
public class Usuario {

	
	private String user;
	private String password;
	private String sessionId;
	private Date fechaConexion;
	
	
	public Usuario() {
		super();
		this.setUser("");
		this.setPassword("");
		this.setSessionId("");
		this.setFechaConexion(new Date());
		
	}
	
	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}


	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}


	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}


	/**
	 * @return the fechaConexion
	 */
	public Date getFechaConexion() {
		return fechaConexion;
	}


	/**
	 * @param fechaConexion the fechaConexion to set
	 */
	public void setFechaConexion(Date fechaConexion) {
		this.fechaConexion = fechaConexion;
	}


	/**
	 * 
	 */
	

}
