use master
GO
if DB_ID('EmployeeDB') is not null
	drop database EmployeeDB
GO
create database EmployeeDB
GO
use EmployeeDB
GO
if OBJECT_ID('Employee') is not null
	drop table Employee
GO
use EmployeeDB
create  table Employee
(
	eid int identity(1,1) primary key ,--	���	int		����	����
	ename	varchar (50) not null,--Ա������	varchar	50		�ǿ�
	eage	int check(eage>0 and eage<150),--Ա������	int			0-150
	esex	int, --Ա���Ա�	int			0:Ů1:��
	eemail	varchar(200)--Ա������	varchar	50		
	
)
select * from Employee
insert Employee(eid,ename,eage,eage,esex,eemail)
insert Employee values
		('javck',23,'1','xiaohua@163.com'),
		('join',22,'1','join@163.com'),
		('xiaoyang',22,'0','xiaoyang@163.com'),
		('Lcuy',23,'0','lucy@163.com')