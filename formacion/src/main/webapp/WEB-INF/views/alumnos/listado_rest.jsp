<%@page import="com.ipartek.formacion.webservices.AlumnoRestClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8>
		<title>Cliente Rest Alumnos</title>
		
		<script
			  src="http://code.jquery.com/jquery-3.1.0.min.js"
			  integrity="sha256-cCueBR6CsyA4/9szpPfrX3s49M9vUU5BgtiJj06wt/s="
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
				
				$("#listado").on("click", "a", function(){
					console.log("Se ha pulsado un alumno para editar.");

					// Recoger el codigo del ALumno
					var codigo = $(this).attr("data-id");
					console.log("Codigo: " + codigo);
					// Llamada a Ajax
					$.ajax({
						type : "GET",
				        contentType : "application/json",
				        url : "http://localhost:8080/gestionAlumnosBorja/restful/alumnos/"+parseInt(codigo,10),
				        //data : JSON.stringify(search),
				        dataType : 'json',
				        timeout : 100000,
				        success : function(data) {
				            console.log("SUCCESS: ", data);
				            // Insertar los datos del alumno como value en el formulario
				            $("#codigo").val(data.codigo);
				            $("#nombre").val(data.nombre);
				            $("#apellidos").val(data.apellidos);
				            $("#dni_nie").val(data.dni_nie);
				            $("#fNacimiento").val(data.fNacimiento);
				            $("#email").val(data.email);
				            $("#telefono").val(data.telefono);
				            $("#codGenero").val(data.codGenero);
				        },
				        error : function(e) {
				            console.log("ERROR: ", e);
				            
				        },
				        done : function(e) {
				            console.log("DONE");
				        }
					});
					
					// Mostrar Formulario
					$("#formAlumno").show();
					// Ocultar Lista Alumnos
					$("#resultados").hide();
				});

				$("button.cancelar").click(function(){
					// Ocultar Formulario + Mostrar Lista
					$("#formAlumno").hide();
					$("#resultados").show();
					console.log("Creacion/Ediccion de alumno cancelada.");
					return false;
				});

				$("button.guardar").click(function(){
					// Recoger los datos del formulario
					var alumno = new Array();
					alumno['codigo'] = $("#codigo").val();
					alumno['nombre'] = $("#nombre").val();
					alumno['apellidos'] = $("#apellidos").val();
					alumno['dni_nie'] = $("#dni_nie").val();
					alumno['fNacimiento'] = $("#fNacimiento").val();
					alumno['email'] = $("#email").val();
					alumno['telefono'] = $("#telefono").val();
					alumno['codGenero'] = $("#codGenero").val();

					console.log(alumno);
					
					// Update o Insert
					if(alumno['codigo']>0 || alumno['codigo']!=""){
						// UPDATE
						$.ajax({
					        type : "PUT",
					        contentType : "application/json",
					        url : "http://localhost:8080/gestionAlumnosBorja/restful/alumnos/"+parseInt(alumno['codigo'],10),
					        data : JSON.stringify(alumno),
					        dataType : 'json',
					        timeout : 100000,
					        success : function(data) {
					            console.log("SUCCESS: ", data);
					            console.log("Alumno actualizado correctamente.");
					        },
					        error : function(e) {
					            console.log("ERROR: ", e);
					        },
					        done : function(e) {
					            console.log("DONE");
					        }
					    });
					} else{
						// INSERT
						$.ajax({
					        type : "POST",
					        contentType : "application/json",
					        url : "http://localhost:8080/gestionAlumnosBorja/restful/alumnos/",
					        data : JSON.stringify(alumno),
					        dataType : 'json',
					        timeout : 100000,
					        success : function(data) {
					            console.log("SUCCESS: ", data);
					            console.log("Alumno creado correctamente.");
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

				$("main > a").click(function(){
					console.log("Creacion de alumno.");

					$("#formAlumno").show();
					$("#resultados").hide();

					$("input").val("");
					
					return false;
				});

				function cargarDatos(){
					$.ajax({
				        type : "GET",
				        contentType : "application/json",
				        url : "http://localhost:8080/gestionAlumnosBorja/restful/alumnos/",
				        //data : JSON.stringify(search),
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

			    function getById(codigo){
				    // 1- Peticion Ajax
				    // 2- Procesara la llamada
				    // 3- Ocultar Lista + Mostrar Formulario (Manipular el DOM)

				    console.log(codigo);
				}

				function createAlumno(){
					// 1- Manipular el DOM --> Limpiar Formulario + Mostrarlo + Ocultar Lista Alumnos
					
				}

			    function mostrarDatos(data){
				    var texto = '';
				    for(var i=0; i<data.length; i++){
					    var nombre = data[i].nombre;
					    // nombre = data[i][nombre]
					    var apellidos = data[i].apellidos;
					    texto += "<p><a href='#' data-id="+data[i].codigo+">" + nombre + " " + apellidos + "</a></p>"
					}
					$("#listado").append(texto);
				}

				function mostrarMensaje(e){
					$("#listado").text("No existen alumnos en la base de datos: " + e);
				}
			});
		</script>
	</head>
	
	<body>
		
		<header>
		</header>
	
		<main>
			<a href="#">Crear Alumno</a>
			<section id="resultados">
				<header>Listado de alumnos Rest:</header>
				<div id="listado">
					
				</div>
			</section>
			
			<section id="formAlumno">
				<header>Formulario Alumno</header>
				
				<form method="post" action="#">
					<input type="hidden" name="codigo" id="codigo" />
					<br/>
					Nombre: <input type="text" name="nombre" id="nombre" size="30" />
					<br/>
					Apellidos: <input type="text" name="apellidos" id="apellidos" size="30" />
					<br/>
					DNI: <input type="text" name="dni_nie" id="dni_nie" size="30" />
					<br/>
					Fecha Nacimiento: <input type="text" name="fNacimiento" id="fNacimiento" size="30" />
					<br/>
					Email: <input type="text" name="email" id="email" size="30" />
					<br/>
					Telefono: <input type="text" name="telefono" id="telefono" size="30" />
					<br/>
					Genero: <input type="text" name="codGenero" id="codGenero" size="30" />
					<br/>
					<button class="cancelar">Cancelar</button>
					<button class="guardar">Guardar</button>
				</form>
			</section>
		</main>
		
		<footer>
		</footer>
	</body>
</html>