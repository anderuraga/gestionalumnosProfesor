<%@page import="com.ipartek.formacion.webservices.AlumnoRestClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cliente Rest Alumnos</title>

<script src="http://code.jquery.com/jquery-3.1.0.min.js"
	integrity="sha256-cCueBR6CsyA4/9szpPfrX3s49M9vUU5BgtiJj06wt/s="
	crossorigin="anonymous">
        </script>

<script>
            $.noConflict();
            jQuery(document).ready(function($){
                // Aqui todo el codigo jQuery y no ocasionara conflictos
                $.ajax({
                    type : "GET",
                    contentType : "application/json",
                    url : "<%=AlumnoRestClient.REST_SERVICE_URI + "alumnos/"%>",
			//data : JSON.stringify(search),
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);
				//display(data);
				mostrarDatos(data);
			},
			error : function(e) {
				console.log("ERROR: ", e);
				mostrarMensaje(e);
			//	display(e);
			},
			done : function(e) {
				console.log("DONE");
			//	enableSearchButton(true);
			}
		});
	});
            function mostrarDatos(data) {
        		var texto = '';

        		for (var i = 0; i < data.length; i++) {

        			var nombre = data[i].nombre;
        			var apellidos = data[i].apellidos;
        			texto += "<p><a href='#'>" + nombre + " " + apellidos+"</p>";
        		}
        		$("#listado").text(texto);
        	}
            function mostrarMensaje(e) {
            	$("#listado").text("No existen alumnos en la base de datos. "+e);
        		
        	}
</script>
</head>

<body>


</body>


<main>
<section id="resultados"></section>
<heade>Resultados</heade>
<div id="listado">
</div>
</main>

<footer> </footer>

</html>