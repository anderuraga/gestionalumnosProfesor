<%@page import="com.ipartek.formacion.service.i18n.I18n"%>
<%@page import="com.ipartek.formacion.controller.Constantes"%>
<%@page import="com.ipartek.formacion.pojo.Alumno"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="language" value="en_EN"/>
<c:set var="language" value="<%=I18n.getBrowserLocale(response.getLocale()) %>"/>
<c:set var="language" value="${sessionScope.usuario.idioma.locale}" scope="page"/> <!-- scope equivale a request.setattribute (mejor no usarlo) -->
<c:set var="localeCode" value="${response.locale}"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="com.ipartek.formacion.service.i18n.i18nmessages"/>
<jsp:include page="../includes/header.jsp"/>
<html lang="${language}">
<main>
		<a class="btn btn-warning" href="index.jsp"><fmt:message key="listado.atras"/></a> 
		<a class="btn btn-success"
				href="<%=Constantes.SERVLET_ALUMNOS+"?"+
						Constantes.PAR_CODIGO+"="+
						Alumno.CODIGO_ALUMNO%>">
				<fmt:message key="listadoalum.nuevo"/>
				</a>
		
		
		<%		
			List<Alumno> alumnos = (List<Alumno>) request.getAttribute(Constantes.ATT_LISTADO_ALUMNOS);
		
			if(alumnos!=null){
				int i=1;
				String formulario ="";
				for(Alumno alumno: alumnos){
					formulario = "<form class='col-xs-2 col-md-6' action='"+Constantes.SERVLET_ALUMNOS
							+"' method='post'>";
					//la variable opercion
					formulario +="<input type='hidden' "+
							"name='"+Constantes.PAR_OPERACION+
							"' value='"+Constantes.OP_DELETE+"'/>";
					//la variable del codigo del curso
					formulario +="<input type='hidden' "+
							"name='"+Constantes.PAR_CODIGO+
							"' value='"+alumno.getCodigo()+"'/>";
					//el boton de borrar
					formulario +="<button type='submit' class='btn btn-danger'><fmt:message key=\"listado.borrar\"/></button>";
					formulario +="</form>";
					%> 
					<div class="row">
						<a class="col-xs-10 col-md-6" href="<%=Constantes.SERVLET_ALUMNOS%>?<%=Constantes.PAR_CODIGO%>=<%=alumno.getCodigo() %> "><%=alumno.getNombre()%> <%=alumno.getApellidos() %></a>
						<%=formulario %>
					</div>
				<%
				}
			}
		%>
</main>
<%@include file="../includes/footer.jsp" %>