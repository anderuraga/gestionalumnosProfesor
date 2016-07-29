package com.ipartek.formacion.controller;

public class Constantes {
	private Constantes() {}


	public final static String ATT_LISTADO_DEPARTAMENTOS= "listado_departamentos";
	public final static String ATT_DEPARTAMENTO = "departamento";

	public final static String ATT_LISTADO_EMPLEADOS ="listado_empleados";
	public final static String ATT_EMPLEADO ="empleado";
	
	public final static String ATT_MENSAJE ="mensaje";

	public final static String ATT_USUARIO = "usuario";
	public final static String ATT_LIST_USUARIOS ="lista_usuarios";

	public final static String ATT_LISTADO_SESIONES ="listado_sesiones";

	public final static String PAR_CODIGO= "codigo";
	public final static String PAR_NOMBRE ="nombre";

	public final static String PAR_LISTADO_EMPLEADOS="codigos_empleados";

	public final static String PAR_DNI = "dni";
	public final static String PAR_APELLIDOS = "apellidos";
	public final static String PAR_OPERACION ="operacion";
	public final static String PAR_MES_NAC ="mesNac";
	public final static String PAR_DIA_NAC ="diaNac";
	public final static String PAR_ANYO_NAC ="anyoNac";
	public final static String PAR_MES_CON ="mesCon";
	public final static String PAR_DIA_CON ="diaCon";
	public final static String PAR_ANYO_CON ="anyoCon";
	public final static String PAR_IDIOMA ="idioma";
	public final static String PAR_DEPARTAMENTO ="departamento";
	public final static String PAR_DIRECCION ="direccion";
	public final static String PAR_LOCALIDAD ="localidad";
	public final static String PAR_CODIGOPOSTAL ="codigopostal";
	public final static String PAR_NSS ="nss";
	public final static String PAR_CC ="cc";



	public final static String PAR_TIPODEPARTAMENTO ="tipo_departamento";
	public final static String PAR_DESCRIPCION="descripcion";

	public final static String PAR_USERNAME ="username";
	public final static String PAR_PASSWORD ="password";
	public final static String PAR_REMEMBER ="recuerda";

	public final static String PAR_SESSIONID ="sessionid";
	public final static String SERVLET_DEPARTAMENTOS ="departamentos.do";
	public final static String SERVLET_EMPLEADOS ="empleados.do";
	public final static String SERVLET_LOGIN ="login.do";
	public final static String SERVLET_ADMINISTRACION ="administracion.do";
	public final static String SERVLET_LOGOUT ="logout.do";

	public final static String JSP_HOME ="index.jsp";

	public final static String JSP_LISTADO_DEPARTAMENTOS ="/departamentos/listado.jsp";
	public final static String JSP_DEPARTAMENTO ="/departamentos/departamento.jsp";

	public final static String JSP_LISTADO_EMPLEADOS ="/empleados/listado.jsp";
	public final static String JSP_EMPLEADO ="/empleados/empleado.jsp";

	public final static String JSP_LISTADO_MODULOS ="/modulos/listado.jsp";
	public final static String JSP_MODULO ="/modulos/modulo.jsp";

	public final static String JSP_LISTADO_USUARIOS ="/administracion/listado-usuarios.jsp";

	public final static int OP_CREATE = 0;
	public final static int OP_READ = 1;
	public final static int OP_UPDATE = 2;
	public final static int OP_DELETE = 3;
}
