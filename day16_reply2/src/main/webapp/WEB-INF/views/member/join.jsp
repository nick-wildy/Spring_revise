<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<h3>회원가입 페이지</h3>


<form method="POST">
	<fieldset>
	<textarea class="agreement">${agreement }</textarea>
	<p>
		<label>
			필수 약관을 모두 읽었으며, 이에 동의합니다
			<input type="checkbox" name="agreement" disabled required>
		</label>
	</p>
	</fieldset>

	<p>
		<input type="text" name="userid" placeholder="ID" autocomplete="off" required autofocus >
		<input type="button" name="dupCheck" value="중복체크"><br>
		<span class="dupResult"></span>
	</p>
	<p><input type="password" name="userpw" placeholder="Password" required></p>
	<p><input type="text" name="username" placeholder="Name" required></p>
	<p><input type="date" name="birth" required></p>
	<p>
		<label><input type="radio" name="gender" value="남성" required>남성</label>
		<label><input type="radio" name="gender" value="여성" required>여성</label>
	</p>
	<p><input type="submit" value="가입"></p>
</form>

<script>
	// 스프링의 특정 주소로 요청하여 결과를 받고, 결과에 따라서 다른 메시지를 만들어내는 자바스크립트 (AJAX)
	
	const dupCheck = document.querySelector('input[name="dupCheck"]')
	const dupResult = document.querySelector('span.dupResult')
	
	dupCheck.onclick = function(event) {
		const inputId = document.querySelector('input[name="userid"]').value
		const url = '${cpath}/member/dupCheck/' + inputId
		
		fetch(url)					// url로 요청하여 (RestController -> Service -> DAO -> myBatis)
		.then(resp => resp.text())	// 응답(1:이미 사용중인 ID입니다)이 돌아오면, 응답을 문자열로 처리하여
		.then(text => {				// 문자열을 이용하여 다음 코드를 진행합니다
			
			const code = text.split(':')[0]		// 1:사용중, 0:중복없음 
			const result = text.split(':')[1]
			dupResult.innerText = result
			
			dupResult.style.color = (code == 1) ? 'red' : 'blue'
		})
	}
</script>

<script>
	// 스프링과 상관없이 단독으로 실행되는 자바스크립트
	
	const agreement = document.querySelector('textarea.agreement')
	const checkbox = document.querySelector('input[name="agreement"]')
	
	agreement.onscroll = function() {
		const scrollTop = agreement.scrollTop
		const scrollHeight = agreement.scrollHeight
// 		console.log(scrollTop, scrollHeight)
		
		if(scrollTop >= scrollHeight * 0.9) {
			checkbox.removeAttribute('disabled')
		}
	}
</script>

</body>
</html>