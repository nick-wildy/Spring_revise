<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<h3>게시판 목록</h3>

<div class="wrap">
	<table id="boardList">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
			</tr>
		</thead>
		
		<tbody>
		<c:forEach var="dto" items="${list }">
		<tr>
			<td>${dto.idx }</td>
			<td><a href="${cpath }/board/view/${dto.idx}">${dto.title }</a></td>
			<td>${dto.writer }</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<div class="pageNumber">
	<c:forEach var="i" begin="1" end="${pageCount }">
		<a class="${param.page == i ? 'bold' : '' }" 
		   href="${cpath }/board/list?page=${i}">[${i }]</a>
	</c:forEach>
	</div>
	
	<div class="sb">
		<div>
			<form>
				<p>
					<input type="search" name="keyword" placeholder="검색어를 입력하세요">
					<input type="submit" value="검색">
				</p>
			</form>
		</div>
		<div>
			<a href="${cpath }/board/write"><button>작성</button></a>
		</div>
	</div>
</div>







</body>
</html>