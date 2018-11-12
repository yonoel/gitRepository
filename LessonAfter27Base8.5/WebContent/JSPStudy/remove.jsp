<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<c:set var="name" scope="session">孤傲苍狼</c:set>
		<c:set var="age" scope="session">25</c:set>
		<li><c:out value="${sessionScope.name}"></c:out></li>
		<li><c:out value="${sessionScope.age}"></c:out></li>
		<%--使用remove标签移除age变量 --%>
		<c:remove var="age" />
		<li><c:out value="${sessionScope.name}"></c:out></li>
		<li><c:out value="${sessionScope.age}"></c:out></li>
	</ul>
</body>
</html>