<%@page import="entity.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
	body{
		margin:0 auto;
	}
	table{
		margin:0 auto;
		font-size:20px;
		width:400px;
	}
	input[type="button"]{
		width:100px;
		height:30px;
		font-size:15px;
		margin-left:150px;
	}
	table tr:nth-child(2n){
		background-color:#F7E78C;
	}
	table tr:last-child{
		background-color:#FFF;
	}
</style>
<body>
	<%
		List<Employee> list=(List<Employee>)request.getAttribute("list");
		if(list==null){
			response.sendRedirect("/EmployeeManager/EmployeeList.do");
			return ;
		}
	%>
	<table border="1" cellpadding="1" cellspacing="1">
		<tr>
			<td>编号</td>
			<td>名称</td>
			<td>年龄</td>
			<td>性别</td>
			<td>Eamil</td>
		</tr>
		<% for (Employee e:list){%>
			<tr>
			<td><%=e.getEid() %></td>
			<td><%=e.getEname() %></td>
			<td><%=e.getEage() %></td>
			<td><%=(e.getEsex()==1)?"男":"女" %></td>
			<td><%=e.getEemail()%></td>
		</tr>	
		<%}%>
		
		<tr>
			<td colspan="5"><a href="addEmployee.jsp"><input type="button" value="添加员工"></a></td>
		</tr>
	</table>
</body>
</html>