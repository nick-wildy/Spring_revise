<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>student1 테이블 목록</h1>
<hr>

<table>
	<thead>
		<tr>
			<th>NAME</th>
			<th>KOR</th>
			<th>ENG</th>
			<th>MAT</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="dto" items="${list }">
			<tr>
				<td>${dto.name }</td>
				<td>${dto.kor }</td>
				<td>${dto.eng }</td>
				<td>${dto.mat }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>