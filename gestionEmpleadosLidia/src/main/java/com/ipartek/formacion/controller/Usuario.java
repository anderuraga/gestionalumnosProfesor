package com.ipartek.formacion.controller;

public class Usuario {

	private String usuario;
	private String password;
	private String sesionId;
	
	public Usuario() {
		super();
		this.usuario="";
		this.password="";
		
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSesionId() {
		return sesionId;
	}

	public void setIdSession(String sesionId) {
		this.sesionId = sesionId;
	}
	
	
}
