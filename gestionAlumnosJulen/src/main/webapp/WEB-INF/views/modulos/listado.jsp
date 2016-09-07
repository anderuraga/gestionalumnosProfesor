<%@page import="com.ipartek.formacion.dao.persistence.Modulo"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<jsp:include page="../include/header.jsp" />

<c:set var="lista" value="${listaModulos}"/>
<p>
<a href="modulos/addModulo">Crear Modulo</a>
</p>
<c:forEach items="${lista}" var="modulo">
<div>
<a href="modulos/${modulo.codigo}">Codigo - ${modulo.codigo} Nombre - ${modulo.nombre}</a>
</div>
</c:forEach>

</body>
</html>