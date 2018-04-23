<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户详情</title>

	<style type="text/css">
		.customer-picture {
			width: 50px;
			height: 50px;
		}
	</style>
</head>
<body>
	<h3>客户详情</h3>
	<div>
	  <div>
		照片: 
			<c:choose>
				<c:when test="${customer.picturePath != null}">
					<img src="${contextPath}/customer-pictures/${customer.picturePath}" 
				  		 class="customer-picture">
				</c:when>
				<c:otherwise>
					无
				</c:otherwise>
			</c:choose>
	  </div>
		姓名：${customer.name} <br>
		地址：${customer.address} <br>
		VIP：${customer.vip ? '是' : '否'}
	</div>
</body>
</html>