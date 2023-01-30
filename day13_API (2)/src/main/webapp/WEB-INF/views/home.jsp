<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>home.jsp</h1>
<hr>

<ul>
	<li><a href="${cpath }/ex01">ex01 - 부산명소정보</a>
	<li><a href="${cpath }/ex02">ex02 - 부산축제정보</a>
	<li><a href="${cpath }/ex03">ex03 - 중기기온예보</a>
	<li><a href="${cpath }/ex04">ex04 - 시도별 미세먼지 실시간 평균 정보</a>
</ul>

</body>
</html>









