use mydb;
use mysql;

create table member(
	member_id varchar(30) primary key not null,
    member_pw varchar(20) not null,
    member_email varchar(50) not null,
    member_name varchar(10) not null
);

create table writing(
	member_id varchar(30) primary key not null,
);

create table likes(
	member_id varchar(20),
    likes tinyint(0) not null
);
