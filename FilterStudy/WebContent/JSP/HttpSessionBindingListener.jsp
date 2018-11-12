<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.domain.javabean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HttpSessionBindingListener</title>
</head>
<body>
	<%
	    // bind object to session
	    session.setAttribute("javaBean", new JavaBeanDemo1("java01"));
	    // remove it
	    session.removeAttribute("javaBean");
	%>
</body>
</html>