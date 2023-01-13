<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div class="boardDetail">
	<div class="board_title">
		<h3>${dto.title }</h3>
	</div>
	<div class="board_body">
		<div class="board_img">
			<img src="${cpath }/upload/${dto.fileName}">
			<h3>파일이름${dto.fileName}</h3>
		</div>
		<textarea rows="20" cols="50">${dto.content }</textarea>
	</div>
	<aside>
	<div class="nav1">
	작성자: ${dto.writer }
	</div>
	<div class="nav2">
	작성자: ${dto.ipaddr }
	</div>
	<div class="nav3">
	조회수 : ${dto.viewCount }
	</div>
	</aside>
	
	<c:if test="${dto.writer ==login.userid }">
	<div class="board_footer">
		<a href="${cpath }/board/modify/${dto.idx}"><button>수정하기</button></a>
		<a href="${cpath }/board/delete/${dto.idx}"><button onclick="delete_content()">삭제하기</button></a>
	</div>
	</c:if>
</div>

<script>
function delete_content() {
	if(confirm('삭제하시겠습니까?')){
		location='${cpath}/board/delete'
	}
}
</script>

</body>
</html>