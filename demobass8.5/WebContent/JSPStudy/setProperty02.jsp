<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="person" class="jsplesson.beans.Person" scope="page" />
<html>
<%--
    jsp:setProperty标签可以使用请求参数为bean的属性赋值
    param="param_name"用于接收参数名为param_name的参数值，然后将接收到的值赋给name属性
    param就是表单提交里的name属性啊！！！
--%>

<jsp:setProperty property="name" name="person" param="param_name" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp:setProperty标签使用范例2</title>
</head>
<body>
	<%--使用getXxx()方法获取对象的属性值 --%>
	<h2>
		姓名：<%=person.getName()%></h2>
</body>
</html>