<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<jsp:include page="../includes/header.jsp" />
<main>
<form:form action="save" commandName="alumno" >
	<c:if test="${!empty alumno }">
		<div>
			<form:label path="codigo">
				<spring:message text="Codigo: "/>
			</form:label>
			<form:input path="codigo" readonly="true" size="10" disabled="true"/>
			<form:hidden path="codigo"/>
		</div>
		
		<div>
			<form:label path="nombre">
				<spring:message text="Nombre: "/>
			</form:label>
			<form:input path="nombre" readonly="false" size="10" disabled="false" cssErrorClass=""/>
			<form:errors cssClass="" path="nombre"/>
		</div>
		
		<div>
			<form:label path="apellidos">
				<spring:message text="Apellidos: "/>
			</form:label>
			<form:input path="apellidos" readonly="false" size="10" disabled="false" cssErrorClass=""/>
			<form:errors cssClass="" path="apellidos"/>
		</div>
		<div>
			<c:if test="${ alumno.codigo>0}">
                <input type="submit" value="<spring:message text="Editar Alumno"/>" />
            </c:if>
            <c:if test="${ alumno.codigo<0}">
                <input type="submit" value="<spring:message text="Crear Alumno"/>" />
            </c:if>
		</div>
		<div>
			<form:label path="fNacimiento" >
				<spring:message text="Fecha de Nacimiento: "/>
			</form:label>
			<form:input path="fNacimiento" placeHolder="dd/MM/yyyy" />
			<form:errors cssClass="" path="fNacimiento"/>
		</div>
		<div>
			<form:label path="telefono" >
				<spring:message text="Teléfono: "/>
			</form:label>
			<form:input path="telefono"/>
			<form:errors cssClass="" path="telefono"/>
		</div>
	
	</c:if>

</form:form>
</main>
<%@ include file="../includes/footer.jsp"%>