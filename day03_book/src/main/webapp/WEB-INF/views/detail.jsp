<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<c:set var="book" value="${dto }"/>
<table>
	<thead>
		<tr>
			<th>IDX</th>
			<th>NAME</th>
			<th>AUTHOR</th>
			<th>PUBLISHER</th>
			<th>PUBLISH_DATE</th>
			<th>PRICE</th>
			<th>MEMO</th>
			<th>SCORE</th>	
				
		</tr>		
	</thead>
	<tbody>
		
		<tr>
			<td>${book.idx }</td>
			<td>${book.name }</td>
			<td>${book.author }</td>
			<td>${book.publisher }</td>
			<td>${book.publishDate }</td>
			<td>${book.price }</td>
			<td>${book.memo }</td>
			<td>${book.score }</td>
		
		</tr>
		
	</tbody>
</table>



</body>
</html>