<%@page import="com.ipartek.formacion.service.i18n.I18n"%>
<%@page import="com.ipartek.formacion.pojo.Modulo"%>
<%@page import="com.ipartek.formacion.controller.Constantes"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
	<a class="btn btn-success" href="<%=Constantes.SERVLET_MODULOS%>?<%=Constantes.PAR_CODIGO%>=<%=Modulo.CODIGO_MODULO%>">
		<fmt:message key="modulo.anadir"/>
	</a> 
		<%		
			List<Modulo> modulos = (List<Modulo>) request.getAttribute(Constantes.ATT_LISTADO_MODULOS);
			if(modulos!=null){
				int i=1;
				String formulario ="";
				for(Modulo modulo: modulos){
					formulario = "<form action='"+Constantes.SERVLET_MODULOS
							+"' method='post'>";
					//la variable opercion
					formulario +="<input type='hidden' "+
							"name='"+Constantes.PAR_OPERACION+
							"' value='"+Constantes.OP_DELETE+"'/>";
					//la variable del codigo del curso
					formulario +="<input type='hidden' "+
							"name='"+Constantes.PAR_CODIGO+
							"' value='"+modulo.getCodigo()+"'/>";
					//el boton de borrar
					formulario +="<button type='submit' class='btn btn-danger'><fmt:message key=\"listado.borrar\"/></button>";
					formulario +="</form>";
					%>
				<div class="row">
					<a class="col-xs-10 col-md-6" href='<%=Constantes.SERVLET_MODULOS %>
						?<%=Constantes.PAR_CODIGO%>=<%=modulo.getCodigo() %>'>
						<%=modulo.getNombre() %>
					</a>
					<%=formulario %>						
				</div>
				<%
				}
			}
		%>
</main>
<%@ include file="../includes/footer.jsp" %>