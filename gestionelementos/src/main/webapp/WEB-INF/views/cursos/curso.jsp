<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.ipartek.formacion.dao.persistence.Curso"%>
<%@page import="java.util.List"%>

<jsp:include page="../includes/header.jsp" />


</head>
<body>
	<form:form action="cursos/saveCurso" commandName="curso">
		<c:if test="${!empty curso }">
			<form:label path="codigo">
				<spring:message text="Codigo:" />
			</form:label>
			<form:input path="codigo" readonly="true" size="10" disabled="true" />
			<form:hidden path="codigo" />
		</c:if>
		<div>
			<form:label path="nombre">
				<spring:message text="Nombre:"/>
			</form:label>
			<form:input path="nombre" readonly="false" size="10" disabled="false" />
		</div>
		<div>
			<c:if test="${curso.codigo>0}">
				<input type="submit" value="<spring:message text="Editar Curso"/>" />
			</c:if>
			<c:if test="${curso.codigo<0}">
				<input type="submit" value="<spring:message text="Crear Curso"/>" />
			</c:if>
		</div>
	</form:form>
</body>
</html>