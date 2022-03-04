--创建mydb--
drop database if exists mydb;
create database mydb;
use mydb;

--创建user表--
drop table if exists user;
create table user(
    id int(10) not null auto_increment,
    name varchar(100),
    password varchar(50),
    create_date DATE,
    primary key (id)
);

insert user(name, create_date) values ('Tom', sysdate());