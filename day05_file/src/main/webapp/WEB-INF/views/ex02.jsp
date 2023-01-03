<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>
<%@ include file="header.jsp" %>

<h3>MultipartFile를 이용한 파일 업로드</h3>

<form method="POST" enctype="multipart/form-data">
	<p><input type="file" name="uploadFile"></p>
	<p><input type="submit"></p>
</form>

</body>
</html>