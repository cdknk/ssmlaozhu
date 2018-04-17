<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>客户列表</title>
	<link rel="stylesheet" href="/ssm/assets/bootstrap/css/bootstrap.min.css">
</head>
<body>
  <div class="container">
	<h3>客户列表</h3>
	<div>
		<a class="btn btn-default" href="/ssm/customers/new">添加</a>
	</div>
	<table class="table table-striped">
		<tr>
			<th>#</th><th>姓名</th><th>住址</th><th>VIP?</th><th>操作</th>
		</tr>
		
	<c:forEach var="customer" items="${customers}">
		<tr>
			<td>#${customer.id}</td>
			<td>${customer.name}</td>
			<td>${customer.address}</td>
			<td>${customer.vip ? "是" : "否"}</td>
			
			<td>
				<a class="btn btn-default btn-xs" href="/ssm/customers/${customer.id}/details">详情</a>
				<a class="btn btn-default btn-xs" href="/ssm/customers/${customer.id}/edit">修改</a>
				<form action="/ssm/customers/${customer.id}/delete" method="post"
				      style="display: inline;">
					<button type="submit" class="btn btn-danger btn-xs">删除</button>
				</form>
			</td>
		</tr>
	</c:forEach>
		
	</table>
  </div>
</body>
</html>