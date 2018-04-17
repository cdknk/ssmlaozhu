<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户详情</title>
</head>
<body>
	<h3>客户详情</h3>
	<div>
		姓名：${customer.name} <br>
		地址：${customer.address} <br>
		VIP：${customer.vip ? '是' : '否'}
	</div>
</body>
</html>