<%@page import="com.ipartek.formacion.webservices.AlumnoRestClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script src="http://code.jquery.com/jquery-3.1.0.min.js"
	integrity="sha256-cCueBR6CsyA4/9szpPfrX3s49M9vUU5BgtiJj06wt/s="
	crossorigin="anonymous">
        </script>
<style>
#formAlumno {
	display: none;
}
</style>
<script>
            $.noConflict();
			jQuery(document).ready(function($){
                
				$("#listado").on("click","a",function(){	// Abrimos A

                    console.log("He alumno para editarlo");
                    //recoger el codigo del alumno
                    var codigo = $(this).attr("data-id");
                    console.log(codigo);
                    //llamada a AJAX
                    var url ='<%=AlumnoRestClient.REST_SERVICE_URI+"alumnos/"%>'+codigo;

					$.ajax({	// Abrimos AA
                        type : "GET", //GET, PUT, POST, DELETE
                        contentType : "application/json",
                        url : "http://localhost:8080/formacion/restful/alumnos/"+parseInt(codigo, 10),
                        dataType : 'json',
                        timeout : 100000,
                        success : function(data) {

                       	$("#codigo").attr("value",data.codigo);
                       	$("#nombre").val(data.nombre);
                       	$("#apellidos").val(data.apellidos);
                            console.log("SUCCESS: ", data);
                        },
                        error : function(e) {
                            console.log("ERROR: ", e);              
                        },
                        done : function(e) {
                            console.log("DONE");
                        }
					});			// Cerramos AA

                	// Manipular el DOM
					$("#formAlumno").show();		// Mostrar el formulario
					$("#listado").hide();			// Ocultar la vista
				});			// Cerramos A
				$("button.cancelar").click(function(){
					$("#formAlumno").hide();		// Ocultar el formulario
					$("#listado").show();			// Mostrar la vista
					});
            	 // Aqui todo el codigo jQuery y no ocasionara conflictos
            	 // Hace llamada AJAX con JQuery
					$.ajax({
						type : "GET", 
						contentType : "application/json",
						url : "<%=AlumnoRestClient.REST_SERVICE_URI + "alumnos/"%>",
						// data : JSON.stringify(search),
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
						}
					});
	});
	function mostrarDatos(data) {
		var texto = '';

		for (var i = 0; i < data.length; i++) {

			var nombre = data[i].nombre;
			var apellidos = data[i].apellidos;
			texto += "<p><a href='#'>" + nombre + " " + apellidos + "</p>";
		}
		$("#listado").append(texto);
	}
	function mostrarMensaje(e) {
		$("#listado").text("No existen alumnos en la base de datos. " + e);

	}
	function createAlumno() {
		// 1. Manipular el DOM --> Limpiar formulario, mostralo, ocultar lista.
		// 2. 
		// 3. 

		var nombre = data[i].nombre;
		var apellidos = data[i].apellidos;

		// 	texto+="<p><a href='#'
	}
	function getById(codigo) {
		// 1. Peticion AJAX
		// 2. Procesar llamada
		// 3.DOM (Document Object Model) ocultar la lista y mostrar el formulario 
			console.log(codigo);
	}
</script>