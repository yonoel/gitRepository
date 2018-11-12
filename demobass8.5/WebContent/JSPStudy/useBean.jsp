<%@page import="jsplesson.beans.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 在jsp中使用标签实例化对象 -->
<jsp:useBean id="person" class="jsplesson.beans.Person" scope="page"></jsp:useBean>
<%
    // 假定上面的bean已经实例化
    person.setName("test");
    person.setAge(18);
    person.setMarried(false);
    person.setSex("男");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp:useBean标签使用范例</title>
</head>
<body>
	<%--使用getXxx()方法获取对象的属性值 --%>
	<h2>
		姓名：<%=person.getName()%></h2>
	<h2>
		性别：<%=person.getSex()%></h2>
	<h2>
		年龄：<%=person.getAge()%></h2>
	<h2>
		已婚：<%=person.isMarried()%></h2>

</body>
</html>