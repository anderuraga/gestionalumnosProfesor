<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
           
  <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html ">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    





<form:form action="save" commandName="curso" method="POST">
	<c:if test="${!empty curso }">
		<form:label path="codigo">
			<spring:message text="Codigo"/>
		</form:label>
		<form:input path="codigo" readonly="true" disabled="true"/>
		<form:hidden path="codigo"/>
	</c:if>
	<form:label path="nombre">
		<spring:message text="Nombre:"> </spring:message>
	</form:label>
	<form:input path="nombre"/>
	<form:errors path="nombre"/>
	
		<c:if test="${ curso.codigo>0 }">
		
			<input type="submit" value="<spring:message text='Editar Curso'/>"/>
		</c:if>
		<c:if test="${curso.codigo<0 }">
		
			<input type="submit" value="<spring:message text='Crear Curso'/>"/>
		</c:if>
</form:form>

</body>
</html>
</body>
</html>