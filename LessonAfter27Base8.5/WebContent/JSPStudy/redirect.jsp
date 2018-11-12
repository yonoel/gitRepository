<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL: -- redirect标签实例</title>
</head>
<body>
	<c:redirect url="http://www.baidu.com">
		<%--在重定向时使用<c:param>标签为URL添加了两个参数：uname=GACL和password=123 --%>
		<c:param name="uname">GACL</c:param>
		<c:param name="password">123</c:param>
	</c:redirect>
</body>
</html>