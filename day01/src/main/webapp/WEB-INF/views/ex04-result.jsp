<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h3>
	${user.name }의 나이는
	${user.age }살이고,
	${user.age >= 20 ? '성인' : '미성년자' }입니다	
</h3>

<h3>
	${test.name }의 나이는
	${test.age }살이고,
	${test.age >= 20 ? '성인' : '미성년자' }입니다	
</h3>

</body>
</html>