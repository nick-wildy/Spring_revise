<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div class="boardSearch">
	
	<p><input  class="search" type="text" name="keyword" placeholder="검색어를 입력하세요"></p>
	<p><input type="submit"></p>
</div>

<div class="boardList">
	
	<table>
		<thead>
			<tr>
				<th>게시번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
				<th>IP</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="board" items="${list }">
			<tr>
				<td>${board.idx }</td>
				<td><a href="${cpath }/board/detail/${board.idx}">${board.title }</a></td>
				<td>${board.writer }</td>
				<td>${board.writeDate }</td>
				<td>${board.viewCount }</td>
				<td>${board.ipaddr }</td>
			</tr>
			</c:forEach>
		</tbody>
		
	</table>
	
</div>
<a href="${cpath }/board/write"><button>새 글작성하기</button></a>

</body>
</html>