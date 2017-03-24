<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/bigPanda.js" ></script>
</head>
<style>
	body{
		marign:0 auto;
		font-size:20px;
	}
	table{
		margin:0 auto;
		width:400px;
	}
	input[type="text"]{
		width:200px;
		height:30px;
		font-size:20px;
	}
	input[type="radio"]{
		width:20px;
		height:20px;
	}
	input[type="email"]{
		width:200px;
		height:30px;
		font-size:20px;
	}
	input[type="submit"]{
		width:100px;
		height:30px;
		font-size:15px;
		margin-left:150px;
	}
</style>
<body>
	<form action="Add.do" method="post" name="frm">
		<table border="1">
			<tr>
				<td>员工姓名</td>
				<td><input type="text" name="ename"></td>
			</tr>
			<tr>
				<td>员工年龄</td>
				<td><input type="text" name="eage"></td>
			</tr>
			<tr>
				<td>性别</td>
				<td>
					<label><input type="radio" name="esex" value="1" checked>男</label>
					<label><input type="radio" name="esex" value="0">女</label>
				</td>
			</tr>
			<tr>
				<td>员工Email</td>
				<td><input type="email" name="eemail"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="添加" id="sub"></td>
			</tr>
		</table>
	</form>
</body>
<script>
	eventBind.addEvent($("sub"), "click", function(){
		eventBind.cancelDefault();
		var ename=frm.ename.value;
		var eage=frm.eage.value;
		var eemail=frm.eemail.value;
		var age=/^\d+$/;
		if(ename==""){
			alert("名字不能为空");
			return false;
		}
		if(eage==""){
			alert("年龄不能为空");
			return false;
		}
		if(!age.test(eage)){
			alert("年龄请输入纯数字");
			return false;
		}else{
			frm.submit();
			return true;
		}
	})
</script>
</html>