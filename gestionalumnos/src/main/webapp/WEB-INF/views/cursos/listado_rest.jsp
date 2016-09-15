<%@page import="com.ipartek.formacion.webservices.CursoRestClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cliente Rest Cursos</title>
<script src="https://code.jquery.com/jquery-3.1.0.js"
	integrity="sha256-slogkvB1K3VOkzAI8QITxV3VzpOnkeNVsKvtkYLMjfk="
	crossorigin="anonymous">
 </script>
 <style>
 #formCurso{
 display:none;
 }
 </style>
<script>
$.noConflict();
jQuery(document).ready(function($){
	cargarDatos();
	function mostrarDatos(data){
		var texto = "";
		for(var i = 0; i <data.length; i++){
			var nombre = data[i].nombre;
			var codPatrocinador = data[i].codPatrocinador;	
			var codTipoCurso = data[i].codTipoCurso;		
// 			texto += "<p><a href='#'>" + nombre + " " + apellidos + "</a></p>";
			texto += "<p><a href='#' data-id='" + data[i].codigo +"'>" + nombre + " " + codPatrocinador + " "+ codTipoCurso+ "</a></p>";
		}
		$("#listado").html(texto);
	}
	function mostrarMensaje(e){
		$("listado").text("No existen cursos en base de datos" + e);
	}
	$("#listado").on("click","a", function(){
		console.log("he hecho click");
		
		//recoger el codigo del alumno
		var codigo = $(this).attr("data-id");
		console.log(codigo);
		//llamada a AJAX
		var url = "<%=CursoRestClient.REST_SERVICE_URI+"cursos/"%>"+parseInt(codigo, 10);
		$.ajax({
			type : "GET",
	        contentType : "application/json",
	        url : url,
	        dataType : 'json',
	        timeout : 100000,
	        success : function(data) {
	            console.log("SUCCESS: ", data);
	            $("#codigo").val(data.codigo);
	            $("#nombre").val(data.nombre);
	            $("#codPatrocinador").val(data.codPatrocinador);
	            $("#codTipoCurso").val(data.codTipoCurso);
	           
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
		$("#formCurso").show();
		//ocultar la lista
		$("#listado").hide();
		
	});
	$("main > a").click(function(){
		$("input").val("");
		$("#formCurso").show();
		$("#listado").hide();	
	});
	$("button.cancelar").click(function(){
		$("formCurso").hide();
		$("#listado").show();
		return false;
	});
	$("button.guardar").click(function(){
		//recoger los datos
		var curso = {};
		curso['codigo'] = $("#codigo").val();
		curso['nombre'] = $("#nombre").val();
		curso['codPatrocinador'] = $("#codPatrocinador").val();
		curso['codTipoCurso'] = $("#codTipoCurso").val();
		console.log(JSON.stringify(curso));
		// update o insert (codigo), en nuestro caso no haremos nada
		if(curso['codigo']!=""){ //update
			$.ajax({
				type: "PUT",
		        contentType : "application/json",
		        data: JSON.stringify(curso),
		        url: "<%=CursoRestClient.REST_SERVICE_URI+"cursos"%>/"+parseInt(curso['codigo'], 10),
		        dataType : 'json',
		        timeout : 100000,
		        success : function(data) {
		          //  console.log("SUCCESS: ", data);

		            alert("El curso ha sido actualizado correctamente");
		            cargarDatos();
		        },
		        error : function(e) {
		            console.log("ERROR: ", e);	           
		        },
		        done : function(e) {
		            console.log("DONE");	           
		        }
			});
		}else{//insert
			$.ajax({
				type : "POST",
		        contentType : "application/json",
		        url : "<%=CursoRestClient.REST_SERVICE_URI+"cursos"%>",
		        dataType : 'json',
		        data : JSON.stringify(curso),
		        timeout : 100000,
		        success : function(data) {
		            console.log("SUCCESS: ", data);
		            alert("El curso ha sido creado correctamente");       
		        },
		        error : function(e) {
		            console.log("ERROR: ", e);		           
		        },
		        done : function(e) {
		            console.log("DONE");  
		        }
			});
		}	
		$("#formCurso").hide();
		$("#listado").show();
		return false;
	});
	//aquí todo el código jQuery y no ocasionará conflicto
	//hace llamada AJAX con jQuery
	function cargarDatos(){
		$.ajax({
			type : "GET",
	        contentType : "application/json",
	        url : "<%=CursoRestClient.REST_SERVICE_URI+"cursos"%>",
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
	}
});
</script>
</head>
<body>
	<header> </header>
	<main> <a href="javascript:createCurso()">Crear curso</a>

	<article id="resultados">
		
		<section id="listado">
			<header>Listado de cursos desde RestClient</header>
		</section>
		<section id="formCurso">
			<header>Formulario cursos desde RestClient</header>
			<form action="#" method="post">
				<input type="hidden" name="codigo" id="codigo">
				<input type="text" name="nombre" id="nombre">
				<input type="text" name="codPatrocinador" id="codPatrocinador">
				<input type="text" name="codTipoCurso" id="codTipoCurso">
				<button class="cancelar">Cancelar</button>
				<button class="guardar">Guardar</button>
			
			</form>
		</section>
		
	</article>



	</main>


	<footer> </footer>



</body>
</html>