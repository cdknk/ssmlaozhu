<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>

	<c:if test="${param.error != null}">
		<h4 style="color: red;">登录失败：用户名或密码错误</h4>
	</c:if>

<!-- 	            表单必须post提交到/login -->
<!--     	只需要用户名的input.name为username，密码的input.name为password -->
 <form action="" method="post">
<!--  	防范CSRF攻击 -->
 	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <fieldset>
        <p>
        <label for="username">用户名</label>
        <input type="text" id="username" name="username"/>
        </p>
        
        <p>
        <label for="password">密码</label>
        <input type="password" id="password" name="password"/>
        </p>
        
        <div>
            <button type="submit" class="btn">登录</button>
        </div>
    </fieldset>
 </form>
</body>
</html>