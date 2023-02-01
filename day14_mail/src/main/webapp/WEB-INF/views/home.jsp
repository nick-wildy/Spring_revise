<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day14 - mail</title>
</head>
<body>

<h1>메일 보내기</h1>
<hr>

<ul>
	<li><a href="${cpath }/ex01">ex01 - 자기 주소에 메일 보내기</a></li>
	<li><a href="${cpath }/ex02">ex02 - 인증번호 보내고 확인받기</a></li>
	<li><a href="${cpath }/ex03">ex03 - javascript, in / of</a></li>
</ul>

<details>
	<summary>메일 보내기에 필요한 사전 정보</summary>
	<fieldset>
		<ol>
			<li>
				컴퓨터 네트워크 통신은 대부분 port 라고 하는 특정 채널을 통해서 데이터를 주고받는다
				<p>
					HTTP: TCP/80, SFTP : TCP/22, DNS : UDP/53 (TCP도 사용함)<br>
					메일을 주고 받는 통신은 SMTP방식으로 사용하며, 포트번호를 확인해야 한다<br>
					Simple Mail Transfer Protocol
				</p>
			</li>
			
			<li>
				HTTP통신에서 특정 메서드만 request의 body를 가질 수 있다
				<p>
					GET : 응답을 받는것이 목적이다. body를 가지지 않는다 (queryString)<br>
					POST : 데이터를 전송하여 서버에 적재하는것이 목적이다. body를 가질 수 있다<br>
					PUT : 데이터를 전송하여 기존 데이터를 새로운 데이터로 교체하는것이 목적이다. body를 가질 수 있다<br>
					PATCH : 데이터를 전송하여 기존 데이터의 일부를 수정하는것이 목적이다. body를 가질 수 있다<br>
					DELETE : 서버의 특정 데이터를 삭제하는것이 목적이다. body를 가지지 않는다 (queryString)<br>
				</p>				
			</li>
		</ol>
	</fieldset>
</details>

</body>
</html>




