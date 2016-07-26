package com.ipartek.formacion.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CursoAlumnos extends Curso {
	public final int CODIGO_CURSO_ALUMNO = -1;
	private int codigoEmitido;
	private String referencia;
	private Date fechaInicio;
	private Date fechaFin;
	private List<AlumnoModulo> alumnosModulos;

	/**
	 * 
	 */
	public CursoAlumnos() {
		super();
		this.alumnosModulos = new ArrayList<CursoAlumnos.AlumnoModulo>();
		setCodigoEmitido(CODIGO_CURSO_ALUMNO);
		setReferencia("");
		setFechaInicio(new Date(Long.MIN_VALUE));
		setFechaFin(null);//
	}

	public int getCodigoEmitido() {
		return codigoEmitido;
	}

	public void setCodigoEmitido(int codigoEmitido) {
		this.codigoEmitido = codigoEmitido;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public List<AlumnoModulo> getAlumnosModulos() {
		return alumnosModulos;
	}

	public void setAlumnosModulos(List<AlumnoModulo> alumnosModulos) {
		this.alumnosModulos = alumnosModulos;
	}

	public class AlumnoModulo {
		private Date fExamen;
		private int notaExamen;
		private Alumno alumno;
		private Modulo modulo;

		/**
		 * @param alumno
		 * @param modulo
		 */
		public AlumnoModulo(Alumno alumno, Modulo modulo) {
			super();
			this.alumno = alumno;
			this.modulo = modulo;
			setfExamen(new Date());
			setNotaExamen(0);
		}

		public Date getfExamen() {
			return fExamen;
		}

		public void setfExamen(Date fExamen) {
			this.fExamen = fExamen;
		}

		public int getNotaExamen() {
			return notaExamen;
		}

		public void setNotaExamen(int notaExamen) {
			this.notaExamen = notaExamen;
		}

		public Alumno getAlumno() {
			return alumno;
		}

		public void setAlumno(Alumno alumno) {
			this.alumno = alumno;
		}

		public Modulo getModulo() {
			return modulo;
		}

		public void setModulo(Modulo modulo) {
			this.modulo = modulo;
		}

	}

}
