<%@page import="com.ipartek.formacion.service.AlumnoRestClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cliente Rest Alumnos</title>
<script   src="https://code.jquery.com/jquery-3.1.0.min.js"   
	integrity="sha256-cCueBR6CsyA4/9szpPfrX3s49M9vUU5BgtiJj06wt/s="  
	crossorigin="anonymous"></script>
<script>
		$.noConflict();
		jQuery(document).ready(function($){
		//aquí todo el codigo jQuery y no ocasionará conflictos
		//hace llamada AJAX con JQuery
			$.ajax({
				type : "GET",
		        contentType : "application/json",
		        url : "<%=AlumnoRestClient.REST_ALUMNO_SERVICE_URI+"alumnos" %>",
		        //data : JSON.stringify(search),
		        dataType : 'json',
		        timeout : 100000,
		        success : function(data) {
		            console.log("SUCCESS: ", data);
		            //display(data);
		        },
		        error : function(e) {
		            console.log("ERROR: ", e);
		            //display(e);
		        },
		        done : function(e) {
		            console.log("DONE");
		            enableSearchButton(true);
		        }
			})
		})
</script>
</head>
<body>
	<header>
	</header>
	<main>
		<section id="resultados">
		</section>
	</main>
	<footer>
	</footer>
</body>
</html>