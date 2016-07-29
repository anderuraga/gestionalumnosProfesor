<%@page import="com.ipartek.formacion.service.Idioma"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="container">
    
        <div class="card card-container col-xs-12 col-md-5">
        	  
            <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
            <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
            <p id="profile-name" class="profile-name-card"></p>
            <form action="${properties.servletLogin}" method='post' class="form-signin" >
                <span id="reauth-email" ></span>
                <input name="${properties.parNombre}" value="${properties.parNombre}" type="email" id="${properties.parNombre}" placeholder="Email address" class="form-control" required autofocus>
                <input name="${properties.parPassword}" type="password" id="${properties.parPassword}" class="form-control" placeholder="Password" required>
                <c:set var="idiomas" value="<%=Idioma.values() %>" />
				<select name="${properties.parIdiomas}" class="select" title="idiomas">
				    <c:forEach items="${idiomas}" var="idioma">
				        <option value="${idioma.locale}">${idioma.nombre}</option>
				    </c:forEach>
				</select>
                <div id="remember" class="checkbox">
                    <label>
                        <input name="${properties.parRecuerda}" id="${properties.parRecuerda}" type="checkbox" value="1"> Remember me
                    </label>
                </div>
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" >Sign in</button>
            </form><!-- /form -->
            <a href="#" class="forgot-password">
                Forgot the password?
            </a>
        </div><!-- /card-container -->
    </div><!-- /container -->