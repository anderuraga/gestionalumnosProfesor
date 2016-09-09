<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alumno</title>
</head>
<body>
alumnooooo

<form:form action="save" method="POST" commandName="alumno">
	<c:if test="${alumno.codigo>0 }">
		<form:label path="codigo">
			<spring:message code="alumno.codigo "/>
		</form:label>
		<form:input path="codigo" readonly="true" size="10" disabled="true"/>
		<form:hidden path="codigo"/>
	</c:if>
	<div>
		<form:label path="nombre">
			<spring:message text="Nombre: "/>
		</form:label>
		<form:input path="nombre" cssErrorClass=""/>
		<form:errors cssClass="" path="nombre"/>
	</div>
	<div>
		<form:label path="apellidos">
			<spring:message text="Apellidos: "/>
		</form:label>
		<form:input path="apellidos" cssErrorClass=""/>
		<form:errors cssClass="" path="apellidos"/>
	</div>
	<div>
		<form:label path="fNacimiento" cssClass="sr-only">
			<spring:message text="Fecha de Nacimiento:" />
		</form:label>
		<form:input path="fNacimiento" placeholder="dd/MM/yyyy"/>
		<form:errors cssClass=""/>
	</div>
	<div>
		<form:label path="dni">
			<spring:message text="DNI: "/>
		</form:label>
		<form:input path="dni" cssErrorClass=""/>
		<form:errors cssClass="" path="dni"/>
	</div>
	<div>
		<form:label path="telefono">
			<spring:message text="Teléfono: "/>
		</form:label>
		<form:input path="telefono" cssErrorClass=""/>
		<form:errors cssClass="" path="telefono"/>
	</div>
	<div>
		<form:label path="email">
			<spring:message text="Email: "/>
		</form:label>
		<form:input path="email" cssErrorClass=""/>
		<form:errors cssClass="" path="email"/>
	</div>
	<div>
		<form:label path="codGenero">
			<spring:message text="Código género: "/>
		</form:label>
		<form:input path="codGenero" cssErrorClass=""/>
		<form:errors cssClass="" path="codGenero"/>
	</div>
	<div>
		<c:if test="${alumno.codigo>0 }">
			<input type="submit" value="<spring:message text="Editar alumno"/>"/>	
		</c:if>
		<c:if test="${alumno.codigo<0 }">
			<input type="submit" value="<spring:message text="Crear alumno"/>"/>	
		</c:if>
	</div>
</form:form>

<!-- 
<form id="formulario" action="" method="post">
    <fieldset>
        <legend>Formulario</legend>
            <label value="${alumno.nombre }">Nombre: </label>
                <input id="nombre" name="nombre" type="text" />
            <label value="${alumno.apellidos }">Apellidos: </label>
                <input id="apellidos" name="apellidos" type="text" />
            <input id="campo3" name="enviar" type="submit" value="Enviar" />
    </fieldset>
</form>
 -->
</body>
</html>