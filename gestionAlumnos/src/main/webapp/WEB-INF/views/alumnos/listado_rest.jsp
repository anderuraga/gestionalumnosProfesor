<%@page import="com.ipartek.formacion.webservices.AlumnoRestClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cliente Rest Alumnos</title>
<script   src="https://code.jquery.com/jquery-3.1.0.min.js"   
	integrity="sha256-cCueBR6CsyA4/9szpPfrX3s49M9vUU5BgtiJj06wt/s="  
	crossorigin="anonymous"></script>
<style>
	#formAlumno{
		display:none
	}

</style>
<script>
		$.noConflict();
		jQuery(document).ready(function($){
			$("#listado").on("click","a",function(){ //funcion anonima, no tiene nombre
				//recoger el codigo del alumno
				var codigo=$(this).attr("data-id");
				console.log(codigo);
				//llamada a AJAX
				var url='<%=AlumnoRestClient.REST_ALUMNO_SERVICE_URI+"alumnos/"%>'+codigo;
				$.ajax({
					type : "GET",
			        contentType : "application/json",
			        url : "http://localhost:8080/formacion/restful/alumnos/"+parseInt(codigo, 10),
			        //data : JSON.stringify(alumno),
			        dataType : 'json',
			        timeout : 100000,
			        success : function(data) {
			            console.log("SUCCESS: ", data);
			            $("#codigo").attr("value",data.codigo);
			            $("#nombre").val(data.nombre);
			            $("#apellidos").val(data.apellidos);
			            //$("input").val(5)
			        },
			        error : function(e) {
			            console.log("ERROR: ", e);
			        },
			        done : function(e) {
			            console.log("DONE");
			        }
				});
				//poner los datos en el formulario
				
				//manipular el DOM:
				//mostrar el formulario
				$("#formAlumno").show();
				//ocultar la lista
				$("#listado").hide();
				console.log("he hecho click xD");
			});

			$("button.cancelar").click(function(){//la # es el id, asi que seria button.
				//ocultar el formulario
				$("#formAlumno").hide();
				//mostrar la lista
				$("#listado").show();
				return false;
			});

			$("button.guardar").click(function(){
				//recoger todos los datos del formulario
				var alumno= new Array();
				alumno['codigo']=$("#codigo").val();
				alumno['nombre']=$("#nombre").val();
				alumno['apellidos']=$("#apellidos").val();
				//update o insert(codigo)
				if(alumno['codigo']!=null||alumno['codigo']>0||alumno['codigo']!=""){
					var url='<%=AlumnoRestClient.REST_ALUMNO_SERVICE_URI+"alumnos/"%>'+codigo;
					$.ajax({
						type : "PUT",
				        contentType : "application/json",
				        data : JSON.stringify(alumno),
				        url : "http://localhost:8080/formacion/restful/alumnos/"+parseInt(codigo, 10),
				        dataType : 'json',
				        timeout : 100000,
				        success : function(data) {
				            console.log("SUCCESS: ", data);
				            $("#codigo").attr("value",data.codigo);
				            $("#nombre").val(data.nombre);
				            $("#apellidos").val(data.apellidos);
				            //$("input").val(5)
				        },
				        error : function(e) {
				            console.log("ERROR: ", e);
				        },
				        done : function(e) {
				            console.log("DONE");
				        }
					});
				}else{
					$.ajax({
						type : "POST",
				        contentType : "application/json",
				        data : JSON.stringify(alumno),
				        url : "http://localhost:8080/formacion/restful/alumnos/"+parseInt(codigo, 10),
				        dataType : 'json',
				        timeout : 100000,
				        success : function(data) {
				            console.log("SUCCESS: ", data);
				            $("#codigo").attr("value",data.codigo);
				            $("#nombre").val(data.nombre);
				            $("#apellidos").val(data.apellidos);
				            //$("input").val(5)
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
				return false;//se hace xq al usuario no se le va a hacer submit
			});
		//aquí todo el codigo jQuery y no ocasionará conflictos
		//hace llamada AJAX con JQuery
			function cargarDatos(){
				$.ajax({
					type : "GET",
			        contentType : "application/json",
			        url : "<%=AlumnoRestClient.REST_ALUMNO_SERVICE_URI+"alumnos" %>",
			        //data : JSON.stringify(search),
			        dataType : 'json',
			        timeout : 100000,
			        success : function(data) {
			            console.log("SUCCESS: ", data);
			            //mostrarDatos(data);
			        },
			        error : function(e) {
			            console.log("ERROR: ", e);
			            //mostrarMensaje(e);
			        },
			        done : function(e) {
			            console.log("DONE");
			            //enableSearchButton(true);
			        }
				});
			}

			$("main > a").click(function(){//ó "main > a:eq(0), que sería el primero de la lista
				$("input").val("");//deja todos los input en blanco
				$("#listado").hide();
				$("#formAlumno").show();
			});
			function mostrarDatos(data){
				var texto='';
				for(var i=0;i<data.length;i++){
					var nombre=data[i].nombre; //ó nombre=data[i][nombre], es lo mismo
					var apellidos=data[i].apellidos;
					
					texto+="<p><a href='#' data-id='"+data[i].codigo+"'>"+nombre+" "+apellidos+"</a></p>";	
				}
				$("#listado").append(texto);
			}

			function mostrarMensaje(e){
				$("$listado").text("No existen datos en la base d dats");

			}

			function createAlumno(){
				//se hará la llamada ajax al pulsar el btn guardar, ANTES NO!!!
				//manipular el DOM: limpiar el formulario, mostrarlo, ocultar la lista...
				//				
			}

		});
</script>
</head>
<body>
	<header>
		Alumnos
	</header>
	<main>
	<a href="javascript:createAlumno()">Crear Alumno</a>
		<article id="resultados">
			<section id="listado">
				<header>Listado completo de alumnos</header>
			</section>
			<section id="formAlumno">
				<header>Formulario alumno</header>
				<form method="post" action="#">
					<input type="hidden" name="codigo" id="codigo"/>
					<input type="text" name="nombre" id="nombre"/>
					<input type="text" name="apellidos" id="apellidos"/>
					<button class="cancelar">Cancelar</button>
					<button class="guardar">Guardar</button>
				</form>
			</section>
		</article>
	</main>
	<footer>
	</footer>
</body>
</html>