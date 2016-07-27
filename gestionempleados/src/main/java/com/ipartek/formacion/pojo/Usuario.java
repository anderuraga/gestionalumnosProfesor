package com.ipartek.formacion.pojo;

public class Usuario {
	public static final int CODIGO_USU = -1;
	
	private int idUsuario;
	private String userName;
	private String password;
	private String idSession;
	/**
	 * 
	 */
	public Usuario() {
		super();
		this.setUserName("");
		this.setPassword("");
		this.setIdUsuario(CODIGO_USU);
		this.setIdSession("");
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdSession() {
		return idSession;
	}

	public void setIdSession(String idSession) {
		this.idSession = idSession;
	}
	
	

}
