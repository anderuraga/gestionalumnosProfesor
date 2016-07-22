package com.ipartek.formacion.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author Imanol Jimenez
 *
 */
public class CursoAlumnos extends Curso {
  public final static int CODIGO_CURSO_ALUMNO = -1;
  private int codigoEmitido;
  private String referencia;
  private Date fechaInicio;
  private Date fechaFin;
  private List<AlumnoModulo> alumnosModulos;

  /**
   * Constructor CursoAlumnos.
   */
  public CursoAlumnos() {
    super();
    this.alumnosModulos = new ArrayList<CursoAlumnos.AlumnoModulo>();
    setCodigoEmitido(CODIGO_CURSO_ALUMNO);
    setReferencia("");
    setFechaInicio(new Date(Long.MIN_VALUE));
    setFechaFin(null);
  }

  /**
   * @author Imanol Jimenez
   */
  class AlumnoModulo {
    private Date fechaExamen;
    private int notaExamen;
    private Alumno alumno;
    private Modulo modulo;

    /**
     * @param alumno
     *          {@link Alumno}.
     * @param modulo
     *          {@link Modulo}.
     */
    public AlumnoModulo(Alumno alumno, Modulo modulo) {
      super();
      this.alumno = alumno;
      this.modulo = modulo;
      setFechaExamen(new Date());
      setNotaExamen(0);
    }

    /**
     * 
     * @return fechaExamen.
     */
    public Date getFechaExamen() {
      return fechaExamen;
    }

    /**
     * 
     * @param fechaExamen
     *          Date.
     */
    public void setFechaExamen(Date fechaExamen) {
      this.fechaExamen = fechaExamen;
    }

    /**
     * 
     * @return notaExamen.
     */
    public int getNotaExamen() {
      return notaExamen;
    }

    /**
     * 
     * @param notaExamen
     *          int.
     */
    public void setNotaExamen(int notaExamen) {
      this.notaExamen = notaExamen;
    }

    /**
     * 
     * @return alumno.
     */
    public Alumno getAlumno() {
      return alumno;
    }

    /**
     * 
     * @param alumno
     *          {@link Alumno}.
     */
    public void setAlumno(Alumno alumno) {
      this.alumno = alumno;
    }

    /**
     * 
     * @return modulo.
     */
    public Modulo getModulo() {
      return modulo;
    }

    /**
     * 
     * @param modulo
     *          {@link Modulo}.
     */
    public void setModulo(Modulo modulo) {
      this.modulo = modulo;
    }

  }

  /**
   * 
   * @return <code>int</code>
   */
  public int getCodigoEmitido() {
    return codigoEmitido;
  }

  /**
   * 
   * @param codigoEmitido
   *          <code>int</code>
   */
  public void setCodigoEmitido(int codigoEmitido) {
    this.codigoEmitido = codigoEmitido;
  }

  /**
   * @return referencia.
   */
  public String getReferencia() {
    return referencia;
  }

  /**
   * @param referencia
   *          String.
   */
  public void setReferencia(String referencia) {
    this.referencia = referencia;
  }

  /**
   * 
   * @return fecha inicio del curso.
   */
  public Date getFechaInicio() {
    return fechaInicio;
  }

  /**
   * 
   * @param fechaInicio
   *          Date.
   */
  public void setFechaInicio(Date fechaInicio) {
    this.fechaInicio = fechaInicio;
  }

  /**
   * 
   * @return fecha fin del curso.
   */
  public Date getFechaFin() {
    return fechaFin;
  }

  /**
   * 
   * @param fechaFin
   *          Date.
   */
  public void setFechaFin(Date fechaFin) {
    this.fechaFin = fechaFin;
  }

  /**
   * 
   * @return lista alumnos modulos.
   */
  public List<AlumnoModulo> getAlumnosModulos() {
    return alumnosModulos;
  }

  /**
   * 
   * @param alumnosModulos
   *          Lista.
   */
  public void setAlumnosModulos(List<AlumnoModulo> alumnosModulos) {
    this.alumnosModulos = alumnosModulos;
  }

}
