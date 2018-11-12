<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="/TagLib"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>父标签之间联系</title>
</head>
<body>
	<t:choose>
		<t:when flag="false">
		when 标签体下输出的内容
		<h3>user == null</h3>
		</t:when>
		<t:otherwise>
		t:otherwise下的内容
		  <h3>user != null</h3>
		</t:otherwise>

	</t:choose>
	<hr />
	<t:choose>
		<t:when flag="true">
        when 标签体下输出的内容
        <h3>user != null</h3>
		</t:when>
		<t:otherwise>
        t:otherwise下的内容
          <h3>user == null</h3>
		</t:otherwise>

	</t:choose>
</body>
</html>