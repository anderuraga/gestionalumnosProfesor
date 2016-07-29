<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp" />
<main>
<div class="row">
	<div class="col-xs-12 col-md-8 col-md-offset-2">
		<table class="table">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Descripción</th>
					<th colspan="2"></th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope[constantes.listadoDep]}" var="departamento">
					<tr>
						<td><strong>${departamento.nombre }</strong></td>
						<td>${departamento.descripcion	 }</td>
						<td><a href="#" class="btn btn-warning"><i class="fa fa-pencil"></i></a></td>
						<td><a href="#" class="btn btn-danger"><i class="fa fa-times"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
</main>
<%@ include file="../includes/footer.jsp"%>