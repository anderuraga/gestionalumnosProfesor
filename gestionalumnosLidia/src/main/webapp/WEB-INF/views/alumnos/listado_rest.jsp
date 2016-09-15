<%@page import="com.ipartek.formacion.webservices.AlumnoRestClient"%>
<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset= "UTF-8">
<title>Cliente Rest Alumno</title>
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script>
$.noConflict();
jQuery( document ).ready(function( $ ) {
	//aquí todo el código jq para que no ocasione conflictos
	//llamada AJAX con JQ
	$.ajax({
        type : "GET",
        contentType : "application/json",
        url : "<%=AlumnoRestClient.REST_SERVICE_URI+"/alumnos"%>",
        //data : JSON.stringify(search), no se manda datos, para el CREATE por ejem si se usa
        dataType : 'json',
        timeout : 100000,
        success : function(data) {
            console.log("SUCCESS: ", data);
            mostrarDatos(data);
            //display(data);
            //pasandole todos los datos 
        },
        error : function(e) {
            console.log("ERROR: ", e);
            //display(e);
            mostrarMensaje(e);
        },
        done : function(e) {
            console.log("DONE");
            //enableSearchButton(true);
        }
    });
    function getById(codigo){
        //petición AJAX
        //procesar la llamada
        //manipular el DOM
    }
    function createAlumno(){
        //manipular el DOM, limpiar el formulario,mostrarlo, ocultar la vista 
    }
    function mostrarDatos(data){
    	 var texto= '';
        for	(var i=0; i<data.length;i++){
            var nombre=data[i].nombre;  /*data[i][nombre]*/
            var apellidos=data[i].apellidos;
           
            texto+="<p><a href='javascript:getById("+data[i].codigo")'>"+nombre +" "+apellidos+"</a></p>";
           
        }
        $("#listado").html(texto);
        
    }
});
</script>
</head>
<body>
<header>Alumnos</header>
<main>
    <a href="javascript:createAlumno()">Crear Alumno</a>
	<section id="alumnos">
		<header>Listado Completo de Alumnos</header>
		<div id="listado">
		</div>
	</section>
</main>
<footer></footer>
</body>
</html>