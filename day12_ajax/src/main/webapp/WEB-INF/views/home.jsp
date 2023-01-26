<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day12_ajax</title>
</head>
<body>

<h1>day12_ajax</h1>
<hr>

<fieldset>
	<h3>AJAX</h3>
	<p>
		Asynchronous Javascript And XML<br>
		자바스크립트와 XML을 활용한 비동기 통신<br>
		현재는 XML대신 JSON을 더 많이 활용한다
	</p>
	<p>
		AJAX를 이용한 요청(request)은 브라우저가 보내는것이 아니라,
		자바스크립트 함수에 의해서 발생하는 요청이다<br>
		브라우저 개발자 도구의 네트워크 탭에서 XHR/Fetch 항목을 선택하면 확인할 수 있다
	</p>
</fieldset>

<ul>
	<li><a href="ex01">ex01 - 일반 요청</a></li>
	<li>
		<button id="btn01">ex01 - ajax 요청</button>
		<span id="result01"></span>
	</li>
	<li>
		<button id="btn02">ex02 - ajax(GET) 요청</button>
		<span id="result02"></span>
	</li>
	<li>
		<button id="btn03">ex02 - ajax(POST) 요청</button>
		<span id="result03"></span>
	</li>
	<li>
		<button id="btn04">ex04 - 객체 목록 받아오기</button>
	</li>
</ul>

<fieldset>
 	<div id="root"></div>
</fieldset>

<script>
	const btn01 = document.getElementById('btn01')
	const result01 = document.getElementById('result01')
	
	function ajaxHandler01() {
		const url = '${cpath}/ex01'
		const opt = {
			method: 'GET'
		}
		
		fetch(url, opt)				// 주소와 옵션으로 요청을 전송하면
		.then(resp => resp.text())	// 응답을 받아서, 응답을 text로 변환하고
		.then(text => {				// text를 이용하여 코드를 수행한다  
			result01.innerText = text	// span 태그의 innerText로 받은 문자열을 넣어준다
		})
	}
	
	btn01.onclick = ajaxHandler01
	
</script>

<script>
	const btn02 = document.getElementById('btn02')
	const btn03 = document.getElementById('btn03')
	const span02 = document.getElementById('result02')
	const span03 = document.getElementById('result03')
	
	btn02.onclick = function() {		// fetch를 호출할때 opt을 생략하면 GET으로 처리한다
		const url = '${cpath}/ex02'
		fetch(url)
		.then(resp => resp.text())
		.then(text => alert(text))
	}
	
	btn03.onclick = function() {
		const url = '${cpath}/ex02'
		const opt = {				// POST, PUT, PATCH, DELETE 메서드는 opt를 지정해야 한다
			method: 'POST'
		}
		fetch(url, opt)
		.then(resp => resp.text())
		.then(text => span03.innerText = text)
	}
	
</script>

<script>
	const btn04 = document.getElementById('btn04')
	const root = document.getElementById('root')
	
	btn04.onclick = function() {
		const url = '${cpath}/ex04'
		fetch(url)
		.then(resp => resp.json())
		.then(json => {
			
			json.forEach(dto => {
				const item = document.createElement('div')
				item.classList.add('item')
				
				const name = document.createElement('span')
				name.classList.add('name')
				name.innerText = dto.name
				
				const age = document.createElement('span')
				age.classList.add('age')
				age.innerText = dto.age + '살'
				
				item.appendChild(name)
				item.appendChild(age)
				root.appendChild(item)
			})
		})
	}
</script>

</body>
</html>







