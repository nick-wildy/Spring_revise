<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<form method="POST">
<p><input type="text" name="keyword" placeholder="이름"></p>
<p><input type="submit"></p>
</form>

<table>
	<thead>
		<tr>
			<th>이미지</th>
			<th>제목</th>
			<th>금액</th>
			<th>별점</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="item" items="${list }">
		<tr>
		<td><a href="${cpath }/detail?idx=${item.idx }"><img src="${cpath }/upload/${item.thumbnail}"></a></td>
		<td>${item.productName }</td>
		<td>${item.price }</td>
		<td>${item.score }</td>
		
		</tr>
	</c:forEach>
	</tbody>
</table>



</body>
</html>