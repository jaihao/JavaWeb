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
</head>
<body>
	<h4>中华爱心捐款查询系统<h4><a href="AddLove.jsp">添加新捐款</a>
	<table class="table table-bordered">
		<thead>
			<tr>
			   <th>编号</th>
			   <th>姓名</th>
			   <th>性别</th>
			   <th>捐款金额(元)</th>
			   <th>日期</th>
			</tr>
		</thead>
	 	<tbody>
	 	<c:forEach var ="l" items="${list}">
	 		<tr>
			   <td>${l.lid}</td>
			   <td>${l.lname}</td>
			   <td>${l.lsex}</td>
			   <td>${l.lmoney}</td>
			   <td><f:formatDate value="${l.ltime}" pattern="yyyy-MM-dd"></f:formatDate></td>
			</tr>
	 	</c:forEach>
	 	</tbody>
	</table>
</body>
<c:if test="${msg!=null}">
	<script type="text/javascript">
		alert("${msg}");
	</script>
	<c:remove var="msg"/>
</c:if>
</html>