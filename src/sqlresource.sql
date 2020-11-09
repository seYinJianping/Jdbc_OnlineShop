show databases ;
create database onlineShop;
show tables from onlineShop;
use onlineShop;
create table staff(
    Number int primary key ,
    Name varchar(20),
    Department varchar(20),
    Level varchar(20)
)engine = innodb default charset utf8;

insert into staff (number, name, department, level) VALUES (1001,'向华强','采购部','部门经理');

select *
from staff;

create table user(
    UserId int(5) primary key auto_increment,
    UserName varchar(10) unique ,
    UserPassword varchar(10)
)engine = innodb default charset utf8;

insert into user(UserName, UserPassword) VALUES ('Jimmy','jimmy'),('Tom','tom'),('Intel','intel');

select *from user;

delete from user where UserName = 'Tom';

insert into user (UserName, UserPassword)
values ('a','a');

drop table items;
create table items(
    ItemId int(5) primary key auto_increment,
    ItemName varchar(20) unique ,
    ItemBrand varchar(20),
    ItemPrice int(5),
    ItemSupplier varchar(20),
    ItemStock int(5),
    ItemPic varchar(500)
)engine = innodb default charset utf8;

insert into items (ItemName, ItemBrand, ItemPrice, ItemSupplier, ItemStock,ItemPic)
values ('iPhone 11','Apple',5999,'苹果中国',50,'src/pic/iPhone12.JPG'),
       ('iPhone 12','Apple',7999,'苹果中国',30,'src/pic/iPhone12.JPG'),
       ('Mate 40','HUAWEI',3999,'华为',5,'src/pic/iPhone12.JPG'),
       ('Reno 5','OPPO',2999,'欧普',10,'src/pic/iPhone12.JPG'),
       ('Smartisan 6','锤子',9999,'锤子科技',10,'src/pic/iPhone12.JPG');

drop table brand;
create table brand(
    BrandId int(5) primary key auto_increment,
    BrandName varchar(20) unique ,
    BrandSupplier varchar(20),
    BrandCharger varchar(20),
    BrandAddress varchar(20)
)engine = innodb charset utf8;

insert into brand(BrandName, BrandSupplier,BrandCharger,BrandAddress)
VALUES ('Apple','苹果中国','Tim','富士康'),
       ('HUAWEI','华为','余大嘴','深圳'),
       ('OPPO','欧普','小绿','上海'),
       ('锤子','锤子科技','公孙永浩','成都');

select *
from brand;

create table orders(
    OrderNum int(5) primary key auto_increment,
    OrderAccount varchar(20),
    OrderName varchar(20),
    OrderTel varchar(20),
    OrderAdd varchar(20),
    OrderItemBrand varchar(20),
    OrderItemName varchar(20),
    OrderCount int(5),
    OrderBill int(10)
)engine = innodb default charset utf8;



