<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link
	href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.css
"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
<script
	src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js
"></script>

<title>Insert title here</title>
</head>
<body>
	<form:form action="addbook" method="post">
		bookName:<form:input path="bookName" type="text" name="bookName"/> <br />
		  <form:errors path="*"></form:errors>
		bookISBN:<form:input path="bookIsbn" type="text" name="bookIsbn"/> <br />
		
		bookprice<form:input path="price" type="text" name="price"/> <br />
		
		<button type="submit">submit</button>
	</form:form>
	<%
	    if (request.getSession().isNew()) {
	        out.write(request.getSession().getId());
	    } else {
	        out.write("that's old session");
	    }
	%>
</body>
</html>