<jsp:include page="../include/header.jsp"/>
<%@taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri= "http://java.sun.com/jsp/jstl/fmt" %>

<h1>Lista Empleados</h1>

<c:set var="lista" value="${lista_empleados}"/>

<c:forEach items="${lista}" var="empleado">

<form action="${properties.servletEmpleado}" method="POST">
	<input type="hidden" id="${properties.parCodigo}" name="${properties.parCodigo}" value="${empleado.codigo}" />
	<input type="text" id="${properties.parNombre}" name="${properties.parNombre}" value="${empleado.nombre}" />
	<input type="text" id="${properties.parApellidos}" name="${properties.parApellidos}" value="${empleado.apellidos}" />
	<input class="btn btn-succes" type="submit" value="Mostrar mas"/>
</form>

</c:forEach>
</body>
</html>