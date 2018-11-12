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
	<form:form modelAttribute="checkboxes">
		<table>
			<tr>

				<td>Interests:</td>
				  <td>
                <%-- Property is of an array or of type java.util.Collection --%>
                <form:checkboxes path="interests" items="${checkboxes.interests}"/>
            </td>
			</tr>
		</table>
	</form:form>
</body>
</html>