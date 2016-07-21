<%@page import="com.ipartek.formacion.service.i18n.I18n"%>
<%@page import="com.ipartek.formacion.pojo.DuracionModulo"%>
<%@page import="com.ipartek.formacion.pojo.Modulo"%>
<%@page import="com.ipartek.formacion.controller.Constantes"%>
<%@page import="com.ipartek.formacion.pojo.Modulo"%>
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
<jsp:include page="../includes/header.jsp" />
<html lang="${language}">
		<%
		Modulo modulo = (Modulo) request.getAttribute(Constantes.ATT_MODULO);
		int op = -1;
		if(modulo!=null){
			op = Constantes.OP_UPDATE;
		}else{
			modulo = new Modulo();
			op = Constantes.OP_CREATE;
		}
		%>
<main class="row">
		<a class="btn btn-warning" href="<%=Constantes.SERVLET_MODULOS %>"><fmt:message key="listado.atras"/></a>
		<%
		if(modulo!=null){
		%>
		
			<form name="" id="" method='post' 
				action="<%=Constantes.SERVLET_MODULOS%>">
				<input type="hidden" 
					id="<%=Constantes.PAR_OPERACION %>"
					name="<%=Constantes.PAR_OPERACION %>"  
					value="<%=op %>"/>
				<input type="hidden" 
					id="<%=Constantes.PAR_CODIGO %>" 
					name="<%=Constantes.PAR_CODIGO %>" 
					value="<%=modulo.getCodigo()%>"/>
				<div class="form-group">
					<label for="<%=Constantes.PAR_NOMBRE%>"><fmt:message key="alumno.nombre"/></label>
					<input type="text" 
						name="<%=Constantes.PAR_NOMBRE%>" 
						id="<%=Constantes.PAR_NOMBRE%>" 
						value="<%=modulo.getNombre() %>" />
				</div>
				<div class="form-group">				
				<label for="<%=Constantes.PAR_REFERENCIA%>"><fmt:message key="modulo.ref"/></label>
				<input type="text" 
					name="<%=Constantes.PAR_REFERENCIA%>" 
					id="<%=Constantes.PAR_REFERENCIA%>" 
					value="<%=modulo.getReferencia()%>"/>
				</div>
				<div class="form-group">
					<label><fmt:message key="modulo.duracion"/></label>
					<select name="<%=Constantes.PAR_DURACION%>">
					<%
					DuracionModulo[] duraciones = (DuracionModulo[])request.getAttribute(Constantes.ATT_LISTA_DURACION_MODULO);
					if(duraciones!=null){
						for(DuracionModulo duracion: duraciones){
							%>
						<option <%= duracion.equals(modulo.getDuracion()) ? "selected" : ""%> value="<%=duracion.getCodigo()%>"><%=duracion.getDuracionHoras() %></option>
							<%
						}
					}
					
					%>
					</select>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-success">
						<fmt:message key="modulo.guardar"/>
					</button>
				</div>
			</form>	
	<%	
	}
		%>
</main>
<%@ include file="../includes/footer.jsp" %>