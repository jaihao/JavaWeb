use master
GO
if DB_ID('LoveDB') is not null
	drop database LoveDB
GO
create database LoveDB
GO
if OBJECT_ID('LoveInHeart') is not null
	drop table LoveInHeart
GO
use LoveDB
create table LoveInHeart
(
	lid	int identity(1,1) primary key,--编号
	lname	varchar	(50) not null,--捐款人姓名
	lsex	varchar	(50) not null ,--捐款人性别	
	ltime	datetime not null,--捐款日期	
	lmoney	money check(lmoney>0),--捐款金额	
)
insert LoveInHeart values
	('刘德华','男','2010-10-1','1000000'),
	('文文','男','2011-10-1','1000'),
	('奥巴马','男','2012-10-1','100'),
	('锅妹妹','女','2013-10-1','10')
	
select * from LoveInHeart order by lmoney desc

