<%@page import="com.ipartek.formacion.webService.AlumnoRestClient"%>
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
<style>
	#formAlumno{
		display:none;
	}
	
</style>
<script>
$.noConflict();
jQuery(document).ready(function($) {
	//Aqui va el codigo jquery y no ocasionara conflictos
	// Hace una llamada AJAX con jQuery
	$("#listado").on( "click","a", function(){
		console.log("Acabo de hacer click para editar el alumno");
		// recoger los datos del alumno
		var codigo = $(this).attr("data-id");
		console.log(codigo);
		//llamada AJAX
		var url = '<%=AlumnoRestClient.REST_SERVICE_URI+"alumnos"%>/'+codigo;
		$.ajax({
            type : "GET",
            contentType : "application/json",       
            url : url,
            //data : JSON.stringify(search),
            dataType : 'json',
            timeout : 100000,
            success : function(data) {
                console.log("SUCCESS: ", data);
                $("#codigo").Attr("value", data.codigo);
                $("#nombre").val(data.nombre);
                $("#apellidos").val(data.apellidos);
            },
            error : function(e) {
                console.log("ERROR: ", e);
            },
            done : function(e) {
                console.log("DONE");
            }
        });
		// Mostrar datos en el form
		
		//manipular el DOM
		//Mostrar formulario y ocultar la lista
		$("#formAlumno").show();
		$("#listado").hide();
	});
	$("button:cancelar").click(function(){
		//ocultar el formulario
		$("#formAlumno").hide();
		//mostrar la lista
		$("#listado").show();
		return false;
	})
	$.ajax({
        type : "GET",
        contentType : "application/json",        
        url : "<%=AlumnoRestClient.REST_SERVICE_URI+"alumnos"%>",
        //data : JSON.stringify(search),
        dataType : 'json',
        timeout : 100000,
        success : function(data) {
            console.log("SUCCESS: ", data);
            mostrarDatos(data);
        },
        error : function(e) {
            console.log("ERROR: ", e);
            nostrarMensaje(e);
        },
        done : function(e) {
            console.log("DONE");
            //enableSearchButton(true);
        }
    });
    function mostrarDatos(data){
    	var texto = '';
        for(var i=0; i < data.length; i++){
            var nombre = data[i].nombre;
            var apellidos = data[i].apellidos;
            
            //texto += "<p><a href='javascript:getByID("+data[i].codigo+")'>"+nombre+" "+apellidos+"</a></p>";
            texto += "<p><a href='#' data-id='"+data[i].codigo+"'>"+nombre+" "+apellidos+"</a></p>";
        }
        $("#listado").html(texto);
    }
    function mostrarMensaje(e){
    	$("#listado").Text("No existen alumnos en la base de datos" + e);
    }
    function createAlumno(){
		// manipular el dom, limpiar formulario, ocultar la lista
		$.ajax({
            type : "POST",
            contentType : "application/json",         
            url : "<%=AlumnoRestClient.REST_SERVICE_URI+"alumnos"%>",
            //data : JSON.stringify(search),
            dataType : 'json',
            timeout : 100000,
            success : function(data) {
                console.log("SUCCESS: ", data);
                mostrarDatos(data);
            },
            error : function(e) {
                console.log("ERROR: ", e);
                nostrarMensaje(e);
            },
            done : function(e) {
                console.log("DONE");
                //enableSearchButton(true);
            }
        });
		// procesar la información recibida
		// manipular el DOM, ocultar la lista y mostrar la nueva informacion. el dom es todo el codigo HTML
    
    }
    function getByID(codigo){
		// lanzará una peticion AJAX
		$.ajax({
            type : "GET",
            contentType : "application/json",       
            url : "<%=AlumnoRestClient.REST_SERVICE_URI+"alumnos"%>/codigo",
            //data : JSON.stringify(search),
            dataType : 'json',
            timeout : 100000,
            success : function(data) {
                console.log("SUCCESS: ", data);
                //los del alumno como value en el formulario
            },
            error : function(e) {
                console.log("ERROR: ", e);
            },
            done : function(e) {
                console.log("DONE");
            }
        });
		// procesar la información recibida
		// manipular el DOM, ocultar la lista y mostrar la nueva informacion. el dom es todo el codigo HTML
    }
});	
</script>
</head>
<body>
<header>Alumnos</header>
<main>
<a href="javascript:createAlumno()">Crear Alumno</a>
<article id="resultados">
	<section id="listado">
		<header>Listado de alumnos</header>
	</section>
	<section id="formAlumno">
		<header>Formulario de alumnos</header>
		<form method="post" action="#">
			Codigo:<input type="hidden" name="codigo" id="codigo"/>
			Nombre:<input type="text" name="nombre" id="nombre"/>
			Apellidos:<input type="text"  name="apellidos" id="apellidos"/>
			<button class="cancelar">Cancelar<button>
			<button class="guardar">Guardar<button>
		</form>
	</section>	
</article>
</main>
<footer>
</footer>

</body>
</html>