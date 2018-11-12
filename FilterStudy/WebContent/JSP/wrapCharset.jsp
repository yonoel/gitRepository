<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--引入jstl标签库 --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>使用字符过滤器解决解决get、post请求方式下的中文乱码问题</title>
</head>
<body>

	<%--使用c:url标签构建url，构建好的url存储在servletDemo1变量中--%>
	<c:url value="/ServletDemo1" scope="page" var="servletDemo1">
		<%--构建的url的附带的中文参数 ，参数名是：username，值是：test--%>
		<c:param name="username" value="中文"></c:param>
	</c:url>
	<%--使用get的方式访问  这里会是乱码--%>
	<a href="${servletDemo1}">超链接(get方式请求)</a>
	<hr />
	<%--使用post方式提交表单 这里则可见 --%>
	<form action="${pageContext.request.contextPath}/ServletDemo1"
		method="post">
		用户名：<input type="text" name="username" value="中文" /> <input
			type="submit" value="post方式提交">
	</form>
</body>
</html>