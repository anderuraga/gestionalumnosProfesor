<%@page import="com.ipartek.formacion.controller.listener.InitListener"%>
<%@page import="com.ipartek.formacion.pojo.Empleado"%>
<%@page import="java.util.Properties"%>
<%@page import="java.util.List"%>



<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../includes/header.jsp" />

<%
	Properties props = (Properties) getServletContext().getAttribute(InitListener.PROPS_NAME);
	// LLAMAR A ATT EMPLEADO 
Empleado empleado = (Empleado) request.getAttribute(props.getProperty("attEmpleado"));
//	Empleado empleado = (Empleado) request.getAttribute("empleado");
	int op = -1;
	if (empleado != null) {
		// LLAMAR A CODIGO DE OPERACION UPDATE
%><title>Empleado <%=empleado.getNombre()%></title>
<%
	}
	else {
%><title>Agregar Empleado - Modulo nuevo</title>
<%
	empleado = new Empleado();
		//LLAMAR A CODIGO DE OPERACION CREATE
	}
%>


</main>
<%@ include file="../includes/footer.jsp"%>