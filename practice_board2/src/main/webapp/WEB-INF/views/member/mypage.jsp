<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div class="mypageForm">

<table>
	<thead>
		<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>성별</th>
		<th>생일</th>
		</tr>
	</thead>
	<tbody>
		<tr>
		
			<td>${login.userid }</td>
			<td>${login.username }</td>
			<td>${login.gender }</td>
			<td>${login.birth }</td>
		</tr>
	</tbody>
</table>
</div>

<a href="${cpath }/member/modify"><button>수정하기</button></a>
<a href="${cpath }/member/withdraw"><button onclick="withdraw()">회원탈퇴</button></a>

 <script>
 	function withdraw() {
		if(confirm("정말 삭제하시겠습니까?")){
			location.href = '${cpath}/member/withdraw'
		}
	}
 </script>
</body>
</html>