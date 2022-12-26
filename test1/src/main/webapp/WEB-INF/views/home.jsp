<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Hello, world</h1>

<p>지금은 ${serverTime }입니다</p>

<fieldset>
	<form action="${pageContext.request.contextPath }/info">
		<p><input type="text" name="name" placeholder="이름" required autofocus></p>
		<p><input type="text" name="age" placeholder="나이" required></p>
		<p><input type="submit"></p>
	</form>
</fieldset>



</body>
</html>