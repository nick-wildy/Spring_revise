<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<c:set var="dto" value="${dto }"/>

<form method="POST">
	<p>제목<input type="text" name="name" value="${dto.name }"></p>
	<p>저자<input type="text" name="author" value="${dto.author }"></p>
	<p>출판사<input type="text" name="publisher" value="${dto.publisher }"></p>
	<p>출판일<input type="date" name="publishDate" value="${dto.publishDate }"></p>
	<p>가격<input type="number" name="price" value="${dto.price }"></p>
	<p>설명<textarea name="memo" rows="5" cols="30">${dto.memo }</textarea></p>
	<p>점수<input type="number" name="score" value="${dto.score }"></p>
	<p><input type="submit"></p>
	
</form>

</body>
</html>