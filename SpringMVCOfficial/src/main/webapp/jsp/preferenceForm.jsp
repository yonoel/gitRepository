<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>perfence</title>
</head>
<body>
	<form:form >
		<table>
			<tr>
				<td>Subscribe to newsletter?:</td>
				<%-- Approach 1: Property is of type java.lang.Boolean --%>
				<td><form:checkbox path="receiveNewsletter" /></td>
			</tr>

			<tr>
				<td>Interests:</td>
				<%-- Approach 2: Property is of an array or of type java.util.Collection --%>
				<td>Quidditch: <form:checkbox path="interests"
						value="Quidditch" /> Herbology: <form:checkbox
						path="interests" value="Herbology" /> Defence Against
					the Dark Arts: <form:checkbox path="interests"
						value="Defence Against the Dark Arts" />
				</td>
			</tr>

			<tr>
				<td>Favourite Word:</td>
				<%-- Approach 3: Property is of type java.lang.Object --%>
				<td>Magic: <form:checkbox path="favouriteWord"
						value="Magic" />
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>