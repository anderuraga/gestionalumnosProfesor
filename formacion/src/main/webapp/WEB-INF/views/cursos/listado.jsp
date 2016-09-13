
<%@page import="java.util.List"%>
<%@page import="com.ipartek.formacion.dao.persistence.Curso"%>
<jsp:include page="../includes/header.jsp" />
<main>
<h1>
	Bienvenido a la aplicación de gestión de cursos de Ipartek.
</h1>
<%
	List <Curso> cursos=(List<Curso>)request.getAttribute("listado-cursos");

	if(cursos.size()>0){
		for(Curso c:cursos){
			out.print("<p>"+c.getNombreCurso()+" "+ c.getCodPatrocinador()+"</p>");
		}
		
	}else{
		%>
		No se han encontrado cursos en la BBDD.
		<%
	}


%>


</main>
<%@ include file="../includes/footer.jsp"%>