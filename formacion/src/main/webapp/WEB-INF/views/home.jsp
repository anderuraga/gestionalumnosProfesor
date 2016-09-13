<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@page import="java.util.List"%>
<%@page import="com.ipartek.formacion.dao.persistence.Alumno"%>
<%@page import="com.ipartek.formacion.dao.persistence.Curso"%>
<%@page import="com.ipartek.formacion.dao.persistence.Modulo"%>
<jsp:include page="includes/header.jsp" />
<main>
<h1>
	Bienvenido a la aplicaci�n de gesti�n de alumnos de Ipartek.
</h1>
<a href="alumnos/addAlumno">Crear Alumno</a>
<a href="cursos/addCurso">Crear Curso</a>
<a href="modulos/addModulo">Crear Modulo</a>
<%
	List <Alumno> alumnos=(List<Alumno>)request.getAttribute("listado-alumnos");

	if(alumnos.size()>0){
		for(Alumno a:alumnos){
			out.print("<p>"+a.getNombre()+" "+ a.getApellidos()+"</p>");
		}
		
	}else{
		%>
		No se han encontrado alumnos en la BBDD.
		<%
	}


%>

<%
	List <Modulo> modulos=(List<Modulo>)request.getAttribute("listado-modulos");

	if(modulos.size()>0){
		for(Modulo m:modulos){
			out.print("<p>"+m.getNombreModulo()+" "+ m.getuFormativa()+"</p>");
		}
		
	}else{
		%>
		No se han encontrado Modulos en la BBDD.
		<%
	}


%>

</main>
<%@ include file="includes/footer.jsp"%>