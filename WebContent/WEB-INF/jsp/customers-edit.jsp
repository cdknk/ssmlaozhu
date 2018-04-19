<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    

<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set> 

<c:set var="title" value="${customer.id == null ? '添加客户' : '修改客户'}"></c:set> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title}</title>
	<link rel="stylesheet" href="${contextPath}/assets/css/app.css">
</head>
<body>
	<h3>${title}</h3>
	<form:form action="" method="post" commandName="customer">
		姓名 <form:input type="text" path="name" />
		<form:errors path="name" cssClass="field-error"></form:errors>
		<br>
		地址 <form:input type="text" path="address" />
		<form:errors path="address" cssClass="field-error"></form:errors>
		<br>
		VIP 是<form:radiobutton path="vip" value="true" />
		            否<form:radiobutton path="vip" value="false" />
		<form:errors path="vip" cssClass="field-error"></form:errors>          
		<br>
		<button type="submit">提交</button>
	</form:form>
</body>
</html>