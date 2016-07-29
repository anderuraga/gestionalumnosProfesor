<jsp:include page="../include/header.jsp"/>
<%@taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri= "http://java.sun.com/jsp/jstl/fmt" %>

<h1>Empleado</h1>

<c:set var="empleado" value="${empleado}"/>
<div class="col-md-6 col-md-offset-3">
	
	<form class="form-horizontal" action="${properties.servletEmpleado}" method="POST">
		<div class="form-group row">
		    <label class="col-md-6" for="${properties.parCodigo}">Codigo </label>
		    <div class="col-md-6">
		      <input type="text" id="${properties.parCodigo}" name="${properties.parCodigo}" value="${empleado.codigo}" />
		    </div>
		</div>
		<div class="form-group row">
		    <label class="col-md-6" for="${properties.parNombre}">Nombre </label>
		    <div class="col-md-6">
		      <input type="text" id="${properties.parNombre}" name="${properties.parNombre}" value="${empleado.nombre}" />
		    </div>
		</div>
		<div class="form-group row">
		    <label class="col-md-6" for="${properties.parApellidos}">Apellidos </label>
		    <div class="col-md-6">
		      <input type="text" id="${properties.parApellidos}" name="${properties.parApellidos}" value="${empleado.apellidos}" />
		    </div>
		</div>	
		<div class="form-group row">
		    <label class="col-md-6" for="${properties.parFechaNac}">Fecha Nacimiento </label>
		    <div class="col-md-6">
				<input type="text" id="${properties.parFechaNac}" name="${properties.parFechaNac}" value="${empleado.fechaNacimiento}" />
		    </div>
		</div>
		<div class="form-group row">
		    <label class="col-md-6" for="${properties.parFechaContra}">Fecha Contratacion </label>
		    <div class="col-md-6">
		      <input type="text" id="${properties.parFechaContra}" name="${properties.parFechaContra}" value="${empleado.fechaContratacion}" />
		    </div>
		</div>	
		<div class="form-group row">
		    <label class="col-md-6" for="${properties.parSeguridadS}">Seguridad Social </label>
		    <div class="col-md-6">
		      <input type="text" id="${properties.parSeguridadS}" name="${properties.parSeguridadS}" value="${empleado.numeroSS}" />
		    </div>
		</div>	
		<div class="form-group row">
		    <label class="col-md-6" for="${properties.parCuenta}">Cuenta Corriente </label>
		    <div class="col-md-6">
		      <input type="text" id="${properties.parCuenta}" name="${properties.parCuenta}" value="${empleado.cuentaCorriente}" />
		    </div>
		</div>	
		<div class="form-group row">
		    <label class="col-md-6" for="${properties.parDir}">Direccion </label>
		    <div class="col-md-6">
		      <input type="text" id="${properties.parDir}" name="${properties.parDir}" value="${empleado.direccion}" />
		    </div>
		</div>	
		<div class="form-group row">
		    <label class="col-md-6" for="${properties.parLoc}">Localidad </label>
		    <div class="col-md-6">
		      <input type="text" id="${properties.parLoc}" name="${properties.parLoc}" value="${empleado.localidad}" />
		    </div>
		</div>	
		<div class="form-group row">
		    <label class="col-md-6" for="${properties.parCP}">Codigo Postal </label>
		    <div class="col-md-6">
		      <input type="text" id="${properties.parCP}" name="${properties.parCP}" value="${empleado.codigoPostal}" />
		    </div>
		</div>
		<div class="form-group row">
		    <label class="col-md-6" for="${properties.parDNI}">DNI </label>
		    <div class="col-md-6">
		      <input type="text" id="${properties.parDNI}" name="${properties.parDNI}" value="${empleado.dni}" />
		    </div>
		</div>	
		<div class="form-group row">
		    <label class="col-md-6" for="${properties.parDpto}">Departamento </label>
		    <div class="col-md-6">
		      <input type="text" id="${properties.parDpto}" name="${properties.parDpto}" value="${empleado.departamento}" />
		    </div>
		</div>	
		<div class="form-group">
			<div class="col-md-12">
		    	<input id="update" name="update" class="btn btn-succes" type="submit" value="Actualizar"/>
			</div>
		</div>	
	</form>
</div>
</body>
</html>