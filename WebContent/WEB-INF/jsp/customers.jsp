<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set> 
 
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>客户列表</title>
	<link rel="stylesheet" href="${contextPath}/assets/bootstrap/css/bootstrap.min.css">
</head>
<body>
  <div class="container">
	<h3>客户列表</h3>
	<div>
		<a class="btn btn-default" href="${contextPath}/customers/new">添加</a>
		
		<button type="button" class="btn btn-danger" id="batch-delete-btn">删除</button>
		<form action="${contextPath}/customers/batch-delete" method="post" style="display: none;" id="batch-delete-form">
			<input type="hidden" name="ids">
		</form>
	</div>
	<table class="table table-striped">
		<tr>
			<th></th><th>#</th><th>姓名</th><th>住址</th><th>VIP?</th><th>操作</th>
		</tr>
		
	<c:forEach var="customer" items="${customers}">
		<tr>
			<td><input type="checkbox" data-customer-id="${customer.id}"></td>
			<td>#${customer.id}</td>
			<td>${customer.name}</td>
			<td>${customer.address}</td>
			<td>${customer.vip ? "是" : "否"}</td>
			
			<td>
				<a class="btn btn-default btn-xs" href="${contextPath}/customers/${customer.id}/details">详情</a>
				<a class="btn btn-default btn-xs" href="${contextPath}/customers/${customer.id}/edit">修改</a>
				<form action="${contextPath}/customers/${customer.id}/delete" method="post"
				      style="display: inline;">
					<button type="submit" class="btn btn-danger btn-xs">删除</button>
				</form>
			</td>
		</tr>
	</c:forEach>
		
	</table>
	
<!-- 	分页器 -->
	<ul id="pagination" class="pagination-sm"></ul>
	
  </div>
  <script type="text/javascript" src="${contextPath}/assets/jquery/jquery.js"></script>
  <script type="text/javascript" src="${contextPath}/assets/twbs-pagination/jquery.twbsPagination.min.js"></script>
  <script type="text/javascript" src="${contextPath}/assets/js/customer-list.js"></script>
  
  <script>
  $('#pagination').twbsPagination({
      totalPages: ${pageCount},
      visiblePages: 7,
      onPageClick: function (event, page) {
          console.log('go to page ' + page);
          window.location = '${contextPath}/customers?page=' + page;
      },
      initiateStartPageClick: false,
      startPage: ${currentPage}
  });
  </script>
  
  <c:if test="${customerCreated != null}">
    <script type="text/javascript">
  		alert('添加成功: ${customerCreated}');
    </script>
  </c:if>

</body>
</html>