<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<table>
		<thead>
		<tr>
			<th>인덱스</th>
			<th>아이디</th>
			<th>비번</th>
			<th>이름</th>
			<th>생일</th>
			<th>성별</th>
		</tr>
		</thead>
		<tbody>
			<c:forEach var="dto" items="${list }">
			<tr>
			<td>${dto.idx }</td>
			<td>${dto.userid }</td>
			<td>${dto.userpw }</td>
			<td>${dto.username }</td>
			<td>${dto.birth }</td>
			<td>${dto.gender }</td>
			
			</tr>
			</c:forEach>
		</tbody>
	
</table>

</body>
</html>