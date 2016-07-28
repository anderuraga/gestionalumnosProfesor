<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="includes/header.jsp"/>
	
<main>

<c:if test="${empty sessionScope[constantes.attUsuario]}">	
	
	
	<div class="row">
	<div class="col-md-4 col-md-offset-7">
     <div class="panel panel-default">
     	<div class="panel-heading"> <strong class="">Login</strong>
		 </div>
		 <div class="panel-body">
		<form class="form-horizontal" name="formu_login" method="post" action="${constantes.loginServlet}">
			<div class="form-group">
			<div class="col-sm-3">	
				<label for="${constantes.parUsername}">USUARIO:</label>
				</div>
				<div class="col-sm-7">
				<input type="text" class="form-control" 
					id="${constantes.parUsername}"
					name="${constantes.parUsername}"
					value=""/>
				</div>
			</div>
			
			<div class="form-group">
			<div class="col-sm-3">	
				<label for="${constantes.parPassword}">CONTRASEÑA:</label>
			</div>
				<div class="col-sm-7">
				<input type="text" class="form-control" 
					id="${constantes.parPassword}"  
					name="${constantes.parPassword}" 
					value=""/>
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-9">
					<button type="submit" class="btn btn-success">Entrar</button>
				</div>
			</div>	
		</form>
	</div>
	</div>
	</div>
	</div>
	
</c:if>

</main>
<%@ include file="includes/footer.jsp" %> 