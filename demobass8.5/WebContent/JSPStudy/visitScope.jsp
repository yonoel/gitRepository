<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PagecontentVisitOtherScope</title>
</head>
<body>
	<%
	    // setAttribute(name,value,scope)
	    pageContext.setAttribute("name1", "testsession", PageContext.SESSION_SCOPE);
	   
	   String value1 = (String)pageContext.getAttribute("name1", PageContext.SESSION_SCOPE);
	   String value2 = (String)session.getAttribute("name1");
	   out.print("<h1>用不同方法取出的值</h1>");
	   out.print("pagecontent-->"+value1+"<br/>");
	   out.print("session-->"+value2+"<br/>");
	   
	%>
</body>
</html>