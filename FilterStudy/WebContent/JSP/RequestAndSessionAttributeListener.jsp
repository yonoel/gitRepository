<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RequestAndSessionAttributeListener</title>
</head>
<body>
	<%
	    //往session域对象中添加属性
	    session.setAttribute("aa", "bb");
	    //替换session域对象中aa属性的值
	    session.setAttribute("aa", "xx");
	    //移除session域对象中aa属性
	    session.removeAttribute("aa");
	    //往request域对象中添加属性
	    request.setAttribute("aa", "bb");
	    //替换request域对象中aa属性的值
	    request.setAttribute("aa", "xx");
	    //移除request域对象中aa属性
	    request.removeAttribute("aa");
	%>
</body>
</html>