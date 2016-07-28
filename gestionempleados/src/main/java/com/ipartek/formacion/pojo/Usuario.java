package com.ipartek.formacion.pojo;

/**
 * 
 * @author Imanol Jimenez
 *
 */
public class Usuario {
  private String username;
  private String password;
  private String idSession;

  public Usuario() {
    super();
    setUsername("");
    setPassword("");

  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
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
