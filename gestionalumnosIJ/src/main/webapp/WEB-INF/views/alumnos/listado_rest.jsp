<%@page import="com.ipartek.formacion.webservices.AlumnoRestClient"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../includes/header.jsp" />
<script>
	$.noConflict();
	jQuery(document).ready(function($) {
		//aqui todo el código jQuery y no ocasionará conflictos
		$.ajax({
			type : "GET", //GET, PUT, POST, DELETE
			contentType : "application/json",
			url : "<%=AlumnoRestClient.REST_SERVICE_URI + "alumnos"%>",
			//data : JSON.stringify(search),
			dataType : "json",
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);
				//display(data);
			},
			error : function(e) {
				console.log("ERROR: ", e);
				// 				display(e);
			},
			done : function(d) {
				console.log("DONE");
			}
		});
	});
</script>
<div class="row">
	<div class="col-xs-12"></div>
</div>

</body>
</html>