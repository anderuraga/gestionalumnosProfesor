<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.ipartek.formacion.pojo.Departamento"%>
    <%@page import="java.util.List"%>
    <%@page import="java.util.ArrayList"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
<!-- BOOSTRAP BASE STYLES -->
	<link rel="stylesheet" href="css/bootstrap.min.css"/>
	<!-- FONTAWASONE -->
	<link rel="stylesheet" href="css/font-awesome.min.css"/>
	<!-- MY THEME STYLES -->
	<link rel="stylesheet" href="css/styles.css"/>
	<!-- jQuery 1.13 -->
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	 <!--  BOOTSTRAP JS LIBS -->
	 <script src="js/bootstrap.min.js"></script>
	 <!--[if lt IE 9]>
	   <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	   <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	 <![endif]-->
</head>
<body>
<div class="container">
  <h2>Departamentos</h2>
  <p>Listado de Departamentos</p>
  
  
  
  <div class="panel-group">
  <%
  
  //List<Departamento> lDpto=(List<Departamento>)request.getAttribute("listadoDepartamentos");
  List<Departamento> lDpto=new ArrayList<Departamento>();
  Departamento a=new Departamento();
  a.setNombreDpto("asdf");
  a.setDescDpto("desc");
  lDpto.add(a);
  if(lDpto!=null){
	 
	  for(Departamento d : lDpto){
		  %>
		  <div class="panel panel-default">
	      <div class="panel-heading"><%=d.getNombreDpto() %></div>
	      <div class="panel-body"><%=d.getDescDpto() %></div>
	    </div>
	  <%
	  }
	  
	  
	  
  }
  
  %>
  
   
 <!--    <div class="panel panel-default">
      <div class="panel-heading">Panel Header</div>
      <div class="panel-body">Panel Content</div>
    </div>
    <div class="panel panel-default">
      <div class="panel-heading">Panel Header</div>
      <div class="panel-body">Panel Content</div>
    </div> -->
  </div>
</div>
</body>
</html>