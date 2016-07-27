package com.ipartek.formacion.pojo;

/**
 *
 * @author Curso
 *
 */
public class Curso {
  public static final int CODIGO_CURSO = -1;
  private int codigo;
  private String nombre;
  private String codigoPatrocinador;
  private TipoCurso tipo;

  /**
   *
   * Max alumnos: 15 Mapa de Alumnos dni (String) CursoService(I) --> Imp : darDeAlta (Alumno
   * alumno) void darDeBaja (String dni) void
   *
   */
  public Curso() {
    super();
    setCodigo(CODIGO_CURSO);
    setNombre("");
    setTipo(TipoCurso.LANBIDE);
    setCodigoPatrocinador("");
  }

  /**
   *
   * @return codigo
   */
  public int getCodigo() {
    return codigo;
  }

  /**
   *
   * @param codigo
   *          codigo
   */
  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  /**
   *
   * @return nombre
   */
  public String getNombre() {
    return nombre;
  }

  /**
   *
   * @param nombre
   *          nombre del curso
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   *
   * @return tipo
   */
  public TipoCurso getTipo() {
    return tipo;
  }

  /**
   *
   * @param tipo
   *          TipoCurso
   */
  public void setTipo(TipoCurso tipo) {
    this.tipo = tipo;
  }

  /**
   * @Override
   *
   * @param obj
   *          Object
   * @return igual
   */
  @Override
  public boolean equals(Object obj) {
    boolean igual = false;
    if (obj instanceof Curso) {
      Curso c = (Curso) obj;
      if (this.codigo == c.getCodigo()) {
        igual = true;
      }
    }
    return igual;
  }

  /**
   * @Override
   *
   *
   * @return codigoHash
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   *
   * @return codigo patrocinador
   */
  public String getCodigoPatrocinador() {
    return codigoPatrocinador;
  }

  /**
   *
   * @param codigoPatrocinador
   *          String
   */
  public void setCodigoPatrocinador(String codigoPatrocinador) {
    this.codigoPatrocinador = codigoPatrocinador;
  }

}