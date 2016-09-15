<%@page import="com.ipartek.formacion.webservices.AlumnoRestClient"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../includes/header.jsp" />
<c:set var="uriListado"
	value='<%=AlumnoRestClient.REST_SERVICE_URI + "alumnos"%>' />
<script>
	$.noConflict();
	jQuery(document)
			.ready(
					function($) {
						//aqui todo el código jQuery y no ocasionará conflictos
						cargarDatos();
						$("#alumnos").on("click", "a", function() {
							var codigo = $(this).attr("data-id");
							cargarAlumno(codigo);

						});
						$(".cancelar").on("click", function() {
							$("#alumno").hide();
							$("#alumnos").show();
							$("input").val("");
							return false;
						});
						$("button.crear").on("click", function() {
							$("#alumno").show();
							$("#alumnos").hide();
							$("input").val("");
						});
						$("#alumnos")
								.on(
										"click",
										"button.borrar",
										function() {
											var codigo = $(this).attr("data-id");
											if (confirm("¿Seguro que desea eliminar este alumno?")) {
												$.ajax({
													type : "DELETE", //GET, PUT, POST, DELETE
													contentType : "application/json",
													url : '${uriListado}' + '/'+codigo,
													dataType : "json",
													timeout : 100000,
													success : function(data) {
														console.log("SUCCESS: ", data);
														cargarDatos();
													},
													error : function(e) {
														console.log("ERROR: ", e);
													},
													done : function(d) {
														console.log("DONE");
													}
												});
											}

										});
						$("button.guardar").on(
								"click",
								function() {
									var alumno = {};
									alumno['codigo'] = $("#codigo").val();
									alumno['nombre'] = $("#nombre").val();
									alumno['apellido'] = $("#apellido").val();
									alumno['fNacimiento'] = $("#fNacimiento")
											.val();
									alumno['email'] = $("#mail").val();
									if (alumno['codigo'] != ""
											&& alumno['codigo'] > 0) {
										$.ajax({
											type : "PUT", //GET, PUT, POST, DELETE
											contentType : "application/json",
											url : '${uriListado}' + '/'
													+ alumno['codigo'],
											data : JSON.stringify(alumno),
											dataType : "json",
											timeout : 100000,
											success : function(data) {
												console.log("SUCCESS: ", data);
												cargarDatos();
											},
											error : function(e) {
												console.log("ERROR: ", e);
											},
											done : function(d) {
												console.log("DONE");
											}
										});

									} else {
										$.ajax({
											type : "POST", //GET, PUT, POST, DELETE
											contentType : "application/json",
											url : '${uriListado}',
											data : JSON.stringify(alumno),
											timeout : 100000,
											success : function(data) {
												console.log("SUCCESS: ", data);
												cargarDatos();
											},
											error : function(e) {
												console.log("ERROR: ", e);
											},
											done : function(d) {
												console.log("DONE");
											}
										});
									}
									return false;
								});

						function cargarDatos() {
							$.ajax({
								type : "GET", //GET, PUT, POST, DELETE
								contentType : "application/json",
								url : '${uriListado}',
								dataType : "json",
								timeout : 100000,
								success : function(data) {
									console.log("SUCCESS: ", data);
									mostrarDatos(data);
								},
								error : function(e) {
									console.log("ERROR: ", e);
								},
								done : function(d) {
									console.log("DONE");
								}
							});
						}

						function mostrarDatos(data) {
							var lista = "";
							for (var i = 0; i < data.length; i++) {
								var nombre = data[i].nombre;
								var apellido = data[i].apellido;
								lista += '<tr><td>';
								lista += nombre;
								lista += '</td><td>';
								lista += apellido;
								lista += '</td><td>';
								lista += '<a role="button" class="btn btn-warning" data-id="'+ data[i].codigo +'">Editar</a>';
								lista += '</td><td>';
								lista += '<button class="borrar btn btn-danger" data-id="'+ data[i].codigo +'">Eliminar</button>';
								lista += '</td></tr>';
							}
							lista += "";
							$("table tbody").text("");
							$("table tbody").append(lista);
							$("#alumnos").show();
							$("#alumno").hide();
						}
						function cargarAlumno(codigo) {
							$.ajax({
								type : "GET", //GET, PUT, POST, DELETE
								contentType : "application/json",
								url : '${uriListado}' + "/" + codigo,
								dataType : "json",
								timeout : 100000,
								success : function(data) {
									console.log("SUCCESS: ", data);
									mostrarAlumno(data);
								},
								error : function(e) {
									console.log("ERROR: ", e);
								},
								done : function(d) {
									console.log("DONE");
								}
							});
						}
						;
						function mostrarAlumno(data) {
							$("#alumnos").hide();
							$("#alumno").show();
							$("#codigo").val(data.codigo);
							$("#nombre").val(data.nombre);
							$("#apellido").val(data.apellido);
							$("#fNacimiento").val(data.fNacimiento);
							$("#mail").val(data.email);
						}

					});
</script>
<div class="row">
	<div class="col-xs-12">
		<button class="crear btn btn-success">Crear</button>
	</div>
</div>
<div class="row">
	<div class="col-xs-12 col-sm-6">
		<div id="alumnos">
			<table class="table">
				<thead>
					<tr>
						<th>NOMBRE</th>
						<th>APELLIDOS</th>
					</tr>
				</thead>
				<tbody>

				</tbody>
			</table>
		</div>
		<div id="alumno" hidden=>
			<form>
				<input type="hidden" name="codigo" id="codigo" class="form-control" />
				<div class="form-group">
					<label for="nombre">Nombre:</label> <input type="text"
						name="nombre" id="nombre" class="form-control" />
				</div>
				<div class="form-group">
					<label for="apellido">Apellidos:</label> <input type="text"
						name="apellido" id="apellido" class="form-control" />
				</div>
				<div class="form-group">
					<label for="fNacimiento">Fecha de Nacimiento:</label> <input
						type="date" name="fNacimiento" id="fNacimiento"
						class="form-control" />
				</div>
				<div class="form-group">
					<label for="mail">E-Mail:</label> <input type="email" name="mail"
						id="mail" class="form-control" />
				</div>
				<button type="button" class="cancelar btn btn-danger">Volver</button>
				<button type="button" class="guardar btn btn-success">Guardar</button>
			</form>
		</div>
	</div>
</div>

</body>
</html>