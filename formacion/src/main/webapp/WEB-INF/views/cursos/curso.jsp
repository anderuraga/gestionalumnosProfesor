<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<jsp:include page="../includes/header.jsp" />
<main>
	<form:form action="save" commandName="curso">
		<c:if test="${!empty curso }">
		
			<div>
				<form:label path="codCurso">
					<spring:message text="Codigo"/>
				</form:label>
				<form:input path="codCurso" readonly="true" size="10" disabled="true"/>
				<form:hidden path="codCurso"/>			
			</div>
				
			<div>
				<form:label path="nombreCurso">
					<spring:message text="Nombre"/>
				</form:label>
				<form:input path="nombreCurso" readonly="true" size="10" disabled="true"/>
				
			</div>

			<div>
				<form:label path="codPatrocinador">
					<spring:message text="Codigo de Patrocinador"/>
				</form:label>
				<form:input path="codPatrocinador" readonly="true" size="10" disabled="true"/>
				
			</div>

			<div>
				<form:label path="tipoCurso">
					<spring:message text="Tipo de Curso"/>
				</form:label>
				<form:input path="tipoCurso" readonly="true" size="10" disabled="true"/>
				
			
			</div>
			
			<div>
				<c:if test="${curso.codCurso>0}">
					<input type="submit" value="<spring:message text="Editar Curso"/>" />
            	</c:if>
           		 <c:if test="${curso.codCurso<0}">
                	<input type="submit" value="<spring:message text="Crear Curso"/>" />
            	 </c:if>
			</div>
		
		
		
		
		
		</c:if>
	
	</form:form>




</main>
<%@ include file="../includes/footer.jsp"%>