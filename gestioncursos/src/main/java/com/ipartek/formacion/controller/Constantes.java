package com.ipartek.formacion.controller;

/**
 * 
 * @author Curso
 *
 */
public class Constantes {
  /**
   * 
   */
  private Constantes() {
  }

  public final static String ATT_USUARIO = "usuario";
  public final static String ATT_LISTADO_USUARIOS = "listado_usuarios";

  public final static String ATT_LISTADO_CURSOS = "listado_cursos";
  public final static String ATT_CURSO = "curso";

  public final static String ATT_LISTADO_ALUMNOS = "listado_alumnos";
  public final static String ATT_ALUMNO = "alumno";

  public final static String ATT_LISTADO_MODULOS = "listado_modulos";
  public final static String ATT_MODULO = "modulo";

  public final static String ATT_LISTADO_SESIONES = "listado_sesiones";

  public final static String PAR_CODIGO = "codigo";
  public final static String PAR_NOMBRE = "nombre";
  public final static String PAR_APELLIDOS = "apellidos";
  public final static String PAR_EMAIL = "email";
  public final static String PAR_TELEFONO = "telefono";
  public final static String PAR_DNI = "dni";
  public final static String PAR_MES = "mes";
  public final static String PAR_DIA = "dia";
  public final static String PAR_ANYO = "anyo";
  public final static String PAR_GENERO = "genero";
  public final static String PAR_IDIOMA = "idioma";
  public final static String PAR_CURSO = "curso_alumno";
  public final static String PAR_CODIGO_PATROCINADOR = "codPatrocinador";
  public final static String PAR_OPERACION = "operacion";

  public final static String PAR_REFERENCIA = "referencia";
  public final static String PAR_DURACION = "duracion";

  public final static String PAR_LOCALE = "locale";

  public final static String PAR_TIPO = "tipo";
  public final static String PAR_ALUMNOS = "alumnos";
  public final static String PAR_MODULOS = "modulos";

  public final static String PAR_SESSION_ID = "idSession";

  public final static String PAR_USUARIO = "alias";
  public final static String PAR_PASSWORD = "password";
  public final static String PAR_RECUERDA = "recuerda";

  public final static String JSP_LISTADO_CURSOS = "/cursos/listado.jsp";
  public final static String JSP_CURSO = "/cursos/curso.jsp";

  public final static String JSP_LISTADO_USUARIOS = "/administracion/listadoUsuarios.jsp";

  public final static String JSP_LISTADO_ALUMNOS = "/alumnos/listado.jsp";
  public final static String JSP_ALUMNO = "/alumnos/alumno.jsp";

  public final static String JSP_LISTADO_MODULOS = "/modulos/listado.jsp";
  public final static String JSP_MODULO = "/modulos/modulo.jsp";

  public final static String JSP_INDEX = "/index.jsp";

  public final static String MSG_ERROR = "error";
  public final static String MSG_EXITO = "mensaje";

  public final static String SERVLET_CURSOS = "cursos.do";
  public final static String SERVLET_ALUMNOS = "alumnos.do";
  public final static String SERVLET_MODULOS = "modulos.do";
  public final static String SERVLET_LOGIN = "login.do";
  public final static String SERVLET_LOGOUT = "logout.do";
  public final static String SERVLET_ADMIN = "admin.do";

  public final static int OP_CREATE = 0;
  public final static int OP_READ = 1;
  public final static int OP_UPDATE = 2;
  public final static int OP_DELETE = 3;
}