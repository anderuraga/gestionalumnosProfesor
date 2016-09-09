<%@page import="com.ipartek.formacion.dao.persistence.Modulo"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<jsp:include page="../include/header.jsp" />

<!-- librerias para tags de spring -->
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:form action="save" commandName="modulo" >
	<c:if test="${modulo.codigo>0}">
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
	<c:if test="${modulo.codigo >0}">
		<input type="submit" value='<spring:message text="Editar Modulo"/>'/>
	</c:if>
	<c:if test="${modulo.codigo <0}">
		<input type="submit" value='<spring:message text="Crear Modulo"/>'/>
	</c:if>
</form:form>


</body>
</html>