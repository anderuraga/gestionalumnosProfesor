<%@page import="com.ipartek.formacion.service.i18n.I18n"%>
<%@page import="com.ipartek.formacion.pojo.Idioma"%>
<%@page import="java.util.List"%>
<%@page import="com.ipartek.formacion.pojo.Usuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="com.ipartek.formacion.controller.Constantes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="language" value="en_EN"/>
<c:set var="language" value="<%=I18n.getBrowserLocale(response.getLocale()) %>"/>
<c:set var="language" value="${sessionScope.usuario.idioma.locale}" scope="page"/> <!-- scope equivale a request.setattribute (mejor no usarlo) -->
<c:set var="localeCode" value="${response.locale}"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="com.ipartek.formacion.service.i18n.i18nmessages"/>
<jsp:include page="includes/header.jsp"/> 
<html lang="${language}">	
<main class="container-fluid">
	<div class="row">	 
	<section class="col-xs-12 col-md-7">
		<header> <h2><fmt:message key="index.bienvenido"/></h2></header>
		<p>
			<fmt:message key="index.frase"/>

		</p>
		
	</section>
	<aside class="col-xs-12 col-md-5 panel">
		<jsp:include page="includes/mensaje.jsp" />
		<div class="panel panel-success">
   
   		<div class="panel-heading">
       		<div class="panel-title"><h2><fmt:message key="index.login"/></h2></div>
       
   			</div>     

   			<div class="panel-body">
       			<form class="form-horizontal" action="<%=Constantes.SERVLET_LOGIN %>" method="post" role="form">
           			<div class="input-group">
           			<c:set var="userName" value="${cookie.c_usuario.value}"/>
           				<label class="sr-only" for="<%=Constantes.PAR_USERNAME %>">
           					<fmt:message key="index.usuario"/>
           				</label>
           				<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
						<input id="<%=Constantes.PAR_USERNAME %>" name="<%=Constantes.PAR_USERNAME %>" type="text" class="form-control" value="${userName}" placeholder=<fmt:message key="index.introusu"/>>                                        
           			
           			</div>
		           <div class="input-group">
		           		<label class="sr-only" for="<%=Constantes.PAR_PASSWORD%>">
		           			<fmt:message key="index.contrasena"/>
		           		</label>
						<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
						<input name="<%=Constantes.PAR_PASSWORD%>" value="${cookie.c_password.value}" id="<%=Constantes.PAR_PASSWORD%>" type="password" class="form-control" placeholder=<fmt:message key="index.intropassw"/>>
		            </div>
		            <div class="input-group">
						<label><fmt:message key="index.idioma"/> </label>
						<select name="<%=Constantes.PAR_IDIOMA%>">
							<c:forEach items="<%=Idioma.values()%>" var="idiomas"> <!-- for(Idioma idiomas: Idioma.getvalues()) -->
								<option value="${idiomas.codigo}">
									${idiomas.nombre}
								</option>
							</c:forEach>
						</select>
					</div>
		           <div class="input-group">
						<div class="checkbox">
			            	<label>  </label>
								<input id="<%=Constantes.PAR_REMEMBER %>" name="<%=Constantes.PAR_REMEMBER %>" type="checkbox" value="1"> 
								<label for="<%=Constantes.PAR_REMEMBER %>" ><fmt:message key="index.recuerdame"/> </label>
			            </div>
                   </div>
               <div class="form-group">
                   <div class="col-xs-12 controls">
                     <button type="submit" id="btn-login" class="btn btn-success"><fmt:message key="index.aceptar"/> </button>
                   </div>
               </div>   
           </form>     
       </div><!--panel-body-->                     
   </div>
	</aside> 
	</div>
</main>
<%@ include file="includes/footer.jsp" %>
