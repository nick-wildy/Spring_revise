<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex02 - 인증번호</title>
<style>
	.hidden {
		display: none;
	}
	#check {
		margin-top: 20px;
	}
</style>
</head>
<body>

<h1>인증번호 보내고 확인하기</h1>
<hr>

<fieldset id="send">
	<form id="sendForm">
		<p>
			<input type="email" name="email" placeholder="이메일을 입력하세요">
			<input type="submit" value="인증 번호 발송">
		</p>
	</form>
</fieldset>

<fieldset id="check" class="hidden">
	<form id="checkForm">
		<p>
			<input type="text" name="authNumber" placeholder="인증번호를 입력하세요">
			<input type="submit" value="인증">
		</p>
	</form>
</fieldset>

<p class="next hidden">
	<a href="${cpath }"><button>다음 (home으로 이동)</button></a>
</p>

<script>
	// HTML 태그 중에서도 form 태그는 특수한 태그이므로, 별도로 관리하는 문법이 있다
	const sendForm = document.forms[0]
	const checkForm = document.forms[1]
	const check = document.getElementById('check')
	
	sendForm.onsubmit = function(event) {
		event.preventDefault()
		const email = document.querySelector('input[name="email"]').value
		const url = '${cpath}/sendAuthNumber'
		
		fetch(url + '?email=' + email)
		.then(resp => resp.text())
		.then(text => {
			if(text == 1) {
				check.classList.remove('hidden')
				alert('인증번호가 발송되었습니다. 메일을 확인해주세요')
			}
		})
		.catch(ex => { 		// fetch() 에서 예외발생시 실행되는 구문	
			console.log(ex)
		})	
	}
</script>

<script>
	// 만약 메서드를 POST로 지정하여 데이터를 전송하고 싶다면
	checkForm.onsubmit = function(event) {
		event.preventDefault()
		
// 		const formData = new FormData(event.target)
// 		const ob = {}
// 		for(let key of formData.keys()) {
// 			ob[key] = formData.get(key)
// 		}
// 		ob.email = document.querySelector('input[name="email"]').value
		
		const ob = {
			email: document.querySelector('input[name="email"]').value,
			authNumber: document.querySelector('input[name="authNumber"]').value,
		}
		
		const url = '${cpath}/sendAuthNumber'
		const opt = {
			method: 'POST',
			body: JSON.stringify(ob),	// JSON형식 문자열로 변환하여 전달
			headers: {
				'Content-Type': 'application/json; charset=utf-8'
			}
		}
		
		fetch(url, opt)
		.then(resp => resp.text())
		.then(text => {
			if(text == 1) {
				alert('인증이 완료되었습니다')
				document.querySelector('.next').classList.remove('hidden')
			}
			else {
				alert('인증번호가 일치하지 않습니다. 다시 확인해주세요')
			}
		})
	}
</script>



</body>
</html>