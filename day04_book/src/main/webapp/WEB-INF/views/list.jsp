<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div class="search">
	<form method="POST">
		<select name="type">
			<option ${param.type == 'name' ? 'selected' : '' } value="name">제목으로 검색</option>
			<option ${param.type == 'publisher' ? 'selected' : '' } value="publisher">출판사로 검색</option>
		</select>
		<input type="search" name="keyword" 
			   value="${param.keyword }"
			   placeholder="검색어를 입력하세요" autofocus>
		<input type="submit" value="검색">
	</form>
</div>

<div class="list">
	<div class="wrap">
	
		<c:forEach var="dto" items="${list }">
<%-- 			<a href="${cpath }/view?idx=${dto.idx}"> --%>
			<div class="item" idx="${dto.idx }">
				<div class="name">${dto.name }</div>
				<div class="price">
					<fmt:formatNumber value="${dto.price }" />원
				</div>
				<div class="publisher">${dto.publisher }</div>
			</div>
<!-- 			</a> -->
		</c:forEach>
		
	</div>
</div>

<script>
	// 검색어가 있으면 검색어에 강조 표시하기
	const wrap = document.querySelector('.wrap')
	const keyword = document.querySelector('input[type="search"]').value
	const rep = '<span class="keyword">' + keyword + '</span>'
	
	if(keyword != '') {
		wrap.innerHTML = wrap.innerHTML.split(keyword).join(rep)
	}
</script>

<script>
	// item 요소를 클릭하면 페이지가 이동되도록
	const itemList = document.querySelectorAll('.item')
	itemList.forEach(item => {
		const idx = item.getAttribute('idx')
// 		const url = '${cpath}/view?idx=' + idx
		const url = '${cpath}/view/' + idx
		item.onclick = () => location.href = url
	})
</script>

<script>
	// 리스트를 전달받았을 때 추가 메시지가 있다면 화면에 alert으로 출력하기
	const msg = '${param.msg}'
	
	if(msg != '') {
		const process = msg.split(':')[0]
		const result = msg.split(':')[1]
		let message = ''
		
		switch(process) {
		case 'add':
			message += '추가 '
			break
		case 'modify':
			message += '수정 '
			break
		case 'delete':
			message += '삭제 '
			break
		}
		
		message += (result == 'success' ? '성공' : '실패')
		alert(message)
		location.href = '${cpath}/list'
	}
</script>



</body>
</html>










