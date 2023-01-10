<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<form method="POST">
	<p><input type="text" name="userid" placeholder="ID" required autofocus></p>
	<p><input type="password" name="userpw" placeholder="Password" required></p>
	<p><input type="text" name="username" placeholder="Name" required></p>
	<p><input type="date" name="birth" required></p>
	<p>
		<label><input type="radio" name="gender" value="남성" required>남성</label>
		<label><input type="radio" name="gender" value="여성" required>여성</label>
	</p>
	<p><input type="submit"></p>
</form>

<table>
	<tr>
		<th>idx</th>
		<th>userid</th>
		<th>userpw</th>
		<th>username</th>
		<th>birth</th>
		<th>gender</th>
	</tr>
	<c:forEach var="dto" items="${list }">
	<tr>
		<td>${dto.idx }</td>
		<td>${dto.userid }</td>
		<td>${dto.userpw }</td>
		<td>${dto.username }</td>
		<td>${dto.birth }</td>
		<td>${dto.gender }</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>