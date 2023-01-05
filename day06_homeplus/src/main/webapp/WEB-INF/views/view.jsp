<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div class="view">
	<div class="detail0">
		<div>카테고리 : ${dto.category }</div>
		<div>등록날짜 : ${dto.registDate }</div>
		<div class="je">
			<div><a href="${cpath }/modify/${dto.idx}"><button>수정</button></a></div>
			<div><button id="deleteBtn" idx="${dto.idx }">삭제</button></div>
		</div>
	</div>
	
	<div class="detail1 sb">
		<div><img src="${cpath }/upload/${dto.thumbnail}" height="416"></div>
		<div>
			<h2>${dto.productName }</h2>
			<p><fmt:formatNumber value="${dto.price }" />원</p>
			<p>${dto.score }</p>
		</div>
	</div>
	
	<div class="detail2">
		<img src="${cpath }/upload/${dto.reviewImage}">
	</div>
</div>

<script>
	const deleteBtn = document.getElementById('deleteBtn')
	deleteBtn.onclick = function(event) {
		const idx = event.target.getAttribute('idx')
		const url = '${cpath}/delete/' + idx
		const flag = confirm(idx + '번 상품을 삭제하시겠습니까?')
		if(flag) {
			location.href = url
		}
	}
</script>




</body>
</html>