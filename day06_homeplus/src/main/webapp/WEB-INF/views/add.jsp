<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h3>상품 추가</h3>

<form method="POST" enctype="multipart/form-data">
	<fieldset>
	<p>
		<span class="columnName">카테고리</span>
		<select name="category" required>
			<option value="">== 카테고리를 선택하세요 ==</option>
			<option value="사과">사과</option>
			<option value="배">배</option>
		</select>
	</p>
	<p>
		<span class="columnName">상품이름</span>
		<input type="text" name="productName" placeholder="청주 사과 5Kg" required>
	</p>
	<p>
		<span class="columnName">가격</span>
		<input type="number" name="price" min="0" max="500000" placeholder="29500" required>
	</p>
	<p>
		<span class="columnName">상품이름</span>
		<input type="number" name="score" min="0" max="5" step="0.1" placeholder="4.5" required>
	</p>
	<p>
		<span class="columnName">썸네일 이미지</span>
		<input type="file" name="thumbnailFile" required>
	</p>
	<p><span class="columnName">상세내용 이미지</span>
		<input type="file" name="reviewImageFile" required>
	</p>
	</fieldset>
	<p><input type="submit"></p>
</form>

</body>
</html>