<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="cpath">${pageContext.request.contextPath }</c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day05 - file</title>
<style>
	table {
		border-collapse: collapse;
		border: 2px solid black;
	}
	thead {
		background-color: #dadada;
	}
	td, th {
		padding: 5px 10px;
		border: 1px solid grey;
	}
</style>
</head>
<body>

<h1><a href="${cpath }/">day05 - file</a></h1>
<hr>
