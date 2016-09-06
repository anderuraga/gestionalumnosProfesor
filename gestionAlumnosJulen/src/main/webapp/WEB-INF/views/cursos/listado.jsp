<%@page import="com.ipartek.formacion.dao.persistence.Curso"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<jsp:include page="../include/header.jsp" />

<c:set var="lista" value="${listaCursos}"/>

<c:forEach items="${lista}" var="curso">
<p>
<a href="cursos/${curso.codigo}">Codigo - ${curso.codigo} Nombre - ${curso.nombre}</a>
</p>
</c:forEach>

</body>
</html>