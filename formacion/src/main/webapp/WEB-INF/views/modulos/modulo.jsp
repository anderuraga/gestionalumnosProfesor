<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<jsp:include page="../includes/header.jsp" />
<main>
<form:form action="save" commandName="modulo">
	<c:if test="${!empty modulo }">
		<div>
			<form:label path="codModulo">
				<spring:message text="Codigo"/>
			</form:label>
			<form:input path="codModulo" readonly="true" size="10" disabled="true"/>
			<form:hidden path="codModulo"/>
		</div>
		
		<div>
			<form:label path="nombreModulo">
				<spring:message text="Nombre"/>
			</form:label>
			<form:input path="nombreModulo" readonly="true" size="10" disabled="true"/>
		</div>
	
		<div>
			<form:label path="uFormativa">
				<spring:message text="Unidad Formativa"/>
			</form:label>
			<form:input path="uFormativa" readonly="true" size="10" disabled="true"/>
		</div>
		
		<div>
			<form:label path="duracion">
				<spring:message text="Duracion"/>
			</form:label>
			<form:input path="duracion" readonly="true" size="10" disabled="true"/>
		</div>
		<div>
			<c:if test="${modulo.codigo>0}">
                <input type="submit" value="<spring:message text="Editar Modulo"/>" />
            </c:if>
            <c:if test="${modulo.codigo<0}">
                <input type="submit" value="<spring:message text="Crear Modulo"/>" />
            </c:if>
		</div>
	
	
	</c:if>

</form:form>
</main>
<%@ include file="../includes/footer.jsp"%>