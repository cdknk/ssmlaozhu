<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改客户</title>
</head>
<body>
	<h3>修改客户</h3>
	<form action="" method="post">
		姓名 <input type="text" name="name" value="${customer.name}">	
		<br>
		地址 <input type="text" name="address" value="${customer.address}">
		<br>
		VIP 
		是<input type="radio" name="vip" value="true" ${customer.vip ? 'checked' : ''}>
		否<input type="radio" name="vip" value="false" ${!customer.vip ? 'checked' : ''}>
		<br>
		<button type="submit">提交</button>
	</form>
</body>
</html>