<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h3>상품 수정</h3>

<form method="POST" enctype="multipart/form-data">
	<fieldset>
	<p>
		<span class="columnName">카테고리</span>
		<select name="category" required>
			<option value="">== 카테고리를 선택하세요 ==</option>
			<option ${dto.category == '사과' ? 'selected' : '' } value="사과">사과</option>
			<option ${dto.category == '배' ? 'selected' : '' } value="배">배</option>
		</select>
	</p>
	<p>
		<span class="columnName">상품이름</span>
		<input type="text" name="productName" placeholder="청주 사과 5Kg" value="${dto.productName }" required>
	</p>
	<p>
		<span class="columnName">가격</span>
		<input type="number" name="price" min="0" max="500000" placeholder="29500" value="${dto.price }" required>
	</p>
	<p>
		<span class="columnName">상품이름</span>
		<input type="number" name="score" min="0" max="5" step="0.1" placeholder="4.5" value="${dto.score }" required>
	</p>
	
	<p>
		<span class="columnName">현재 썸네일</span>
		<img src="${cpath }/upload/${dto.thumbnail}" height="80px">
	</p>
		<input type="text" name="thumbnail" value="${dto.thumbnail }">
	<p>
		<span class="columnName">썸네일 이미지</span>
		<input type="file" name="thumbnailFile">
	</p>
	
	<p class="reviewImage">
		<span class="columnName">현재 리뷰이미지</span>
		<img src="${cpath }/upload/${dto.reviewImage}" width="80px">
	</p>
		<input type="text" name="reviewImage" value="${dto.reviewImage }">
	<p>
		<span class="columnName">상세내용 이미지</span>
		<input type="file" name="reviewImageFile">
	</p>
	</fieldset>
	<p><input type="submit"></p>
</form>

</body>
</html>