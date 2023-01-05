<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>


<div id="root">
	<div class="center">
		<h2>사과/배</h2>
		<c:if test="${not empty count }">
			<p><span class="red">${count }</span>개의 상품이 있습니다</p>
		</c:if>
	</div>
	
	<div class="search">
		<form method="POST" action="${cpath }/list">
			<input type="search" name="keyword" placeholder="검색어를 입력하세요" value="${param.keyword }">
			<input type="submit" value="검색">
		</form>
	</div>
	
	<div class="top-menu">
		<ul>
			<li><a href="${cpath }/list">기본 정렬</a></li>
			<li><a href="${cpath }/list/price asc">낮은 가격순</a></li>
			<li><a href="${cpath }/list/price desc">높은 가격순</a></li>
		</ul>
	</div>



	<div class="wrap">
	<c:forEach var="dto" items="${list }">
		<div class="item">
			<div>
				<a href="${cpath }/view/${dto.idx}">
				<img src="${cpath }/upload/${dto.thumbnail}" height="208"></a>
			</div>
			<div>${dto.productName }</div>
			<div><fmt:formatNumber value="${dto.price }" />원</div>
			<div>${dto.score }</div>
		</div>
	</c:forEach>
	</div>
</div>

</body>
</html>