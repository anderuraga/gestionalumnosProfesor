<%@page import="com.ipartek.formacion.service.i18n.I18n"%>
<%@page import="com.ipartek.formacion.controller.Constantes"%>
<%@page import="com.ipartek.formacion.pojo.Usuario"%>
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
<main >
<section >
	<header><h2><fmt:message key="admin.cabecera"/></h2></header>
	<div>
	<%
	ServletContext context = getServletContext();
	List<Usuario> usuarios = (List<Usuario>)context.getAttribute(Constantes.ATT_LIST_USUARIOS);
	
	if(usuarios!=null){
		%>
	<jsp:include page="../includes/mensaje.jsp"/>
		<div  class="row">
			<div class="col-xs-4"><fmt:message key="admin.sessionid"/></div>
			<div class="col-xs-3"><fmt:message key="admin.nombre"/></div>
			<div class="col-xs-3"><fmt:message key="admin.alias"/></div>
			<div class="col-xs-2"></div>
		</div>
		<%
		
		for(Usuario user: usuarios){
			
			%>
			<div  class="row">
				<div class="col-xs-4"><%=user.getSessionid() %></div>
				<div class="col-xs-3"><%=user.getUserName() %></div>
				<div class="col-xs-3"><%=user.getNickname() %></div>
				<div class="col-xs-2"><a class="btn btn-info" href="<%=Constantes.SERVLET_ADMINISTRACION %>?<%=Constantes.PAR_SESSIONID %>=<%=user.getSessionid()%>">
					<fmt:message key="admin.expulsar"/>
				</a></div>
			</div>
			<%
		}
	}else{
		%>
		<p ><fmt:message key="admin.noconec"/></p>
		<%
	}
	%>
	</div>
</section>
</main>
<%@include file="../includes/footer.jsp" %>
		