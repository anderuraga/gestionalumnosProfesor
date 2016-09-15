<%@page import="com.ipartek.formacion.webservices.ModuloRestClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cliente Rest Modulos</title>
<script src="https://code.jquery.com/jquery-3.1.0.js"
	integrity="sha256-slogkvB1K3VOkzAI8QITxV3VzpOnkeNVsKvtkYLMjfk="
	crossorigin="anonymous">
 </script>
 <style>
 #formModulo{
 display:none;
 }
 </style>
<script>
$.noConflict();
jQuery(document).ready(function($){
	$("#listado").on("click","a" , function(){
		console.log("he hecho click");
		
		//recoger el codigo del alumno
		var codigo = $(this).attr("data-id");
		console.log(codigo);
		//llamada a AJAX
		$.ajax({
			type : "GET",
	        contentType : "application/json",
	        url : "<%=ModuloRestClient.REST_SERVICE_URI+"modulos"%>/" + codigo,
	        dataType : 'json',
	        timeout : 100000,
	        success : function(data) {
	            console.log("SUCCESS: ", data);
	            $("#codigo").attr("value",data.codigo);
	            $("#nombre").val(data.nombre);
	            $("#uFormativa").val(data.uformativa);
	            $("#duracion").val(data.duracion);
	           
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
		$("#formModulo").show();
		//ocultar la lista
		$("#listado").hide();
		
	});
	$("button.cancelar").click(function(){
		$("formModulo").hide();
		$("#listado").show();
		return false;
	});
	//aquí todo el código jQuery y no ocasionará conflicto
	//hace llamada AJAX con jQuery
	$.ajax({
		type : "GET",
        contentType : "application/json",
        url : "<%=ModuloRestClient.REST_SERVICE_URI+"modulos"%>",
//         data : JSON.stringify(search),
        dataType : 'json',
        timeout : 100000,
        success : function(data) {
            console.log("SUCCESS: ", data);
            mostrarDatos(data);
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
	function createModulo(){
		//Manipular el DOM. Limpiar formulario, mostrarlo, 
		}
	function mostrarDatos(data){
		var texto = "";
		for(var i = 0; i <data.length; i++){
			var nombre = data[i].nombre;
			var uFormativa = data[i].uFormativa;	
			var duracion = data[i].duracion;		
// 			texto += "<p><a href='#'>" + nombre + " " + apellidos + "</a></p>";
			texto += "<p><a href='#' data-id='" + data[i].codigo +"'>" + nombre + " " + uFormativa + " "+ duracion+ "</a></p>";
		}
		$("#listado").html(texto);
	}
	$("main > a:eq(0)").click(function(){
		$("input").val("");
		$("#formModulo").show();
		$("#listado").hide();
		
		
	});
	function mostrarMensaje(e){
		$("listado").text("No existen modulos en base de datos" + e);
	}
});
</script>
</head>
<body>
	<header> </header>
	<main> <a href="javascript:createModulo()">Crear Modulo</a>

	<article id="resultados">
		
		<section id="listado">
			<header>Listado de modulos desde RestClient</header>
		</section>
		<section id="formModulo">
			<header>Formulario modulos desde RestClient</header>
			<form action="">
				<input type="hidden" name="codigo" id="codigo">
				<input type="text" name="nombre" id="nombre">
				<input type="text" name="uFormativa" id="uFormativa">
				<input type="text" name="duracion" id="duracion">
				<button class="cancelar">Cancelar</button>
				<button class="guardar">Guardar</button>
			
			</form>
		</section>
		
	</article>



	</main>


	<footer> </footer>



</body>
</html>