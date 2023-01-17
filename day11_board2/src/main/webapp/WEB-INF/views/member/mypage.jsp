<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<h3>마이페이지</h3>

<div class="wrap">
	<table id="mypage">
		<tr>
			<td>userid</td>
			<td>${login.userid }</td>
		</tr>
		<tr>
			<td>username</td>
			<td>${login.username }</td>
		</tr>
		<tr>
			<td>birth</td>
			<td>${login.birth }</td>
		</tr>
		<tr>
			<td>gender</td>
			<td>${login.gender }</td>
		</tr>
	</table>
	<div class="sb">
		<div>
			<a href="${cpath }/member/modify"><button>수정</button></a>
		</div>
		<div>
			<button id="withdraw">탈퇴</button>
		</div>
	</div>
</div>

<script>
	const withdraw = document.getElementById('withdraw')
	withdraw.onclick = function(event) {
		const promptText = '정말 탈퇴하시겠습니까?\n탈퇴를 원하시면 [지금탈퇴] 라고 입력하세요'
		const inputText = prompt(promptText)
		
		if(inputText == '지금탈퇴') {
			location.href = '${cpath}/member/withdraw'
		}
	}
	
</script>



</body>
</html>