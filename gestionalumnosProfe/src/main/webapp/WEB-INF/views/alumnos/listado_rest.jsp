<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta  charset=UTF-8">
<title>Cliente Rest Alumnos</title>
<script   src="http://code.jquery.com/jquery-3.1.0.min.js"   integrity="sha256-cCueBR6CsyA4/9szpPfrX3s49M9vUU5BgtiJj06wt/s="   crossorigin="anonymous"></script>
<script type="text/javascript">
$(document).ready(function(){
var tablaDatos = $("#datos");
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
    			tablaDatos.append("<tr><td>"+value.nombre+"</td><td><button class='btn btn-primary'>Editar</button><button class='btn btn-danger'>Eliminar</button></td></tr>");
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
});

</script>
</head>
<body>
<h1>Listado Rest</h1>
<table class="table">
			<thead>
				<th>Nombre</th>
				<th>Operaciones</th>
			</thead>
			
			<tbody id="datos"></tbody>
		</table>
</body>

</html>