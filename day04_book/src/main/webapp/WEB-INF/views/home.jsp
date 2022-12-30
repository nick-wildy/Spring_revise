<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<%--여기부터는 home.jsp --%>
<pre>
create table book3 (
	idx			number			default book3_seq.nextval primary key,
	name		varchar2(100)	not null,
	author		varchar2(100)	not null,
	publisher	varchar2(100)	not null,
	publishDate	date			not null,
	price		number			check (price between 0 and 500000)
	memo		varchar2(2000)	not null,
	score		number(4, 1)	check (score between 0 and 10)
);
</pre>

</body>
</html>








