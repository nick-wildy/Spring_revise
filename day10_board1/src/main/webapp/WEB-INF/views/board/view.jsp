<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<h3>게시글 읽기</h3>

<div class="wrap">

<table>
	<tr>
		<td>${dto.idx } : ${dto.title }</td>
	</tr>
	<tr>
		<td>작성자 : ${dto.writer }</td>
	</tr>
	<tr>
		<td>
<pre>${dto.content }</pre>
		</td>
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


</body>
</html>