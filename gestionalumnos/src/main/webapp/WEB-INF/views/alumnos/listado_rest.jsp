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
	$("#listado").on("click","a",function(){

        console.log("He alumno para editarlo");
        //recoger el codigo del alumno
        var codigo = $(this).attr("data-id");
        console.log(codigo);
        //llamada a AJAX
        $.ajax({
            type : "GET",
            contentType : "application/json",
            url : "http://localhost:8080/formacion/restful/alumnos/"+parseInt(codigo, 10),
            dataType : 'json',
            timeout : 100000,
            success : function(data) {
                console.log("SUCCESS: ", data);
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
	//aquí todo el código jQuery y no ocasionará conflicto
	//hace llamada AJAX con jQuery
	$.ajax({
		type : "GET",
        contentType : "application/json",
        url : "<%=AlumnoRestClient.REST_SERVICE_URI+"alumnos"%>",
//         data : JSON.stringify(search),
        dataType : 'json',
        timeout : 100000,
        success : function(data) {
            console.log("SUCCESS: ", data);
            $("#codigo").attr("value",data.codigo);
            $("#nombre").val(data.nombre);
            $("#apellidos").val(data.apellidos);
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
	function getById(codigo){
		//petición AJAX
		//procesar llamamada AJAX
		//manipular el DOM (ocultar la lista y mostrar el formulario)
		}
	function createAlumno(){
		//Manipular el DOM. Limpiar formulario, mostrarlo, 
		}
	function mostrarDatos(data){
		var texto = "";
		for(var i = 0; i <data.length; i++){
			var nombre = data[i].nombre;
			var apellidos = data[i].apellidos;			
// 			texto += "<p><a href='#'>" + nombre + " " + apellidos + "</a></p>";
			texto += "<p><a href='#' data-id='" + data[i].codigo +"'>" + nombre + " " + apellidos + "</a></p>";
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
	<main> <a href="javascript:createAlumno()">Crear Alumno</a>

	<article id="resultados">
		
		<section id="listado">
			<header>Listado de alumnos desde RestClient</header>
		</section>
		<section id="formAlumno">
			<header>Formulario alumnos desde RestClient</header>
			<form method="post" action="#">
				<input type="hidden" name="codigo" id="codigo">
				<input type="text" name="nombre" id="nombre" >
				<input type="text" name="apellidos" id="apellidos">
				<button class="cancelar">Cancelar</button>
				<button class="guardar">Guardar</button>
			
			</form>
		</section>
		
	</article>



	</main>


	<footer> </footer>



</body>
</html>