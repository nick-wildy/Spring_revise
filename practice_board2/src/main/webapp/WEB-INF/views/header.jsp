<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="cpath" value="${pageContext.request.contextPath }"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DC Outside</title>
<style>
	.head{
		width: 1000px;
		height: 100px;
		background-color: #dadada;
		display: flex;
		margin: auto;
	}
	.head_left{
	width:150px;
	height: 100px;
	}
	.icon{
	width:150px;
	height: 100px;
	margin: 0;
	padding: 0;
	}
	.head_right{
	width: 600px;
	height: 100px;
	background-color: #dadada
	}
	.head_right > ul{
	list-style: none;
	display: flex;
	justify-content: space-around;
	align-items: center;
	padding: 0;
	margin: 0;
	}
	.client{
	text-align: right;
	color: white;
	}
	.boardList{
	width:900px;
	height: 900px;
	border: 1px solid black;
	margin: auto;
	display: flex;
	justify-content: space-between;
	}
	.boardSearch{
	width: 300px;
	height: 50px;
	margin: auto;
	padding: 0;
	display: flex;
	justify-content: right;
	}
	.boardList > ul,li{
	padding: 0;
	margin: 0;
	}
	.boardList >td{
	
	height: 20px;
	
	}
</style>
</head>
<body>

<p>${cpath }</p>

<div class="head">
	<div class="head_left">
		<a href="${cpath }"><img class="icon" src="${cpath }/resources/img/아이콘.jfif"></a>
	</div>
	
	<div class="head_right">
		<c:if test="${empty login }">
		<div class="client"></div>
		<ul>
			<li><a href="${cpath }/member/login">로그인</a></li>
			<li><a href="${cpath }/member/join">회원가입</a></li>
			<li><a href="${cpath }/board/list">게시판보기</a></li>
			<li><a href="${cpath }/member/mypage">마이페이지</a></li>
		</ul>
		</c:if>
		<c:if test="${not empty login }">
		<div class="client"> ${login.username }님 반갑습니다.</div>
		<ul>
			
			<li><a href="${cpath }/board/list">게시판보기</a></li>
			<li><a href="${cpath }/member/mypage">마이페이지</a></li>
			<li><a href="${cpath }/member/logout">로그아웃</a></li>
		</ul>
		</c:if>
	</div>
</div>

