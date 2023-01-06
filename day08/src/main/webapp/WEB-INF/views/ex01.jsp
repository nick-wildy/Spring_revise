<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<form method="POST">
	<p><input type="text" name="userid" placeholder="ID" autofocus></p>
	<p><input type="password" name="userpw" placeholder="password"></p>
	<p><input type="text" name="username" placeholder="Name"></p>
	<p>생년월일 : <input type="date" name="birth"></p>
	<p>
		<label>
			<input type="radio" name="gender" value="남성">남성
		</label>	
		<label>
			<input type="radio" name="gender" value="여성">여성
		</label>
	</p>
	<p><input type="submit" value="가입"></p>
</form>

<table>
	<thead>
		<tr>
			<th>IDX</th>
			<th>USERID</th>
			<th>USERPW</th>
			<th>USERNAME</th>
			<th>BIRTH</th>
			<th>GENDER</th>
		</tr>
	</thead>
	<tbody>
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
	</tbody>
</table>

</body>
</html>