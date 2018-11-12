<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=request.getAttribute("message")%>
	${formbean.userName}
	${formbean.userPwd}
	${formbean.email}
	${formbean.errors.birthday} 
	
	<a href="${pageContext.request.contextPath}/index.jsp">跳转首页</a>
</body>
</html>