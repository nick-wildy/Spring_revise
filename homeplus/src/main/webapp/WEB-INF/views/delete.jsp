<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<c:if test="${msg == success }">
<h1>삭제성공</h1>
</c:if>

<c:if test="${msg != success }">
<h1>삭제실패</h1>
</c:if>

</body>
</html>