package com.ipartek.formacion.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CursoAlumno extends Curso {
	
	private String referencia;
	private Date fechaInicio;
	private Date fechaFin;
	private List<AlumnoModulo> alumnosmodulos;
	
	public CursoAlumno() {
		super();
		this.alumnosmodulos = new ArrayList<CursoAlumno.AlumnoModulo>();
	}
	
	class AlumnoModulo {
		private Date fExamen;
		private int notaExamen;
		private Alumno alumno;
		private Modulo modulo;

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
