<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<script>
	// JSP의 요소를 자바스크립트로 넘겨야 할때 사용할 변수들
	const cpath = '${cpath}'
	const board_idx = '${dto.idx}'
	const login_userid = '${login.userid}'
</script>
<script src="${cpath }/resources/js/script.js"></script>
<h3>게시글 읽기</h3>

<div class="wrap">

<table id="view">
	<tr>
		<td>${dto.idx } : ${dto.title }</td>
		<td>조회수 : ${dto.viewCount }</td>
	</tr>
	<tr>
		<td>작성자 : ${dto.writer }</td>
		<td>IP : ${dto.ipaddr }</td>
	</tr>
	<tr>
		<td colspan="2">
<pre>${dto.content }</pre>
		</td>
	</tr>
	<tr>
		<th colspan="2">
		
		<form id="replyWriteForm">
			<p>
				<textarea name="content" 
					   	  placeholder="${empty login ? '로그인 이후 작성 가능합니다' : '바르고 고운 말을 사용합시다' }" 
					   	  ${empty login ? 'readonly' : '' }></textarea>
				<button>작성</button>
			</p>
		</form>
		
		<div id="reply">
			<img src="${cpath }/resources/image/loading.gif" 
				 height="50"
			     style="margin: 100px auto">
		</div>
		</th>
	</tr>
</table>

<div class="sb">
	<div>
		<a href="${cpath }/board/list"><button>목록</button></a>
	</div>
	<div>
		<a href="${cpath }/board/modify/${dto.idx}"><button>수정</button></a>
		<a href="${cpath }/board/delete/${dto.idx}"><button>삭제</button></a>
	</div>
</div>
</div>

<script>
	const replyWriteForm = document.getElementById('replyWriteForm')
	
	// textarea에 포커스가 잡히면 실행하는 함수
	document.querySelector('textarea').onfocus = function (event) {
		if(login_userid == '') {			// 로그인이 안되어 있으면
			const move = confirm('댓글을 쓰려면 로그인해야합니다. 로그인하시겠습니까?')	// 물어보고
			event.target.blur()				// 일단 포커스를 해제한 다음
			
			if(move) {	// 이동하겠다라고 하면 이동시킨다
				const url = cpath + '/member/login?url=' + location.href
				location.href = url
			}
		}
	}
	document.body.onload = replyLoadHandler
	replyWriteForm.onsubmit = replyWriteHandler
	
	
</script>

</body>
</html>