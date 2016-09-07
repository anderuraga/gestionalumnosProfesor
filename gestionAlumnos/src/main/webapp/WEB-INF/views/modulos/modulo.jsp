<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
modulooooo

<form:form action="save" method="POST" commandName="modulo">
	<c:if test="${modulo.codigo>0 }">
		<form:label path="codigo">
			<spring:message text="Código: "/>
		</form:label>
		<form:input path="codigo" readonly="true" size="10" disabled="true"/>
		<form:hidden path="codigo"/>
	</c:if>
	<div>
		<form:label path="nombre">
			<spring:message text="Nombre: "/>
		</form:label>
		<form:input path="nombre"/>
	</div>
	<div>
		
		<c:if test="${modulo.codigo>0 }">
			<input type="submit" value="<spring:message text="Editar modulo"/>"/>	
		</c:if>
		<c:if test="${modulo.codigo<0 }">
			<input type="submit" value="<spring:message text="Crear modulo"/>"/>	
		</c:if>
	</div>
</form:form>
</body>
</html>