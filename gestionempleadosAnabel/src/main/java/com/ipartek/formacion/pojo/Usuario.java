package com.ipartek.formacion.pojo;

public class Usuario {

  private String user;
  private String pass;

  public Usuario() {
    setPass("");
    setUser("");
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

}
