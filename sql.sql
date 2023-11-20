use mydb;
use mysql;

create table member(
	id varchar(30) primary key,
    pw varchar(20) not null,
    email varchar(50) not null,
    name varchar(10) not null,
    birth varchar(10) not null
);

select * from member;

insert into member values('qwe','qwe','qwe@gmail.com','정명진','2002-07-06');
drop table member;
drop table friend_add;
drop table writing;
drop table comment;
	create table writing(
		id varchar(30) not null,
		num int auto_increment primary key, -- 글번호
        writing varchar(5000) not null,     -- 글쓰기
		date datetime default now() not null, -- 등록날짜
		looknum int not null	              -- 조회수
		);
        insert into writing values();
select * from member;
select * from friend_add;
drop table likes;
drop table writing;
create table likes( -- 좋아요
	me_id varchar(20) not null,
    likes tinyint(0) not null,
    wr_num int not null
);

create table friend_add(
	member_id int not null, -- 현재 로그인중인 id
	friend_id varchar(10) -- 현재 로그인중인 id가 추가한 친구id
);
select * from friend_add where member_id = 1;
drop table friend_add;
create table profile(
    my_profile varchar(50) -- 내소개
);

create table comment(
	cm_num int,
    cm_comment varchar(500),
    constraint fk_cm_num foreign key(cm_num) references writing(num)
);


desc likes;
drop table likes;
commit;