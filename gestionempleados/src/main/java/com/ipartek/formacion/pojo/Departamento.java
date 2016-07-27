package com.ipartek.formacion.pojo;

public class Departamento {
	public static final int COD_DPTO = -1;
	private int codDept;
	private String nombre;
	private String descripcion;
	private Empleado empleado;

	/**
	 * Constructor del Departamento.
	 */
	public Departamento() {
		super();
		setCodDept(COD_DPTO);
		setNombre("");
		setDescripcion("");
	}

	public int getCodDept() {
		return codDept;
	}

	public void setCodDept(int codDept) {
		this.codDept = codDept;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
