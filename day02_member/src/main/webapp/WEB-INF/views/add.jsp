<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<form method="POST">
	<p><input type="text" name="userid" placeholder="아이디"></p>
	<p><input type="text" name="userpw" placeholder="비번"></p>
	<p><input type="text" name="username" placeholder="아름"></p>
	<p><input type="date" name="birth" placeholder="생일"></p>
	<p><input type="radio" name="gender" value="남성">남성</p>
	<p><input type="radio" name="gender" value="여성">여성</p>
	<p><input type="submit"></p>

</form>

</body>
</html>