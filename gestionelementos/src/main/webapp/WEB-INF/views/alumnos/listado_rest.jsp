<%@page import="com.ipartek.formacion.webservices.AlumnoRestClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset=UTF-8">
		<title>Cliente Rest Alumnos</title>
		<script src="https://code.jquery.com/jquery-3.1.0.min.js" integrity="sha256-cCueBR6CsyA4/9szpPfrX3s49M9vUU5BgtiJj06wt/s=" crossorigin="anonymous"></script>
<!-- No usar nunca javascript para maquetar, nunca se coloca al final, siempre pegado al body -->
		<style>
			#formAlumno {
				display: none;
			}
		</style>
		<script>
		$.noConflict();
			jQuery(document).ready(function($) { // INICIO	funcion anonima que cuando "ready" el "(document)" se ejecuta	
				//Aqui va el codigo jquery y no ocasionara conflictos
				// Hace una llamada AJAX con jQuery
		
				$("#listado").on( "click","a", function(){ // INICIO	funcion anonima que cuando "click" en "(#listado)" se ejecuta	
					console.log("Acabo de hacer click para editar el alumno");
					// recoger los datos del alumno
					var codigo = $(this).attr("data-id");
					console.log(codigo);
					var url = '<%=AlumnoRestClient.REST_SERVICE_URI + "alumnos"%>/'+codigo;
					$.ajax({	// INICIO peticion AJAX
						type : "GET",
						contentType : "application/json",       
						url : url,
						//data : JSON.stringify(search),
						dataType : 'json',
						timeout : 100000,
						success : function(data) {											
							console.log("SUCCESS: ", data);

						$("#codigoAlumno").val(data.codigoAlumno);
						$("#nombreAlumno").val(data.nombreAlumno);
						$("#apellidosAlumno").val(data.apellidosAlumno);
						$("#fechaAlumno").val(data.fechaAlumno);
						$("#emailAlumno").val(data.emailAlumno);
						$("#telefonoAlumno").val(data.telefonoAlumno);
						$("#dniAlumno").val(data.dniAlumno);
						},							
						error : function(e) {											
							console.log("ERROR: ", e);
						},				
						done : function(e) {												
							console.log("DONE");
						}											
					});	// FIN peticion AJAX
					// Mostrar datos en el form
					//manipular el DOM
					//Mostrar formulario y ocultar la lista
					$("#formAlumno").show();
					$("#listado").hide();
				});	 // FIN	funcion anonima
		
			$("button.cancelar").click(function(){ // INICIO	funcion anonima que cuando "click" en "(button.cancelar)" se ejecuta						
					$("#formAlumno").hide();		// Ocultar el formulario
					$("#listado").show();			// Mostrar la vista
					return false;
				}); // FIN	funcion anonima
				
				$("button.guardar").click(function(){ // INICIO	funcion anonima que cuando "click" en "(button.guardar)" se ejecuta
					var alumno = new Array();
					alumno['codigo'] = $("codigo").val();
					if (alumno.codigo!=null || alumno.codigo>0){ // FIN	funcion anonima
		
					}
					return false;
				});	 // FIN	funcion anonima
																		
				$.ajax({	// INICIO peticion AJAX
					type : "GET",
					contentType : "application/json",        
					url : "<%=AlumnoRestClient.REST_SERVICE_URI + "alumnos"%>",
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
				});	// FIN peticion AJAX
		
				$("main > a").click(function(){	// INICIO	funcion anonima que cuando "click" en "(main > a)" se ejecuta
					$("input").val("");
					$("#formAlumno").show();
					$("#listado").hide();	
				}); // FIN	funcion anonima
		    
				function mostrarDatos(data){	// INICIO	funcion mostrarDatos
					var texto = '';
					for(var i=0; i < data.length; i++){	// INICIO	bucle for
						var nombre = data[i].nombre;
						var apellidos = data[i].apellidos;
		            	texto += "<p><a href='#' data-id='"+data[i].codigo+"'>"+nombre+" "+apellidos+"</a></p>";
					}	// FIN	bucle for
					$("#listado").html(texto);
				}	// FIN	funcion mostrarDatos
		
		
		
				function mostrarMensaje(e){	// INICIO	funcion mostrarMensaje
					$("#listado").Text("No existen alumnos en la base de datos" + e);
				}// FIN	funcion mostrarMensaje
		
				function createAlumno(){	// INICIO	funcion createAlumno
					$.ajax({	// INICIO peticion AJAX
						type : "POST",
						contentType : "application/json",         
						url : "<%=AlumnoRestClient.REST_SERVICE_URI + "alumnos"%>",
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
						}		
					});	// FIN peticion AJAX
				 }	// FIN	funcion createAlumno
				 										
				function getByID(codigo){	// INICIO	funcion getByID
					$.ajax({	// INICIO peticion AJAX
						type : "GET",
						contentType : "application/json",       
						url : "<%=AlumnoRestClient.REST_SERVICE_URI + "alumnos"%>/codigo",
						// data: JSON.stringify(search),
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
					});	// FIN peticion AJAX
				}	// FIN	funcion getByID
		
			}); // FIN	funcion anonima
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
						<form>
							<input type="hidden" name="codigoAlumno" id="codigoAlumno" />
							<input type="text" name="nombreAlumno" id="nombreAlumno" />
							<input type="text" name="apellidosAlumno" id="apellidosAlumno" />
							<input type="text" name="fechaAlumno" id="fechaAlumno" />
							<input type="text" name="emailAlumno" id="emailAlumno" />
							<input type="text" name="telefonoAlumno" id="telefonoAlumno" />
							<input type="text" name="dniAlumno" id="dniAlumno" />
							<button class="cancelar">Cancelar</button>
							<button class="guardar">Guardar</button>
						</form>
					</section>
				</article>
			</main>
		<footer> </footer>
	</body>
</html>