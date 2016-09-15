<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta  charset=UTF-8">
<title>Cliente Rest Alumnos</title>
<script   src="http://code.jquery.com/jquery-3.1.0.min.js"   integrity="sha256-cCueBR6CsyA4/9szpPfrX3s49M9vUU5BgtiJj06wt/s="   crossorigin="anonymous"></script>
<script type="text/javascript">
var url="http://localhost:8080/formacion/restful/alumnos";
$.noConflict();
jQuery(document).ready(function($){
var tablaDatos = $("#listado");
var url="http://localhost:8080/formacion/restful/alumnos";
	$.ajax({
        type : "GET",
        contentType : "application/json",
        url : url,
        dataType : 'json',
        timeout : 100000,
        success : function(data) {
            console.log("SUCCESS: ", data);
            
            $(data).each(function(key,value){
            	$("#listado").append("<p>"+value.nombre+" "+value.apellidos+"<a class='btn btn-primary' data-id='"+value.codigo+"' href='#''>Editar</a>");
    		});
           
        },
        error : function(e) {
            console.log("ERROR: ", e);
            display(e);
        },
        done : function(e) {
            console.log("DONE");
            enableSearchButton(true);
        }
    });
	$("#listado").on( "click","a", function(){
		//recoger codigo Alumno
		var codigo=$(this).attr("data-id");
		//llamada a Ajax
		$.ajax({
	        type : "GET",
	        contentType : "application/json",
	        url : url+"/"+codigo,
	        dataType : 'json',
	        timeout : 100000,
	        success : function(data) {
		        
	            console.log("SUCCESS: ", data);
	            
	            $('#nombre').val(data.nombre);
	            $('#apellidos').val(data.apellidos);          
	        },
	        error : function(e) {
	            console.log("ERROR: ", e);
	            display(e);
	        },
	        done : function(e) {
	            console.log("DONE");
	            enableSearchButton(true);
	        }
	    });
			
	});
	$("main >a:eq(0)").click(function(){
		$("input").val();
		$("#listado").hide();
		$("#formAlumno").show();
		});
});

</script>
</head>
<body>
<main>
<h1>Listado Rest</h1>
<a href="#">Crear Alumno</a>
			
			<div id="listado"></div>
		</table>
		<form name="formAlumno" id="formAlumno" action="POST" method="#">
		<input type="text" name="nombre" id="nombre" />
		<input type="text" name="apellidos" id="apellidos" />
		</form>
</main>
</body>

</html>