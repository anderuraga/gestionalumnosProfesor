<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta  charset=UTF-8">
<title>Alumnos Rest</title>
<script   src="http://code.jquery.com/jquery-3.1.0.min.js"   integrity="sha256-cCueBR6CsyA4/9szpPfrX3s49M9vUU5BgtiJj06wt/s="   crossorigin="anonymous"></script>
<script type="text/javascript">
var url="http://localhost:8080/formacion/restful/alumnos";
$.noConflict();
jQuery(document).ready(function($){
var tablaDatos = $("#listado");
//var url="http://localhost:8080/formacion/restful/alumnos";
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
		//recoger codigo alumno
		var codigo=$(this).attr("data-id");
		//llamada Ajax
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
	$("main:first-child").click(function(){//$("main >a:eq(0)") $("main:first-child")
		$("input").val();
		$("#listado").hide();
		$("#formAlumno").show();
		});
	$("button.cancelar").click(function(){
		$("formAlumno").hide();
		$("#listado").show();
		return false;
		});
		$("button.guardar").click(function(){
		//recoger datos del form
		var alumno=new Array();
		alumno['codigo']=$("#codigo").val();
		alumno['nombre']=$("#nombre").val();
		alumno['apellidos']=$("#apellidos").val();
		//update o insert
			if(alumno['codigo']!="" || alumno['codigo']>0){//update
				$.ajax({
			        type : "PUT",
			        contentType : "application/json",
			        url : url+"/"+codigo,
			        data:JSON.stringify(alumno),//para convertirlo a JSON
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
			}else{//insert

				$.ajax({
			        type : "POST",
			        contentType : "application/json",
			        url : url,
			        data:JSON.stringify(alumno),
			        dataType : 'json',
			        timeout : 100000,
			        success : function(data) {        
			            console.log("SUCCESS: ", data);       
			        },
			        error : function(e) {
			            console.log("ERROR: ", e);
			            display(e);
			        },
			        done : function(e) {
			            console.log("DONE");
			        }
			    });
			}
			$("formAlumno").show();
			$("#listado").show();
			return false;//porque el formulario no tiene submit
			});
});
	
</script>
</head>
<body>
<main>
<h1>Listado Rest</h1>
<a href="#">Crear Alumno</a>
			<div id="listado"></div>
		<form name="formAlumno" id="formAlumno" action="POST" method="#">
		<input type="text" name="nombre" id="nombre" />
		<input type="text" name="apellidos" id="apellidos" />
		</form>

</main>
</body>
</html>