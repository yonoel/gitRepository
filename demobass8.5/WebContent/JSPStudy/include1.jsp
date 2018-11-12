<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	    int i = 1;
	%>
	<h1>
	   
		this i =
		<%=i%></h1>
		两个I冲突了，跳转页面
		<h1><%@include file="/JSPStudy/includeTest.jsp" %></h1>
</body>
</html>