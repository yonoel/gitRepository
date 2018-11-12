<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>formByToken</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/DoFormServlet"
		method="post">
		<%--使用隐藏域存储生成的token--%>
		<%--
            <input type="hidden" name="token" value="<%=session.getAttribute("token") %>">
        --%>
		<%--使用EL表达式取出存储在session中的token--%>
		<input type="hidden" name="token" value="${token}" /> 用户名：<input
			type="text" name="username"> <input type="submit" value="提交">
	</form>
</body>
</html>