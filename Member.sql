
drop table if exists board;

create table member(
author varchar2(100) primary key not null,
email varchar2(200) not null,
passwd varchar2(12) not null
);

insert into member(author, email, passwd) 
values('홍길동', 'hong@naver.com', '12345');

commit;