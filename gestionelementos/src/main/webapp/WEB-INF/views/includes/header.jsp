<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet" />
<link href="<c:url value="/resources/css/bootstrap-theme.min.css" />"
	rel="stylesheet" />
<link href="<c:url value="/resources/css/font-awesome.min.css" />"
	rel="stylesheet" />
<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" />

<script
	src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="../../../../formacion">Home <span
							class="glyphicon glyphicon-home" style="color: white"></span></a></li>
					<li class="dropdown"><a href="" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Alumnos <span
							class="glyphicon glyphicon-user" style="color: lightblue"></span></a>
						<ul class="dropdown-menu">

							<li><a href="alumnos">Ver todos</a></li>
							<li><a href="alumnos/newAlumno">Agregar
									nuevo</a></li>
						</ul></li>
					<!-- /.Alumnos-collapse -->

					<li class="dropdown"><a href="" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Candidatos <span
							class="glyphicon glyphicon-user" style="color: white"></span></a>
						<ul class="dropdown-menu">

							<li><a href="candidatos">Ver todos</a></li>
							<li><a href="candidatos/newCandidato">Agregar
									nuevo</a></li>
						</ul></li>
					<!-- /.Candidatos-collapse -->

					<li class="dropdown"><a href="" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Cursos <span
							class="glyphicon glyphicon-book" style="color: lightblue"></span></a>
						<ul class="dropdown-menu">

							<li><a href="cursos">Ver todos</a></li>
							<li><a href="cursos/newCurso">Agregar
									nuevo</a></li>
						</ul></li>
					<!-- /.Cursos-collapse -->

					<li class="dropdown"><a href="" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Modulos <span
							class="glyphicon glyphicon-book" style="color: white"></span></a>
						<ul class="dropdown-menu">

							<li><a href="modulos">Ver todos</a></li>
							<li><a href="modulos/newModulo">Agregar
									nuevo</a></li>
						</ul></li>
					<!-- /.Modulos-collapse -->

				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>