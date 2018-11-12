<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="person" class="jsplesson.beans.Person" scope="page" />
<html>
<%--
    jsp:setProperty标签用所有的请求参数为bean的属性赋值
    property="*"代表bean的所有属性
   
--%>
 <jsp:setProperty property="*" name="person" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp:setProperty标签使用范例3</title>
</head>
<body>
	<%--使用getXxx()方法获取对象的属性值 --%>
	<h2>
		姓名：<%=person.getName()%></h2>
	<h2>
		性别：<%=person.getSex()%></h2>
	<h2>
		年龄：<%=person.getAge()%></h2>
</body>
</html>