<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h3>단일 보기 : ${dto.name }</h3>

<div class="detail">
	<div><h4>제목 : ${dto.name }</h4></div>
	<div>저자 : ${dto.author }</div>
	<div>출판사 : ${dto.publisher }</div>
	<div>출판일자 : <fmt:formatDate value="${dto.publishDate }" /></div>
	<div>가격 : <fmt:formatNumber value="${dto.price }" />원</div>
	<div>평점 : ${dto.score }</div>
	<div>
		<h5>설명</h5>
		${dto.memo }
	</div>
</div>

<div class="submenu">
	<div>
		<a href="${cpath }/list"><button>목록</button></a>
	</div>
	<div>
		<a href="${cpath }/modify/${dto.idx}"><button>수정</button></a>
		<button class="deleteBtn" idx="${dto.idx }">삭제</button>
	</div>
</div>

<script>
	document.querySelector('.deleteBtn').onclick = function(event) {
		const idx = '${dto.idx}'
		const name = '${dto.name}'
		const flag = confirm('[' + name + '] 도서를 삭제하시겠습니까?')
		if(flag) {
			location.href = '${cpath}/delete/' + idx
		}
	}
</script>


<body>

</body>
</html>