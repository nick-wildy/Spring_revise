<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<pre>
create SEQUENCE member5_seq
start with 1
maxvalue 99999
INCREMENT by 1
nocache
NOCYCLE;

create table member5(
idx number default member5_seq.nextval primary key,
userid varchar2(100) unique not null,
userpw varchar2(100) not null,
username varchar2(100) not null,
birth date not null,
gender varchar2(20) check(gender in('남성', '여성'))
);
	
</pre>

<a href="${cpath }/add"><button>추가하기</button></a>

<a href="${cpath }/list"><button>리스트보기</button></a>

<a href="${cpath }/delete"><button>삭제하기</button></a>

<a href="${cpath }/update"><button>수정하기</button></a>

</body>
</html>