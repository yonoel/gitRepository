<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>404错误友好提示页面</title>
</head>
<body>
	<%="对不起你要访问的页面不存在"%>
	<%="没有跳转，请点击"%>
	<a href=""${pageContext.request.contextPath}/index.jsp"">这里</a>
</body>
</html>