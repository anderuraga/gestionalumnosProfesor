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
<style>
	#formAlumno{
		display: none
	}
</style>
<script>
$.noConflict();
jQuery(document).ready(function($) {

	//en el primer parentesis metemos el css al que se van a aplicar las funciones que referenciemos cuando le demos al boton.
	$("#listado").on("click","a",function(){
		console.log("He hecho click");
		//Recoger el codigo del alumno
		var codigo = this.attr("data-id"); //el this hace referencia a el nombre que hemos clickado.
		codigo.log(codigo);
		//Llamada a AJAX
		var url = '<%=AlumnoRestClient.REST_SERVICE_URI + "alumnos/"%>'+codigo;
		$.ajax({
			type : "GET",
	        contentType : "application/json",
	        
	        url : url,
						//data : JSON.stringify(search),
						dataType : 'json',
						timeout : 100000,
						success : function(data) {
							console.log("SUCCESS: ", data);
							//display(data);
						},
						error : function(e) {
							console.log("ERROR: ", e);
						},
						done : function(e) {
							console.log("DONE");
							//enableSearchButton(true);
						}
					});
		})
		//Poner los datos en el formulario
		
		//Mostrar el formulario
		
		//manipular el dom
		//mostrar el formulario
		$("#formAlumno").show();
		//ocultar la lista
		$('#listado').hide();
		
	});
	
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
						mostrarDatos(data);
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

				function getById(codigo) {

					//COMO RECOMENDACION NO PONER ALERT, PONER CONSOLE.LOG, CONSOLE.ERROR...
					//Realizara una petición AJAX
					//procesara la llamada
					//manipular el DOM

				}
				function createAlumno() {

					//manipular el DOM --> limpiar el formulario, mostrarlo, ocultar la lista de alumnos
					//Va a ser el boton de guardar el que haga la llamada AJAX
				}
				function mostrarDatos(data) {
					var texto = '';
					for (var i = 0; i < data.length; i++) {
						var nombre = data[i].nombre; //tambien se puede hacer nombre = data[i][nombre]
						var apellidos = data[i].apellidos;

						texto += "<p><a href='#'>" + nombre + " " + apellidos
								+ "</a></p>";
					}
					$("#listado").html(texto);
				}
				function mostrarMensaje(e) {
					$("#listado").text("No existen alumnos en la BB.DD." + e);
				}
				
			});
</script>
</head>
<body>

	<header>Alumnos</header>
	<main> 
		<a href="javascript:createAlumno">Crear Alumno</a> 
		<article id="resultado" />
		<section id="listado"> 
			<header>Listado completo de Alumnos</header> 
		</section>
		<div id="listado"></div>
	<div id="formAlumno" class="row">
		<form class="form-horizontal" action="">
			<div class="form-group">
				<div class="col-xs-12">
					<label class="col-xs-4">Nombre:</label> <input class="col-xs-8"
						name="nombre" type="text" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-xs-12">
					<label class="col-xs-4">Apellidos:</label> <input class="col-xs-8"
						name="apellidos" type="text" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-xs-12">
					<label class="col-xs-4">Fecha de Nacimiento:</label> <input
						class="col-xs-8" name="fNacimiento" type="text" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-xs-12">
					<label class="col-xs-4">Email:</label> <input class="col-lg-8"
						name="email" type="text" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-xs-12">
					<label class="col-xs-4">Telefono:</label> <input class="col-xs-8"
						name="telefono" type="text" />
				</div>
			</div>
			<div class="form-group">
				<button class="col-xs-4 btn btn-success">Guardar</button>
				<button class="col-xs-4 btn btn-danger">Cancelar</button>
			</div>

		</form>
	</div>

	</main>
	<footer></footer>
</body>
</html>