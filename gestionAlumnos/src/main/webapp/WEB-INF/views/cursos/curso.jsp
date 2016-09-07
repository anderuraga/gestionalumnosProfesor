<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
cursooooo

<form:form action="save" method="POST" commandName="curso">
	<c:if test="${curso.codigo>0 }">
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
		<c:if test="${curso.codigo>0 }">
			<input type="submit" value="<spring:message text="Editar curso"/>"/>	
		</c:if>
		<c:if test="${curso.codigo<0 }">
			<input type="submit" value="<spring:message text="Crear curso"/>"/>	
		</c:if>
	</div>
</form:form>

</body>
</html>