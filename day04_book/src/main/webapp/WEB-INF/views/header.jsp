<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day04 - book</title>
<style>
	.wrap {
		display: flex;
		flex-flow: wrap;
		width: 800px;
		margin: auto;
		background-color: #eee;
	}
	.wrap > .item {
		border: 2px solid grey;
		padding: 10px;
		margin: 10px;
		width: 220px;
		cursor: pointer;
	}
	.wrap > .item:hover {
		background-color: white;
	}
	
	.search {
		width: 800px;
		margin: auto;
		padding: 20px;
	}
	.search form {
		display: flex;
	}
	.search select,
	.search input {
		margin: 10px;
		padding: 10px;
		height: 40px;
	}
	
	textarea {
		resize: none;
		width: 177px;
		height: 60px;
	}
	label > span {
		color: #999;
		font-size: 14px;
	}
	
	.detail > div {
		width: 500px;
		word-break: keep-all;
	}
	
	.submenu {
		margin: 20px 0;
		width: 500px;
		display: flex;
		justify-content: space-between;
	}
	
	span.keyword {
		color: blue;
		font-weight: bold;
	}
</style>
</head>
<body>

<h1><a href="${cpath }">day04 - book</a></h1>
<nav>
	<ul>
		<li><a href="${cpath }/list">목록(검색 포함, 제목으로 검색, 단일 보기 메뉴 구현하기)</a></li>
		<li><a href="${cpath }/add">추가</a></li>
	</ul>
</nav>
<%--
		기능			주소		메서드		함수						응답
		==============================================================================
		대문			/					home()
		
		목록			/list	GET			list()					"list"
					목록에서는 책의 이름과 가격, 출판사만 표기합니다
		
		검색			/list	POST		search(String search)	"list"
		
		추가			/add	GET			add()					"add"
					/add	POST		add(BookDTO dto)		"redirect:/list"
		
		단일보기
					단일보기에서는 책의 모든 내용을 한 화면에 출력합니다
		수정
		삭제
 --%>
<%--여기까지는 header.jsp --%>

</body>
</html>