<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<jsp:useBean id="date" class="java.util.Date" />
<fmt:formatDate var="now" value="${date }" pattern="yyyy-MM-dd" />
<%
	java.util.Date date1 = new java.util.Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String now = sdf.format(date1);
%>

<h3>도서 추가</h3>

<form method="POST">
	<p><input type="text" name="name" placeholder="제목" required></p>
	<p><input type="text" name="author" placeholder="저자" required></p>
	<p><input type="text" name="publisher" placeholder="출판사" required></p>
	
	<p>
		<label>
		<input type="date" name="publishDate" value="${now }" required>
		<span>출판일자</span>
		</label>
	</p>
	
	<p><input type="number" name="price" placeholder="가격"
			  min="0" max="500000" step="100" required></p>
	
	<p><textarea name="memo" placeholder="도서의 개요를 입력하세요" required></textarea></p>
	
	<p><input type="number" name="score" placeholder="평점" 
			  min="0" max="10" step="0.1" required></p>
	<p><input type="submit"></p>

</form>

</body>
</html>