<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>博客详情</title>
</head>
<body>
	<h3>博客详情</h3>
	博客名: ${blog.title}
	作者: <a href="/authors/${blog.author.id}">${blog.author.name}</a>
	<div>
		文章列表
		<c:forEach items="${blog.posts}" var="post">
			<div>
				<h4>${post.title}</h4>
				<div>${post.content}</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>