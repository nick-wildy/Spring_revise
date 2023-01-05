<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<form method="POST" enctype="multipart/form-data">
	<p><input type="text" name="category" placeholder="카테고리"></p>
	<p><input type="text" name="productName" placeholder="이름"></p>
	<p><input type="number" name="price" placeholder="금액"></p>
	<p><input type="number" name="score" min="0" max="5" step="0.1" placeholder="평점"></p>
	<p><input type="file" name="thumbnailFile">썸네일</p>
	<p><input type="file" name="reviewImageFile">리뷰이미지</p>
	<p><input type="submit"></p>
</form>

</body>
</html>