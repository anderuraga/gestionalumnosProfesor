<%@page import="com.ipartek.formacion.webservices.AlumnoRestClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cliente Rest Alumnos</title>
<script src="https://code.jquery.com/jquery-3.1.0.js"
	integrity="sha256-slogkvB1K3VOkzAI8QITxV3VzpOnkeNVsKvtkYLMjfk="
	crossorigin="anonymous">
 </script>
 <style>
 #formAlumno{
 display:none;
 }
 </style>
<script>
$.noConflict();
jQuery(document).ready(function($){
	cargarDatos();
	function cargarDatos(){
	$.ajax({
		type : "GET",
        contentType : "application/json",
        url : "<%=AlumnoRestClient.REST_ALUMNO_SERVICE_URI+"alumnos"%>",
//         data : JSON.stringify(search),
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
	}
	$("#listado").on("click","a" , function(){
		console.log("he hecho click");
		
		//recoger el codigo del alumno
		var codigo = $(this).attr("data-id");
		console.log(codigo);
		//llamada a AJAX
		$.ajax({
			type : "GET",
	        contentType : "application/json",
	        url : "<%=AlumnoRestClient.REST_ALUMNO_SERVICE_URI+"alumnos"%>/" + codigo,
	        dataType : 'json',
	        timeout : 100000,
	        success : function(data) {
	            console.log("SUCCESS: ", data);
	            //datos del alumno como value en el formulario
	            $("#codigo").val(data.codigo);
	            $("#nombre").val(data.nombre);
	            $("#apellidos").attr("value",data.apellidos);
	            $("#dni").val(data.dni);
	            $("#fNacimiento").val(data.fNacimiento);
	           
	        },
	        error : function(e) {
	            console.log("ERROR: ", e);
	           
	        },
	        done : function(e) {
	            console.log("DONE");
	           
	        }
			});
		//poner los datos
		
		//mostrar el formulario
		$("#formAlumno").show();
		//ocultar la lista
		$("#listado").hide();
	});
	$("button.cancelar").click(function(){
		//ocultar el formulario
		$("#formAlumno").hide();
// 		mostrar la lista
		$("#listado").show();
			return false;

		});

	$("button.guardar").click(function(){
		//recoger datos del formulario
		var alumno = new Array();
		alumno["codigo"] = $("#codigo").val();
		alumno["nombre"] = $("#nombre").val();
		alumno["apellidos"] = $("#apellidos").val();
		alumno["dni"] = $("#dni").val();
		alumno["fNacimiento"] = $("#fNacimiento").val();
		//update o insert(codigo)
		if(alumno['codigo'] > 0 || alumno['codigo'] != ""){
		//UPDATE
			$.ajax({
				type : "PUT",
		        contentType : "application/json",
		        url : "<%=AlumnoRestClient.REST_ALUMNO_SERVICE_URI+"alumnos"%>/" + alumno.codigo,
		        data : JSON.stringify(alumno),
		        dataType : 'json',
		        timeout : 100000,
		        success : function(data) {
		            console.log("SUCCESS: ", data);
		            alert("El alumno ha sido actualizado correctamente");
		        },
		        error : function(e) {
		            console.log("ERROR: ", e);
		           
		        },
		        done : function(e) {
		            console.log("DONE");
		           
		        }
				});
			
		}else{
			//INSERT
			$.ajax({
				type : "POST",
		        contentType : "application/json",
		        url : "<%=AlumnoRestClient.REST_ALUMNO_SERVICE_URI+"alumnos"%>/",
		        data : JSON.stringify(alumno),
		        dataType : 'json',
		        timeout : 100000,
		        success : function(data) {
		            console.log("SUCCESS: ", data);
		            alert("El alumno ha sido creado correctamente");
		        },
		        error : function(e) {
		            console.log("ERROR: ", e);
		           
		        },
		        done : function(e) {
		            console.log("DONE");		           
		        }
				});
			}
		cargarDatos();
		
			return false;

		});
	
	//aquí todo el código jQuery y no ocasionará conflicto
	//hace llamada AJAX con jQuery
	
	$("main > a").click(function(){
		//Manipular el DOM. Limpiar formulario, mostrarlo, ocultar lista de alumnos
		$("input").val("");
		$("#listado").hide();
		$("#formAlumno").show();			
		});
	
	function mostrarDatos(data){
		var texto = "";
		for(var i = 0; i <data.length; i++){
			var nombre = data[i].nombre;
			var apellidos = data[i].apellidos;	
			var dni = data[i].dni;	
			var fNacimiento = data[i].fNacimiento;			
			texto += "<p><a href='#' data-id='" + data[i].codigo +"'>" + nombre + " " + apellidos
			+ dni + fNacimiento + "</a></p>";
		}
		$("#listado").html(texto);
	}
	function mostrarMensaje(e){
		$("listado").text("No existen alumnos en base de datos" + e);
	}
});
</script>
</head>
<body>
	<header> </header>
	<main> <a href="#">Crear Alumno</a>

	<article id="resultados">
		
		<section id="listado">
			<header>Listado de alumnos desde RestClient</header>
		</section>
		<section id="formAlumno">
			<header>Formulario alumnos desde RestClient</header>
			<form action="#" method="post">
				<input type="hidden" name="codigo" id="codigo"/>
				<input type="text" name="nombre" id="nombre"/>
				<input type="text" name="apellidos" id="apellidos"/>
				<input type="text" name="dni" id="dni"/>
				<input type="text" name="fNacimiento" id="fNacimiento"/>
				
				<button class="cancelar">Cancelar</button>
				<button class="guardar">Guardar</button>
			
			</form>
		</section>
		
	</article>



	</main>


	<footer> </footer>



</body>
</html>