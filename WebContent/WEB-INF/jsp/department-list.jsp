<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门列表</title>
</head>
<body>
	<table>
		<tr><td>部门名</td><td>上级部门</td><td>操作</td></tr>
		<c:forEach items="${departments}" var="dep">
			<tr><td>${dep.name}</td>
			<td>${dep.parentName}</td>
			<td><a href="${contextPath}/departments/${dep.id}/edit">修改</a></td></tr>
		</c:forEach>
	</table>
</body>
</html>