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
<title>day06 - homeplus</title>
<style>
	form p {
		display: flex;
		justify-content: space-between;
		width: 400px;
	}
	form p > input[type="text"],
	form p > input[type="number"],
	form p > select {
		width: 252px;
	}
	form > fieldset {
		width: 500px;
	}
	.sb {
		display: flex;
		justify-content: space-between;
	}
	.je {
		display: flex;
		justify-content: flex-end;
	}
	.je button {
		margin: 0 10px;
	}
	.view {
		max-width: 900px;
		margin: 0 auto;
	}
	.detail2 {
		display: flex;
		justify-content: center;
	}
	p.reviewImage {
		height: 100px;
 		overflow: hidden;
	}
	p.reviewImage img {
		height: fit-content;
	}
	div.center {
		text-align: center;
	}
	span.red {
		color: red;
		font-weight: bold;
	}
	div#root {
		display: flex;
		flex-flow: column;
		justify-content: center;
		max-width: 1000px;
		margin: 20px auto;
	}
	div.wrap {
		display: flex;
		flex-flow: wrap;
	}
	div.item {
		margin: 20px;
	}
	
</style>
</head>
<body>

<h1><a href="${cpath }/">day06 - homeplus</a></h1>

<nav>
	<ul>
		<li><a href="${cpath }/add">상품 추가</a></li>
	</ul>
</nav>
