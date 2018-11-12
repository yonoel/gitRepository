<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/Geek" prefix="simple"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SimpleTag</title>
</head>
<body>
	<%--在jsp页面中使用自定义标签 是带有标签体的，标签体的内容是""几个字符串--%>
	<simple:SimpleTag>
	   测试类
	</simple:SimpleTag>
	<simple:viewIP/>
</body>
</html>