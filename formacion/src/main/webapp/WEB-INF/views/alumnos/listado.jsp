
<%@page import="java.util.List"%>
<%@page import="com.ipartek.formacion.dao.persistence.Alumno"%>
<jsp:include page="../includes/header.jsp" />
<main>
<h1>
	Bienvenido a la aplicación de gestión de alumnos de Ipartek.
</h1>
<%
	List <Alumno> alumnos=(List<Alumno>)request.getAttribute("listado-alumnos");

	if(alumnos.size()>0){
		for(Alumno a:alumnos){
			out.print("<p>"+a.getNombre()+" "+ a.getApellidos()+"</p>");
		}
		
	}else{
		%>
		No se han encontrado alumnos en la BBDD.
		<%
	}


%>

</main>
<%@ include file="../includes/footer.jsp"%>