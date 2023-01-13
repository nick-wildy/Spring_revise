<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div class="modifyForm">

	<form method="POST">
	<p>회원번호<input type="number" name="idx" value="${login.idx }" readonly></p>
	<p>아이디<input type="text" name="userid" value="${login.userid }" readonly></p>
	<p>비밀번호<input type="password" name="userpw" placeholder="Password 입력 필수" required></p>
	<p>이름<input type="text" name="username" value="${login.username }" placeholder="Name" required></p>
	<p>생일<input type="date" name="birth" value="${login.birth }" required></p>
	<p>성별
		<label><input type="radio" name="gender" value="남성" ${login.gender == '남성' ? 'checked' : '' }>남성</label>
		<label><input type="radio" name="gender" value="여성" ${login.gender == '여성' ? 'checked' : '' }>여성</label>
	</p>
	<p><input type="submit" value="수정하기"></p>
</form>
</div>

</body>
</html>