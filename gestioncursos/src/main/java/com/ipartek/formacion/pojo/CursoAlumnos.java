package com.ipartek.formacion.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CursoAlumnos extends Curso{

	private String referencia;
	private Date fechaInicio;
	private Date fechaFin;
	private List<AlumnoModulo> alumnosmodulos;
	
	class AlumnoModulo{
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
	
	
	public CursoAlumnos() {
		super();
		this.alumnosmodulos = new ArrayList<CursoAlumnos.AlumnoModulo>();
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

	public List<AlumnoModulo> getAlumnosmodulos() {
		return alumnosmodulos;
	}

	public void setAlumnosmodulos(List<AlumnoModulo> alumnosmodulos) {
		this.alumnosmodulos = alumnosmodulos;
	}
	
	
	
}
