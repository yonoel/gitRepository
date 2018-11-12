<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 这些标签需要jar包 
	<c:choose>
		<c:when test="${isnull:hasvalue(testtld)}">
			<p>tld的值为123</p>
		</c:when>
		<c:otherwise>
			<p>tld的值不是123</p>
		</c:otherwise>
	</c:choose>
	<p>获取域值：${testtld}</p>
</body>
</html>