<%@page import="java.util.List"%>
<%@page import="com.ipartek.formacion.service.Idiomas"%>
<%@page import="com.ipartek.formacion.service.Genero"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="com.ipartek.formacion.controller.exception.AlumnoError"%>
<%@page import="com.ipartek.formacion.pojo.Alumno"%>
<%@page import="com.ipartek.formacion.pojo.Curso"%>
<%@page import="com.ipartek.formacion.controller.Constantes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp" />
<main class=""> <%
 	Alumno alumno = (Alumno) request.getAttribute(Constantes.ATT_ALUMNO);
 	int op = -1;
 	if (alumno != null) {
 		op = Constantes.OP_UPDATE;
 %>
<title>Alumno <%
	out.write(alumno.getNombre());
%></title>
<%
	} else {
%>
<title>Alumno - Alumno nuevo</title>
<%
	op = Constantes.OP_CREATE;
		alumno = new Alumno();
	}
%> <a href="<%=Constantes.SERVLET_ALUMNOS%>">Listado de alumnos</a>
<div id="wrapper">
	<%
		if (alumno instanceof AlumnoError) { //si alumno es instancia de AlumnoError
			AlumnoError aux = (AlumnoError) alumno; //cast in
			out.write(aux.getMensaje());
		}
	%>


	<%
		if (alumno != null) {
	%>
	<div class="row">
		<div class="col-xs-10">
			<form id="formAlumno" method="post" action="<%=Constantes.SERVLET_ALUMNOS%>">
				<div class="col-xs-5">
					<input type="hidden" id="<%=Constantes.PAR_OPERACION%>"
						name="<%=Constantes.PAR_OPERACION%>" value="<%=op%>" /> <input
						type="hidden" id="<%=Constantes.PAR_CODIGO%>"
						name="<%=Constantes.PAR_CODIGO%>" value="<%=alumno.getCodigo()%>" />
					<div class="form-group">
						<label for="<%=Constantes.PAR_NOMBRE%>">NOMBRE:</label> <input
							type="text" class="form-control" id="<%=Constantes.PAR_NOMBRE%>"
							name="<%=Constantes.PAR_NOMBRE%>" value="<%=alumno.getNombre()%>" />
					</div>
					<div class="form-group">
						<label for="<%=Constantes.PAR_APELLIDOS%>">APELLIDOS:</label> <input
							type="text" class="form-control"
							id="<%=Constantes.PAR_APELLIDOS%>"
							name="<%=Constantes.PAR_APELLIDOS%>"
							value="<%=alumno.getApellidos()%>" />
					</div>
					<div class="form-group">
						<label for="<%=Constantes.PAR_DNI%>">DNI:</label> <input
							type="text" class="form-control" id="<%=Constantes.PAR_DNI%>"
							name="<%=Constantes.PAR_DNI%>" value="<%=alumno.getDni()%>"
							pattern="(\d{8})([-]?)([A-Z]{1})" />
					</div>
					<%
						Date date = alumno.getfNacimiento();
							GregorianCalendar calendar = new GregorianCalendar();
							calendar.setTime(date);
					%>

					<div class="form-group">
						<label>Fecha:</label>
						<div class="form-inline">
							<input class="form-control" type="number"
								value="<%=calendar.get(GregorianCalendar.DAY_OF_MONTH)%>"
								min="1" max="31"
								name="<%=Constantes.PAR_DIA%>" /> 
							<input type="number"
								value="<%=calendar.get(GregorianCalendar.MONTH) + 1%>" min="1"
								max="12" class="form-control" name="<%=Constantes.PAR_MES%>" />
							<input class="form-control" type="number"
								value="<%=calendar.get(GregorianCalendar.YEAR)%>"
								 name="<%=Constantes.PAR_ANYO%>" />
						</div>
					</div>
					  </div>
						<div class="form-group">
						<div class="col-xs-5">
							<label for="<%=Constantes.PAR_EMAIL%>">EMAIL:</label> <input
								type="email" class="form-control" id="<%=Constantes.PAR_EMAIL%>"
								name="<%=Constantes.PAR_EMAIL%>" value="<%=alumno.getEmail()%>"
								pattern="(\d{8})([-]?)([A-Z]{1})" />
						
						<div class="form-group">
							<label for="<%=Constantes.PAR_TELEF%>">TELÉFONO:</label> <input
								type="text" class="form-control" id="<%=Constantes.PAR_TELEF%>"
								name="<%=Constantes.PAR_TELEF%>"
								value="<%=alumno.getTelefono()%>" />
						</div>
					
				
					<div class="form-group">
						<div class="form-inline">
							<label>GENERO: </label> <input type="radio" class="form-control"
								name="<%=Constantes.PAR_GENERO%>"
								value="<%=Genero.FEMENINO.getCodigo()%>"
								<%=Genero.FEMENINO == alumno.getGenero() ? "checked" : ""%> />
							<%=Genero.FEMENINO.getValor()%>
							<input type="radio" class="form-control"
								name="<%=Constantes.PAR_GENERO%>"
								value="<%=Genero.MASCULINO.getCodigo()%>"
								<%=Genero.MASCULINO == alumno.getGenero() ? "checked" : ""%> />
							<%=Genero.MASCULINO.getValor()%>
							<input type="radio" class="form-control"
								name="<%=Constantes.PAR_GENERO%>"
								value="<%=Genero.OTROS.getCodigo()%>"
								<%=Genero.OTROS == alumno.getGenero() ? "checked" : ""%> />
							<%=Genero.OTROS.getValor()%>
						</div>
					</div>
				

				<div class="form-group">
					<label>Idiomas:</label> <input type="checkbox"
						name="<%=Constantes.PAR_IDIOMA%>" id="<%=Constantes.PAR_CODIGO%>"
						<%=alumno.getIdiomas().contains(Idiomas.CASTELLANO) ? "checked" : ""%>
						value="<%=Idiomas.CASTELLANO.getCodigo()%>" />
					<%=Idiomas.CASTELLANO.getNombre()%>

					<input type="checkbox" name="<%=Constantes.PAR_IDIOMA%>"
						id="<%=Constantes.PAR_CODIGO%>"
						<%=alumno.getIdiomas().contains(Idiomas.EUSKERA) ? "checked" : ""%>
						value="<%=Idiomas.EUSKERA.getCodigo()%>" />
					<%=Idiomas.EUSKERA.getNombre()%>

					<input type="checkbox" name="<%=Constantes.PAR_IDIOMA%>"
						id="<%=Constantes.PAR_CODIGO%>"
						<%=alumno.getIdiomas().contains(Idiomas.INGLES) ? "checked" : ""%>
						value="<%=Idiomas.INGLES.getCodigo()%>" />
					<%=Idiomas.INGLES.getNombre()%>


				</div>

				<div class="form-group">
						<label>Curso:</label> <select name="<%=Constantes.PAR_CURSO%>">
							<!-- 
			    	<option value="<%=Curso.CODIGO_CURSO%>">Seleccione un curso</option>
			     -->
							<%
								List<Curso> cursos = (List<Curso>) request.getAttribute(Constantes.ATT_LISTADO_CURSOS);
									if (cursos != null) {
										for (Curso curso : cursos) {
							%>
							<option <%=alumno.getCurso().equals(curso) ? "selected" : ""%>
								value="<%=curso.getCodigo()%>">
								<%=curso.getNombre()%></option>
							<%
								}
									}
							%>
						</select>
					</div>
					<button id="btnGuardarAlum" type="submit" class="btn btn-success pull-right">Guardar</button>
					</div>
				</div>
				
				
			</form>
		</div>



		<%
			}
		%>
	</div>
</main>

<%@ include file="../includes/footer.jsp"%>
