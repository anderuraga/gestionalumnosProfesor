
<%@page import="java.util.List"%>
<%@page import="com.ipartek.formacion.dao.persistence.Modulo"%>
<jsp:include page="../includes/header.jsp" />
<main>
<h1>
	Bienvenido a la aplicación de gestión de modulos de Ipartek.
</h1>
<%
	List <Modulo> modulos=(List<Modulo>)request.getAttribute("listado-modulos");

	if(modulos.size()>0){
		for(Modulo m:modulos){
			out.print("<p>"+m.getNombreModulo()+" "+ m.getuFormativa()+"</p>");
		}
		
	}else{
		%>
		No se han encontrado Modulos en la BBDD.
		<%
	}


%>


</main>
<%@ include file="../includes/footer.jsp"%>