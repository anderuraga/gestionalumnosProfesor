<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html >
<html>

<body>
<h1>Alumno</h1>


<form:form action="save" commandName="alumno" method="POST">
	<c:if test="${!empty alumno }">
		<form:label path="codigo">
			<spring:message text="Codigo"/>
		</form:label>
		<form:input path="codigo" readonly="true" disabled="true" />
		<form:hidden path="codigo"/>
	</c:if>
	<form:label path="nombre">
		<spring:message text="Nombre:"> </spring:message>
	</form:label>
	<form:input path="nombre" cssErrorClass=""/>
	<form:errors path="nombre" cssClass=""/> 
	<form:label path="apellidos">
		<spring:message text="Apellidos:"> </spring:message>
	</form:label>
	<form:input path="apellidos" />
	<form:errors  path="apellidos"/>
	<form:label path="fNacimiento">
		<spring:message text="Fecha de Nacimiento"> </spring:message>
	</form:label>
	<form:input path="fNacimiento" placeholder="dd/MM/yyyy"/>
	<form:errors cssClass="" path="fNacimiento"/>
	<form:label path="dni">
		<spring:message text="Dni:"> </spring:message>
	</form:label>
	<form:input path="dni" />
	<form:errors cssClass="" path="dni"/>
		
		<c:if test="${ alumno.codigo>0 }">
		
			<input type="submit" value="<spring:message text='Editar Alumno'/>"/>
		</c:if>
		<c:if test="${alumno.codigo<0 }">
		
			<input type="submit" value="<spring:message text='Crear Alumno'/>"/>
		</c:if>
</form:form>

</body>
</html>