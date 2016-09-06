<%@page import="com.ipartek.formacion.dao.persistence.Modulo"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<jsp:include page="../include/header.jsp" />

<c:set var="lista" value="${listaModulos}"/>

<c:forEach items="${lista}" var="modulo">
<p>
<a href="modulos">Codigo - ${modulo.codigo} Nombre - ${modulo.nombre}</a>
</p>
</c:forEach>

</body>
</html>