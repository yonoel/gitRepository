<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>接收forward方法传来的参数</title>
</head>
<body>
	<h1>跳转以后的页面</h1>
	<h1>接收从forward03.jsp传递过来的参数：</h1>
	<h1>
		ref1：<%=request.getParameter("param1")%></h1>
	<h1>
		ref2：<%=request.getParameter("param2")%></h1>
	<h1>
		ref2：<%=request.getParameter("param3")%></h1>
</body>
</html>