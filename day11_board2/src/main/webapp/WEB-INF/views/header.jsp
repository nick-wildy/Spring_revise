<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day11_board</title>
<style>
	.wrap {
		width: 900px;
	}
	div#loginInfo {
		text-align: right;
		height: 25px;
	}
	a {
		text-decoration: none;
		color: inherit;
	}
	a:hover {
		text-decoration: underline;
	}
	table {
		border: 2px solid black;
		border-collapse: collapse;
		min-width: 500px;
		margin: 0 auto;
	}
	td, th {
		border: 1px solid darkgrey;
		padding: 5px 10px;
	}
	.sb {
		margin-top: 20px;
		display: flex;
		justify-content: space-between;
	}
	textarea {
		width: 300px;
		min-height: 200px;
		resize: none;
	}
	.bold {
		font-weight: bold;
	}
	.pageNumber {
		margin-top: 20px;
		text-align: center;
	}
	table#view > tr > td:nth-child(2) {
		text-align: right;
	}
</style>
</head>
<body>

<h1><a href="${cpath }/">day11 - board</a></h1>
<nav>
	<ul>
		<c:if test="${empty login }">
		<li><a href="${cpath }/member/login">로그인</a></li>
		</c:if>

		<c:if test="${not empty login }">
		<li><a href="${cpath }/member/logout">로그아웃</a></li>
		</c:if>		
		
		<li><a href="${cpath }/board/list">게시판</a></li>
	</ul>
</nav>
<div id="loginInfo">
	<c:if test="${not empty login }">
		<h3><a href="${cpath }/member/mypage" title="마이페이지로 이동">${login.userid } (${login.username })</a></h3>
	</c:if>
</div>










