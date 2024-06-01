
drop table if exists board;

create table board(
num int primary key auto_increment,
author varchar2(100) not null,
email varchar2(200) not null,
title varchar2(500) not null,
content varchar2(4000),
passwd varchar2(12),
writeday date default curdate(),	-- 기본입력값이 현재날짜
readcnt int default 0,		-- 기본입력값이 0
rep_root int default 0,
rep_step int default 0,
rep_indent int default 0
);

--author,email,title,content,passwd
--default로 설정된 필드는 기본값으로 사용
insert into board(author,email, title, content, passwd)
values('test','test@test.com','test title','test content','testpasswd');

insert into board(author,email, title, content, passwd)
values('test2','test2@test.com','test title2','test content2','testpasswd2');

update board set readcnt=(select readcnt from board where num=2)+1 where num=2;

update board set author='HONG', email='hong@test.com', title='길동이의 글' where num=2;

select * from board;

commit;