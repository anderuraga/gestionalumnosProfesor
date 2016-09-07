<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<jsp:include page="../include/header.jsp" />
<!-- librerias para tags de spring -->
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!--
<c:set var="curso" value="${curso}" />
  
<form action="/formacion/cursos" method="POST">
  Codigo: <input type="text" name="codigo" value="${curso.codigo}">
  Nombre: <input type="text" name="nombre" value="${curso.nombre}">
  <input type="submit" value="Update">
</form>
-->
<form:form action="save" commandName="curso" >
	<c:if test="${curso.codigo>0}">
		<form:label path="codigo">
			<spring:message text="Codigo: "/>
		</form:label>
		<form:input path="codigo" readonly="true" size="10" disabled="true"/>
		<form:hidden path="codigo"/>
	</c:if>
	<form:label path="nombre">
		<spring:message text="Nombre: "/>
	</form:label>
	<form:input path="nombre"/>
	<c:if test="${curso.codigo >0}">
		<input type="submit" value='<spring:message text="Editar Curso"/>'/>
	</c:if>
	<c:if test="${curso.codigo <0}">
		<input type="submit" value='<spring:message text="Crear Curso"/>'/>
	</c:if>
</form:form>

</body>
</html>