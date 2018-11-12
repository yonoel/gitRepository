<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ServletContextAttributeListenerTest</title>
</head>
<body>
	<%
	    //往application域对象中添加属性
	    application.setAttribute("name", "test");
	    //替换application域对象中name属性的值
	    application.setAttribute("name", "demo");
	    //移除application域对象中name属性
	    application.removeAttribute("name");
	%>
</body>
</html>