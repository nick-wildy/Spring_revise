<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h3>게시판 (미구현)</h3>

<p>로그인이 되어 있지 않으면 접근할 수 없다</p>

<ul>
	<li><a href="${cpath }/board/write">쓰기</a></li>
	<li><a href="${cpath }/board/modify/1">수정</a></li>
	<li><a href="${cpath }/board/delete/2">삭제</a></li>
</ul>


</body>
</html>