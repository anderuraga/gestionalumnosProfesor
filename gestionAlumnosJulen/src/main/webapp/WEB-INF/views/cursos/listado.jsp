<%@page import="com.ipartek.formacion.dao.persistence.Curso"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<jsp:include page="../include/header.jsp" />

<c:set var="lista" value="${listaCursos}"/>
<p>
<a href="cursos/addCurso">Crear Curso</a>
</p>
<c:forEach items="${lista}" var="curso">
<div>
<a href="cursos/${curso.codigo}">Codigo - ${curso.codigo} Nombre - ${curso.nombre}</a>
</div>
</c:forEach>

</body>
</html>