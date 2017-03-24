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
	eid int identity(1,1) primary key ,--	编号	int		自增	主键
	ename	varchar (50) not null,--员工名称	varchar	50		非空
	eage	int check(eage>0 and eage<150),--员工年龄	int			0-150
	esex	int, --员工性别	int			0:女1:男
	eemail	varchar(200)--员工邮箱	varchar	50		
	
)
select * from Employee
insert Employee(eid,ename,eage,eage,esex,eemail)
insert Employee values
		('javck',23,'1','xiaohua@163.com'),
		('join',22,'1','join@163.com'),
		('xiaoyang',22,'0','xiaoyang@163.com'),
		('Lcuy',23,'0','lucy@163.com')