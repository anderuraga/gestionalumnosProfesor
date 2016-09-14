package com.ipartek.formacion.dao.persistence;

import java.io.Serializable;

public class Modulo implements Serializable{
private int codigo;
private String nombre;
private String uFormativa;
private int duracion;
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
public String getuFormativa() {
	return uFormativa;
}
public void setuFormativa(String uFormativa) {
	this.uFormativa = uFormativa;
}
public int getDuracion() {
	return duracion;
}
public void setDuracion(int duracion) {
	this.duracion = duracion;
}

}
