<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<c:if test="${dto.writer != login.userid }">
	<script>
		alert('본인의 글만 수정/삭제 할 수 있습니다')
		location.href = '${cpath}/board/list'
	</script>
</c:if>

<form method="POST">
	<p><input type="text" name="title" placeholder="제목" value="${dto.title }" required></p>
	<p><input type="text" name="writer" value="${dto.writer }" readonly></p>
	<p><textarea name="content" placeholder="내용" required>${dto.content }</textarea></p>
	<p><input type="submit" value="수정"></p>
</form>


</body>
</html>