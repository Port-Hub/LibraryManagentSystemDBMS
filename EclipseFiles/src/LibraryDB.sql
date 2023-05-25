create database Library;
use Library;

create table books (bid int, bname varchar(30));

insert into books values(101,"english"),
(102,"tamil"),(103,"maths"),
(104,"science"),(105,"social");

create table books_lent(bid int, sid int);
insert into books_lent values(101,1000),
(102,1000),
(103,1001),
(104,1002);

create table student(sid int primary key,sname varchar(20));
insert into student values(1000,'Jane'),
(1001,'Kenny'),
(1002,'Jasmine'),
(1003,'Lionel');

select * from books_lent;

select sid,count(bid) as num from Books_lent group by sid having sid=1000;