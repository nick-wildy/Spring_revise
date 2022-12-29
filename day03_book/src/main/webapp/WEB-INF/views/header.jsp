<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
	width:800px;
	
	border: 1px solid black;
	}
	th,td{
	border: 1px solid black;
	}
</style>

</head>
<body>

<h1><a href="${cpath }">day03-book</a></h1>

<nav>
	<ul>
		<li><a href="${cpath }/list">목록</a></li>
		<li><a href="${cpath }/add">추가</a></li>
		<li><a href="${cpath }/search">검색</a></li>
	</ul>
</nav>
<hr>

