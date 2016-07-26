package com.ipartek.formacion.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CursoAlumno extends Curso {

  private final int CURSO_ALUMNO_NUEVO = -1;
  private int codigoEmitido;
  private String referencia;
  private Date fInicio;
  private Date fFin;
  private List<AlumnoModulo> alumnosModulos;

  public CursoAlumno() {
    super();
    this.setfFin(new Date());
    this.setfInicio(new Date());
    this.setReferencia("");
    this.alumnosModulos = new ArrayList<CursoAlumno.AlumnoModulo>();
    this.setCodigoEmitido(0);
  }

  public int getCodigoEmitido() {
    return codigoEmitido;
  }

  public void setCodigoEmitido(int codigoEmitido) {
    this.codigoEmitido = codigoEmitido;
  }

  public int getCURSO_ALUMNO_NUEVO() {
    return CURSO_ALUMNO_NUEVO;
  }

  public String getReferencia() {
    return this.referencia;
  }

  public void setReferencia(String referencia) {
    this.referencia = referencia;
  }

  public Date getfInicio() {
    return this.fInicio;
  }

  public void setfInicio(Date fInicio) {
    this.fInicio = fInicio;
  }

  public Date getfFin() {
    return this.fFin;
  }

  public void setfFin(Date fFin) {
    this.fFin = fFin;
  }

  public List<AlumnoModulo> getAlumnosModulos() {
    return this.alumnosModulos;
  }

  public void setAlumnosModulos(List<AlumnoModulo> alumnosModulos) {
    this.alumnosModulos = alumnosModulos;
  }

  /*
   * Necesitamos meter una clase dentro de otra, esto se da porque para poner la calificacion de un
   * alumno en un modulo, necesitamos que el modulo este dentro de un curso y ademas que el alumno
   * este matriculado en un curso. Es decir para sacar las notas de un alumno en un modulo
   * determinado, necesitamos un curso, por esto realizamos una clase dentro de otra.
   */
  /*
   * Hay dos tipos de enlaces entre clases, agregacion y composicion. La agregacion es meter alumnos
   * en un curso por ejemplo, el uno depende del otro La composicion es meter una nota a un alumno
   * en un modulo, que no tienen relacion directa sino que necesitamos el curso para que esta
   * relacion exista
   */
  public class AlumnoModulo {

    private Date fExamen = null;
    private int notaExamen = 0;
    private Alumno alumno = null;
    private Modulo modulo = null;

    public AlumnoModulo(Alumno alumno, Modulo modulo) {
      super();
      this.alumno = alumno;
      this.modulo = modulo;
      setfExamen(null);
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
