use mydb;
use mysql;

create table member(
	id varchar(30) primary key,
    pw varchar(20) not null,
    email varchar(50) not null,
    name varchar(10) not null,
    birth varchar(10) not null
);
drop table member;
	create table writing(
		id varchar(30) not null,
		num int auto_increment primary key, -- 글번호
        writing varchar(5000) not null,     -- 글쓰기
		date datetime default now() not null, -- 등록날짜
		looknum int not null	              -- 조회수
		);
drop table writing;
create table likes( -- 좋아요
	me_id varchar(20) not null,
    likes tinyint(0) not null,
    wr_num int not null,
    constraint fk_wr_num foreign key(wr_num) REFERENCES writing(num),
    constraint fk_me_id foreign key(me_id) REFERENCES member(id)
);

create table friend_add(
	friend_id varchar(10),
    constraint fk_fr_id foreign key(friend_id) references member(id)
);

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