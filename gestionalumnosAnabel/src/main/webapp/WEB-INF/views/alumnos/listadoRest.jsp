<%@page import="com.ipartek.formacion.webService.AlumnoRestClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8">
<title>Cliente Rest Alumnos</title>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"
	integrity="sha256-cCueBR6CsyA4/9szpPfrX3s49M9vUU5BgtiJj06wt/s="
	crossorigin="anonymous"></script>
<!-- No usar nunca javascript para maquetar, nunca se coloca al final, siempre en el head -->
<script>
$.noConflict();
jQuery(document).ready(function($) {
	//Aqui va el codigo jquery y no ocasionara conflictos
	// Hace una llamada AJAX con jQuery
	$.ajax({
        type : "GET",
        contentType : "application/json",
        
        url : "<%=AlumnoRestClient.REST_SERVICE_URI + "alumnos"%>",
			//data : JSON.stringify(search),
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);
				mostrarDatos(data)
				//display(data);
			},
			error : function(e) {
				console.log("ERROR: ", e);
				mostrarMensaje(e);
			},
			done : function(e) {
				console.log("DONE");
				//enableSearchButton(true);
			}
		});
	});
	function mostrarDatos(data) {
		for (var i = 0; i < data.lenght; i++) {
			var nombre = data[i].nombre; //tambien se puede hacer nombre = data[i][nombre]
			var apellidos = data[i].apellidos;
			var telefono = data[i].telefono;
			var email = data[i].email;
			var fNAcimiento = data[i].fNacimiento;
			var texto += "<p><a href='#'>"+nombre +" "+apellidos+"</p>";
		}
		$("#listado").text(texto);
	}
	function mostrarMensaje(e){
		$("#listado").text("No existen alumnos en la BB.DD.");		
	}
</script>
</head>
<body>

	<main> <section> </section> </main>
	<footer> </footer>

</body>
</html>
<header></header>
<main> 
	<section id="resultado"/> 
		<header>Resultados</header> 
		<div>
		
		</div>
</main>
<footer></footer>

</body>
</html>