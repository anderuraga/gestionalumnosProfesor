package com.ipartek.formacion.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ipartek.formacion.service.Idiomas;

public class Curso {
	public static final int CODIGO_CURSO = -1;
	private int codigo;
	private String nombre;
	private TipoCurso tipo;
	private String referencia;
	
	
	
	//constructor
	public Curso() {
		super();
		setCodigo(CODIGO_CURSO);
		setNombre("");
		setReferencia("");
	}
	
	//getters y setters
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

	
	public TipoCurso getTipo() {
		return tipo;
	}

	public void setTipo(TipoCurso tipo) {
		this.tipo = tipo;
	}
	
	

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	@Override //método para comparar dos objetos según lo que queramos
	public boolean equals(Object obj) {
		boolean igual = false;
		if(obj instanceof Curso){
			Curso c = (Curso) obj; //hago el castin
			if(c.getCodigo()==this.codigo) 
			{
				igual = true;
			}
		}
		
		return igual;
	}
	
	
	

}
