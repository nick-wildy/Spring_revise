<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h3>대문 페이지</h3>

<details>
	<summary>게시판 사용한 SQL</summary>
<fieldset>
<pre>
drop table board2;
drop sequence board2_seq;

create sequence board2
    start with 1
    maxvalue 999999999
    increment by 1
    nocache
    nocycle;

create table board2 (
    idx			number			default board2_seq.nextval primary key,
    writer		varchar2(100)	not null,
    title		varchar2(100)	not null,
    content 	varchar2(2000)	not null,
    writeDate	date			default sysdate,
    ipaddr		varchar2(30)	not null,
    viewCount	number			default 0,
    uploadFile	varchar2(255)	,

    constraint fk_board2_member5
    foreign key (writer)
    references member5(userid)
    on delete cascade
);

select * from board2 order by idx desc;
select * from member5;

insert into board2 (writer, title, content, ipaddr) values ('test2', '안녕하세요', '내용1', '1.1.1.1');
insert into board2 (writer, title, content, ipaddr) values ('test2', '안녕하세요2', '내용2', '2.2.2.2');
insert into board2 (writer, title, content, ipaddr) values ('test2', '안녕하세요3', '내용3', '3.3.3.3');
insert into board2 (writer, title, content, ipaddr) values ('test2', '안녕하세요4', '내용4', '4.4.4.4');

insert into board2 (writer, title, content, ipaddr) 
    select writer, title, content from board1;

select count(*) from board2;

delete board1 where idx > 256;

commit;
</pre>
</fieldset>
</details>

<details>
	<summary>댓글 사용한 SQL</summary>
	
<fieldset>
<pre>
-- 깊이 개념이 없는 단순 댓글

drop table reply1;
drop sequence reply1_seq;

create sequence reply1_seq 
    start with 1
    maxvalue 99999
    increment by 1
    nocache
    nocycle;

create table reply1 (
    idx         number          default reply1_seq.nextval primary key,
    board_idx   number          ,
    writer      varchar2(100)   ,
    content     varchar2(4000)  not null,
    writeDate   date            default sysdate,
    
    constraint reply1_board2
    foreign key(board_idx)
    REFERENCES board2(idx)
    on delete set null,
    
    constraint reply1_member5
    foreign key(writer)
    REFERENCES member5(userid)
    on delete set null
);

insert into reply1 values (
    reply1_seq.nextval, 256, 'test4', '댓글1', sysdate
);
insert into reply1 values (
    reply1_seq.nextval, 256, 'test3', '댓글2', sysdate
);
insert into reply1 values (
    reply1_seq.nextval, 256, 'test2', '댓글3', sysdate
);
insert into reply1 values (
    reply1_seq.nextval, 255, 'test3', '댓글4', sysdate
);
commit;
select * from reply1 where board_idx=254;
select * from reply1;

</pre>
</fieldset>
</details>




</body>
</html>