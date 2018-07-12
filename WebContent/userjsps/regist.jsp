<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${not empty msg }">
		<h1>${msg }</h1>
	</c:if>
	<form action="<c:url value='/userAction_regist'/>" method="post">
	用户名：<input type="text" name="username" value=""> <br>
	密　码：<input type="text" name="upassword" value=""> <br>
		<input type="submit" value="注册">
	</form>
</body>
</html>