<%@page import="com.ipartek.formacion.dao.persistence.Alumno"%>
<%@page import="java.util.List"%>
<!-- libreria para tags de jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!-- librerias para tags de spring -->
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<jsp:include page="../include/header.jsp" />

<c:set var="alumno" value="${alumno}" />
<!--  
<form action="/formacion/alumnos" method="POST">
  Codigo: <input type="text" name="codigo" value="${alumno.codigo}">
  Nombre: <input type="text" name="nombre" value="${alumno.nombre}">
  Apellidos: <input type="text" name="apellidos" value="${alumno.apellidos}">
  <input type="submit" value="Update">
</form>
-->
<form:form action="save" commandName="alumno" >
	<c:if test="${alumno.codigo>0}">
		<form:label path="codigo">
			<spring:message text="Codigo: "/>
		</form:label>
		<form:input path="codigo" readonly="true" size="10" disabled="true"/>
		<form:hidden path="codigo"/>
	</c:if>
	<form:label path="nombre">
		<spring:message code="alumno.nombre"/>
	</form:label>
	<form:input path="nombre"/>
	<form:errors cssClass="" path="nombre"/>
	<form:label path="apellidos">
		<spring:message text="Apellidos: "/>
	</form:label>
	<form:input path="apellidos"/>
	<form:errors cssClass="" path="apellidos"/>
	<c:if test="${alumno.codigo >0}">
		<input type="submit" value='<spring:message text="Editar Alumno"/>'/>
	</c:if>
	<c:if test="${alumno.codigo <0}">
		<input type="submit" value='<spring:message text="Crear Alumno"/>'/>
	</c:if>
</form:form>

</body>
</html>
