<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.ipartek.formacion.webService.AlumnoRestClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.1.0.js"
	integrity="sha256-slogkvB1K3VOkzAI8QITxV3VzpOnkeNVsKvtkYLMjfk="
	crossorigin="anonymous" />
<script>
	$.noConflict();
	jQuery(document).ready(function($) {

		//Aqui todo el codigo jQuery y no ocasionara conflictos
		//Hacemos llamadas AJAX con jQuery
		$.ajax({
			type : "POST",
	        contentType : "application/json",
	        url : "<%=AlumnoRestClient.REST_SERVICE_URI+"alumnos"%>",
	        //data : JSON.stringify(search),
	        dataType : 'json',
	        timeout : 100000,
	        success : function(data) {
	            console.log("SUCCESS: ", data);
	            //display(data);
	        },
	        error : function(e) {
	            console.log("ERROR: ", e);
	            //display(e);
	        },
	        done : function(e) {
	            console.log("DONE");
	            //enableSearchButton(true);
	        }
			
					
		});
	});
</script>
</head>
<body>

	<header></header>
	<main> <section id="resultado"></section> </main>
	<footer></footer>

</body>
</html>