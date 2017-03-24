<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
<script type="text/javascript" src="js/jquery-3.0.0.min.js" ></script>
<title>Insert title here</title>
<style>
	body{
		margin:auto 0;
	}
	.table{
		width:500px;
		margin:auto 0;
	}
	.btn{
		margin-left:100px;
	}
</style>
</head>
<body>
	<h4 style="text-align:right;">--捐出一点爱心托起一片天空<h4>
	<form action="Add.do" method="post">
		<table class="table table-bordered">
			<thead>
				<tr>
				   <th colspan="2" style="text-align:right">中华慈善捐款登记</th>
				</tr>
			</thead>
			<tbody>
				<tr>
				   <td>姓名：</td>
				   <td><input type="text" name="lname" class="form-control"/></td>
				</tr>
				<tr>
				   <td>性别：</td>
				   <td>
				   		<label><input type="radio" name="lsex" checked class="radio-inline" value="男"/>男</label>&nbsp;&nbsp;
				   		<label><input type="radio" name="lsex" class="radio-inline" value="女"/>女</label>
				   </td>
				</tr>
				<tr>
				   <td>捐款日期：</td>
				   <td><input type="text" name="ltime" class="form-control"/>（yyyy-mm-dd）</td>
				</tr>
				<tr>
				   <td>捐款金额：</td>
				   <td><input type="text" name="lmoney" class="form-control"/>（元）</td>
				</tr>
				<tr>
				   <td colspan="2">
					   <input type="submit" value="提交" class="btn btn-info">&nbsp;&nbsp;
					   <input type="reset" class="btn btn-info">
				   </td>
				</tr>
			 </tbody>
		</table>
	</form>
</body>

</html>