<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../includes/header.jsp" />
<c:set var="alumno" value="${alumno}"></c:set>
<main>
	<div class="row">
		<div class="col-xs-12">
			<c:if test="${!empty alumno}">
			</c:if>
		</div>
	</div>
</main>
<jsp:include page="../includes/footer.jsp" />