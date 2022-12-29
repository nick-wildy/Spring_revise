<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<form method="POST">
	<p><input type="text" name="name" placeholder="제목"></p>
	<p><input type="text" name="author" placeholder="저자"></p>
	<p><input type="text" name="publisher" placeholder="출판사"></p>
	<p><input type="date" name="publishDate" placeholder="출간날짜"></p>
	<p><input type="number" name="price" placeholder="금액"></p>
	<p><textarea name="memo" rows="5" cols="30"></textarea></p>	
	<p><input type="number" name="score" placeholder="점수" step="0.01"></p>
	<p><input type="submit"></p>
	
</form>

</body>
</html>