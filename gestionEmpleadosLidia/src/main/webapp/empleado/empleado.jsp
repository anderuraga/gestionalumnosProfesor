<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp" />
<div class="container">
  <h3>Datos empleado</h3>
  <form class="form-inline" role="form">
    <div class="form-group">
      <label for="email">Nombre:</label>
      <input type="text" class="form-control" id="nombre">
    </div>
    <div class="form-group">
      <label for="pwd">Apellidos:</label>
      <input type="text" class="form-control" id="apellidos">
    </div>
     <div class="form-group">
      <label for="pwd">DNI:</label>
      <input type="text" class="form-control" id="apellidos">
    </div>
    <div class="form-group">
      <label for="pwd">Fecha de nacimiento:</label>
    	<div class='input-group date' id='datetimepicker1'>
        <input type='text' class="form-control" />
        	<span class="input-group-addon">
              	<span class="glyphicon glyphicon-calendar"></span>
            </span>
            <script type="text/javascript">
            $( document ).ready(function() {
                $('#fecha').datepicker();
            });
        </script>
        </div>
    </div>
 


<%@ include file="../includes/footer.jsp"%>