create sequence board1_seq
    start with 1
    maxvalue 999999999
    increment by 1
    nocache
    nocycle;

create table board1 (
    idx     number          default board1_seq.nextval primary key,
    writer  varchar2(100)   not null,
    title   varchar2(100)   not null,
    content varchar2(2000)  not null
);

select * from board1 order by idx desc;
select * from member5;

insert into board1 (writer, title, content) values ('test2', '안녕하세요', '내용1');
insert into board1 (writer, title, content) values ('test2', '안녕하세요2', '내용2');
insert into board1 (writer, title, content) values ('test2', '안녕하세요3', '내용3');
insert into board1 (writer, title, content) values ('test2', '안녕하세요4', '내용4');

insert into board1 (writer, title, content) 
    select writer, title, content from board1;

select count(*) from board1;

delete board1 where idx > 215;

commit;

------------------------------------------------

select * from (
    select rownum as st, A.* from (
        select * from board1 order by idx desc
    ) A where rownum <= 220
) where st >= 211;

------------------------------------------------

select * from board1
    where title like '%안녕하세요3%'
    order by idx desc
    offset 20 rows
    fetch first 10 rows only;

