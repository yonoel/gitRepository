<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入自己写的库 -->
<%@taglib uri="/ELFunction" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>使用EL调用Java方法</title>
</head>
<body>
	<%--使用EL调用filter方法(参数)--%>
	${fn:filte("aaa<abc>") }
	
	<br />

</body>
</html>