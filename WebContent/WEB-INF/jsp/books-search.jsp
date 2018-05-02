<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书检索</title>
</head>
<body>
	<h3>图书检索</h3>
	<form method="get" action="">
		书名: <input type="text" name="bookTitle" value="${bookSearch.bookTitle}"> <br>
		作者: <input type="text" name="bookAuthor" value="${bookSearch.bookAuthor}"> <br>
		出版社: <input type="text" name="publisher" value="${bookSearch.publisher}"> <br>
		<button type="submit">搜索</button>
	</form>
	
	<div>	
		<c:forEach var="book" items="${books}">
			<div>
				<h4>${book.title}</h4>
				<div>${book.author} | ${book.publisher}</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>