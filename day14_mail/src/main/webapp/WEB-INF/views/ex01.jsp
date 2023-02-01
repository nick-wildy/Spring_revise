<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex01 - 자기 주소에 메일 보내기</title>
</head>
<body>

<h1>ex01 - 자기 주소에 메일 보내기</h1>
<hr>

<form id="form" method="GET">
	<input type="email" name="email" value="">
	<input type="text" name="content" value="">
	<input type="submit" value="전송">
</form>

<script>
	// form을 이용한 경우, submit에 대해 click이벤트를 사용하지 않는다
	// form에 대해서는 submit 이벤트를 활용한다
	
	// input.onclick = handler (X)
	// form.onsubmit = handler (O)
	
	// form은 이벤트가 발생하면 내부의 input요소들을 묶어서 action으로 전송한다
	// onsubmit 에서는 event.preventDefault() 를 첫줄에 선언하고 시작한다
	
	const form = document.getElementById('form')
	form.onsubmit = function(event) {
		event.preventDefault()
		
		const formData = new FormData(event.target)
		const ob = {}
		for(let key of formData.keys()) {
			ob[key] = formData.get(key)
		}
		console.log(ob)
		
		const url = '${cpath}/ajax01?email=' + ob.email + '&content=' + ob.content
		fetch(url)
		.then(resp => resp.text())
		.then(text => alert(text))
	}
	
</script>


</body>
</html>








