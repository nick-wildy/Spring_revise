<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex04 - 시도별 실시간 평균정보 조회</title>
</head>
<body>

<h1>ex04 - 시도별 실시간 평균정보 조회</h1>
<h3>한국환경공단_에어코리아_대기오염통계 현황 (공공데이터포털)</h3>
<hr>

<div id="root"></div>

<script>
	const url = '${cpath}/air'
	fetch(url)
	.then(resp => resp.json())
	.then(json => {
		const arr = json.response.body.items.map(e => {
			return {'서울': e.seoul, '부산': e.busan, '날짜': e.dataTime}
		})
		console.log(arr)
		
	})
</script>

</body>
</html>