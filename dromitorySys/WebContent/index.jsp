<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="jquery-ui-1.12.0.custom/jquery-ui.min.css"/>
<script type="text/javascript" src="js/jquery-3.0.0.min.js" ></script>
<script src="jquery-ui-1.12.0.custom/jquery-ui.min.js" type="text/javascript" charset="utf-8"></script>
<title>Insert title here</title>
<style>
	.table{
		width:0;
		float:left;
		margin:20px;
	}
</style>
</head>
<body>
	<h3 style="align:center">宿舍管理系统</h3>
	<input type="button"  class="btn btn-info" value="新增" id="showinfo"><br>
	<div id="info">
		<form id="frm">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th colspan="2">学员入住信息登记</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>宿舍编号：</td>
						<td><input type="text" class="form-control" name="dromitoryId" ></td>
					</tr>
					<tr>
						<td>学员姓名：</td>
						<td><input type="text" class="form-control" name="stuName" ></td>
					</tr>
					<tr>
						<td>性别：</td>
						<td>
							<label><input type="radio" name="stuSex" checked class="radio-inline" value="男"/>男</label>&nbsp;&nbsp;
				   		<label><input type="radio" name="stuSex" class="radio-inline" value="女"/>女</label>
						</td>
					</tr>
					<tr>
						<td>班级：</td>
						<td><input type="text" class="form-control" name="clsName" ></td>
					</tr>
					<tr>
						<td>床号：</td>
						<td>
						   	<select name="bedNo">
						   			<option value="1">1</option>
						   			<option value="2">2</option>
						   			<option value="3">3</option>
						   			<option value="4">4</option>
						   			<option value="5">5</option>
						   			<option value="6">6</option>
						   	</select>
				   		</td>
					</tr>
					<tr>
						<td>入住时间：</td>
						<td><input type="text" class="form-control" name="inDate" >(yyyy-MM-dd)</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<c:forEach var="d" items="${list}">
	<table class="table table-bordered">
		<tbody>
		
			<tr>
				<td>宿舍号：${d.dromitoryId}</td>
			</tr>
			<tr>
				<td>姓名：${d.stuName}</td>
			</tr>
			<tr>
				<td>性别：${d.stuSex}</td>
			</tr>
			<tr>
				<td>班级：${d.clsName}</td>
			</tr>
			<tr>
				<td>床号：${d.bedNo}</td>
			</tr>
			<tr>
				<td>入住时间：<f:formatDate value="${d.inDate}" pattern="yyyy年MM月dd日"/></td>
			</tr>
		
		</tbody>
	</table>
	</c:forEach>
</body>
<script>

	function F5(){
		location.replace(location.href);
	}
	$("#showinfo").on("click",function(){
		$("#info").dialog("open");
	});
	
	//弹框
	$("#info").dialog({
		autoOpen:false,
		modal:true,
		width:"400",
		buttons:{
			"提交":function(){
				//表单元素序列化
				var temp=$("#frm").serialize();
				$.ajax({
					url:"/dromitorySys/add.do",
					type:"post",
					data:temp,
					success:function(data){
						alert("入住信息登记成功");
						F5();
					}
				});
				$(this).dialog("close");
			},
			"取消":function(){
				$(this).dialog("close");
			}
		},
	});
</script>
</html>