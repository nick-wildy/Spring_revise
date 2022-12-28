<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day02</title>
</head>
<body>

<h1>day02</h1>
<hr>

<h3>DB version : ${version }</h3>

<ul>
	<li><a href="${cpath }/ex01">ex01 - student1 목록</a></li>
	<li><a href="${cpath }/ex02">ex02 - student1 추가</a></li>
</ul>



</body>
</html>