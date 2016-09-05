<%@page import="com.ipartek.formacion.dao.persistencia.Alumno"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="../includes/header.jsp"/>

<main>

	
	<%
 
	List<Alumno>alumnos = (List<Alumno>)request.getAttribute("listado-alumnos");
	if((alumnos!=null) && (alumnos.size()>0)){
		for(Alumno alumno: alumnos){
			out.print(alumno.getNombre()+""+alumno.getApellidos());
		}
		
	}else{
		%>
		  <p>No se han encontrado alumnos en la BBDD.</p>
		<%
	}

%>

</main>