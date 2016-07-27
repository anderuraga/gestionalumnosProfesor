<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="includes/header.jsp" />
<main> <c:if test="${empty sessionScope[constantes.attUsuario]}">
	<div class="row">
		<div class="col-xs-12 col-md-4 col-md-offset-4">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title" align="center">INICIA SESIÓN</h3>
				</div>
				<div class="panel-body">
					<div class="col-xs-12 col-md-10 col-md-offset-1">
						<form action="${loginServlet}" method="post" name="loginForm">
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon" id="basic-addon1"><i class="fa fa-user"></i></span> <input
										type="text" name="${ constantes.username}" class="form-control" placeholder="Usuario"
										aria-describedby="basic-addon1">
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon" id="basic-addon2"><i class="fa fa-lock"></i></span> <input
										type="text" name="${ constantes.password}" class="form-control" placeholder="Contraseña"
										aria-describedby="basic-addon2">
								</div>
							</div>
							<div class="form-group">
								<button type="submit" class="btn btn-primary center-block">ENTRAR</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</c:if> </main>

<%@ include file="includes/footer.jsp"%>