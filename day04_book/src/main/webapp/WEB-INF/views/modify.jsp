<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h3>도서 수정</h3>

<form method="POST">
	<p><input type="text" name="name" placeholder="제목" value="${dto.name }" required></p>
	<p><input type="text" name="author" placeholder="저자" value="${dto.author }" required></p>
	<p><input type="text" name="publisher" placeholder="출판사" value="${dto.publisher }" required></p>
	
	<p>
		<label>
		<input type="date" name="publishDate" value="${dto.publishDate }" required>
		<span>출판일자</span>
		</label>
	</p>
	
	<p><input type="number" name="price" placeholder="가격"
			  min="0" max="500000" step="100" value="${dto.price }" required></p>
	
	<p><textarea name="memo" placeholder="도서의 개요를 입력하세요" required>${dto.memo }</textarea></p>
	
	<p><input type="number" name="score" placeholder="평점" 
			  min="0" max="10" step="0.1" value="${dto.score }" required></p>
	<p>
<!-- 		<input type="submit" value="수정"> -->
		<button>수정</button>
		<a href="${cpath }/view/${dto.idx}"><input type="button" value="뒤로가기"></a>
	</p>

</form>

</body>
</html>