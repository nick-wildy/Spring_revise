<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<form method="POST" enctype="multipart/form-data">
	<p><input type="text" name="title" value="${dto.title }" required></p>
	<p><input type="text" name="writer" value="${login.userid }" readonly></p>
	<p><textarea name="content" placeholder="내용" required>"${dto.content }"</textarea></p>
	<p><input type="file" name="uploadFile">${dto.fileName }</p>

	<p><input type="submit" value="수정"></p>
</form>


</body>
</html>