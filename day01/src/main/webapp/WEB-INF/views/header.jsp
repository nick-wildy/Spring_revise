<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--스프링에서는 jstl을 바로 사용할 수 있다 (maven 라이브러리 의존성에 기본 포함됨) --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day01</title>
</head>
<body>

<h1><a href="${cpath }">day01</a></h1>
<hr>
