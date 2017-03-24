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
	lid	int identity(1,1) primary key,--���
	lname	varchar	(50) not null,--���������
	lsex	varchar	(50) not null ,--������Ա�	
	ltime	datetime not null,--�������	
	lmoney	money check(lmoney>0),--�����	
)
insert LoveInHeart values
	('���»�','��','2010-10-1','1000000'),
	('����','��','2011-10-1','1000'),
	('�°���','��','2012-10-1','100'),
	('������','Ů','2013-10-1','10')
	
select * from LoveInHeart order by lmoney desc

