<%@page import="com.ipartek.formacion.webservices.AlumnoRestClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cliente Rest Alumnos</title>
<script   src="https://code.jquery.com/jquery-3.1.0.js"   integrity="sha256-slogkvB1K3VOkzAI8QITxV3VzpOnkeNVsKvtkYLMjfk="  
 crossorigin="anonymous">
 </script>
 <script>
$.noConflict();
jQuery(document).ready(function($){
	//aquí todo el código jQuery y no ocasionará conflicto
	//hace llamada AJAX con jQuery
	$.ajax({
		type : "GET",
        contentType : "application/json",
        url : "<%=AlumnoRestClient.REST_ALUMNO_SERVICE_URI+"alumnos"%>",
//         data : JSON.stringify(search),
        dataType : 'json',
        timeout : 100000,
        success : function(data) {
            console.log("SUCCESS: ", data);
            display(data);
        },
        error : function(e) {
            console.log("ERROR: ", e);
            display(e);
        },
        done : function(e) {
            console.log("DONE");
            enableSearchButton(true);
        }
		});
});
</script>
</head>
<body>
<header>

</header>
<main>
</main>
<section id="resultados">

</section>

<footer>
</footer>



</body>
</html>