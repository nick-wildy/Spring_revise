<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>
<%@ include file="header.jsp" %>

<h3>DTO를 이용한 파일 업로드</h3>

<form method="POST" enctype="multipart/form-data">
	<p><input type="text" name="name" placeholder="이름"></p>
	<p><input type="number" name="age" placeholder="나이"></p>
	<p><input type="file" name="uploadFile"></p>
	<p><input type="submit"></p>
</form>

<img src="${cpath }/resources/danbi.jpg" height="100">

<table>
	<tr>
		<th>NAME</th>
		<th>AGE</th>
		<th>FILENAME</th>
		<th>이미지 태그</th>
	</tr>
	<c:forEach var="dto" items="${list }">
	<tr>
		<td>${dto.name }</td>
		<td>${dto.age }</td>
		<td>${dto.fileName }</td>
		<td><img src="${cpath }/upload/${dto.fileName }" height="100"></td>
	</tr>
	</c:forEach>
</table>

</body>
</html>