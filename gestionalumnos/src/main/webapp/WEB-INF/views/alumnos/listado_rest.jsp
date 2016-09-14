<%@page import="com.ipartek.formacion.webservices.AlumnoRestClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8">
<title>Cliente Rest Alumnos</title>


<script
			  src="https://code.jquery.com/jquery-3.1.0.min.js"
			  integrity="sha256-cCueBR6CsyA4/9szpPfrX3s49M9vUU5BgtiJj06wt/s="
			  crossorigin="anonymous"></script>


<!-- No usar nunca javascript para maquetar, nunca se coloca al final, siempre pegado al body -->

<script>
$.noConflict();
jQuery(document).ready(function($) {
	//Aqui va el codigo jquery y no ocasionara conflictos
	// Hace una llamada AJAX con jQuery
	$.ajax({
        type : "GET",
        contentType : "application/json",
        
        url : "<%=AlumnoRestClient.REST_SERVICE_URI+"alumnos"%>",
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
            //enableSearchButton(true);
        }
    });
});	
</script>
</head>
<body>

<main>
<section>

</section>
</main>
<footer>
</footer>

</body>
</html>