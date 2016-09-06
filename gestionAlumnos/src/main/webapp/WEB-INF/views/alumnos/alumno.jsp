<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
alumnooooo

<form id="formulario" action="" method="post">
    <fieldset>
        <legend>Formulario</legend>
            <label value="${alumno.nombre }">Nombre: </label>
                <input id="nombre" name="nombre" type="text" />
            <label value="${alumno.apellidos }">Apellidos: </label>
                <input id="apellidos" name="apellidos" type="text" />
            <input id="campo3" name="enviar" type="submit" value="Enviar" />
    </fieldset>
</form>

</body>
</html>