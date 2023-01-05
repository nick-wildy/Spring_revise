<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<form method="POST" enctype="multipart/form-data">
	<p><input type="text" name="category" value="${dto.category }"></p>
	<p><input type="text" name="productName" value="${dto.productName }"></p>
	<p><input type="number" name="price" value="${dto.price }"></p>
	<p><input type="number" name="score" min="0" max="5" step="0.1" value="${dto.score }"></p>
	<p><input type="file" name="thumbnailFile">${dto.thumbnail }</p>
	<p><input type="file" name="reviewImageFile">${dto.reviewImage }</p>
	<p><input type="submit"></p>
</form>


</body>
</html>