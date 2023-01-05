<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<c:set var="item" value="${dto }"/>

<div class="detailWrap">
	<a href="${cpath }/delete?idx=${item.idx }"><button>삭제하기</button></a>
	<a href="${cpath }/modify?idx=${item.idx }"><button>수정하기</button></a>
	<div class="dimage">
	<img src="${cpath }/upload/${item.thumbnail }">
	<h1>${item.productName }</h1>
	<h1>${item.price }</h1>
	<h1>${item.score }</h1>
	<div class="dreview">
	<img src="${cpath }/upload/${item.reviewImage }">
	</div>
	</div>
</div>

</body>
</html>