<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="addUser" modelAttribute="user">
        name: <form:input path="name" />
		<%-- Show errors for name field --%>
		<form:errors path="name"></form:errors>
        psd: <form:password path="psd" />
		<%-- Show errors for psd field --%>
		<form:errors path="psd"></form:errors>
		
		<input type="submit" value="submit" />
	</form:form>
	
</body>
</html>