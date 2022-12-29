<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<form method="POST">
	<p><input type="text" name="keyword" required></p>
	<p><input type="submit"></p>
</form>


<table>
	<thead>
		<tr>
			
			<th>NAME</th>		
			<th>PUBLISHER</th>		
			<th>PRICE</th>	
			<th>수정</th>
			<th>삭제</th>			
		</tr>		
	</thead>
	<tbody>
		<c:forEach var="book" items="${list }">
		<tr>
	
			<td><a href="${cpath}/detail?idx=${book.idx}">${book.name }</a></td>		
			<td>${book.publisher }</td>		
			<td>${book.price }</td>	
			<td><a href="${cpath }/modify?idx=${book.idx }">수정하기</a></td>
			<td><a href="${cpath }/delete?idx=${book.idx }">삭제하기</a></td>
		</tr>
		</c:forEach>
	</tbody>
</table>



</body>
</html>