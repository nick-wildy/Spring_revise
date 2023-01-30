<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#root {
		max-width: 1200px;
		margin: auto;
	}
	.item {
		border: 1px solid black;
		padding: 10px;
	}
	.MAIN_IMG_THUMB, .MAIN_IMG_NORMAL {
		display: none;
	}
</style>
</head>
<body>

<h1>부산축제정보</h1>

<div id="root"></div>

<script src="${cpath }/resources/js/function.js"></script>
<script>
	
	async function loadHandler() {
		const root = document.getElementById('root')
		const dataList = await getDataList()
		console.log(dataList)
	}
	document.body.onload = loadHandler
</script>

</body>
</html>





