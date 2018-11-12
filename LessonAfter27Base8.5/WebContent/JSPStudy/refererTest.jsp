<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/TagLib" prefix="tagS"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TestReferer</title>
<%--在Jsp页面中使用防盗链标签 
当用户尝试直接通过URL地址(http://localhost:8080/JavaWeb_JspTag_study_20140816/simpletag/refererTagTest.jsp)访问这个页面时，
防盗链标签的标签处理器内部就会进行处理，将请求重定向到/index.jsp
--%>
</head>
<body>
	<tagS:referer site="http://localhost:7070" page="/index.jsp" />
	内部资料，不给你看
</body>
</html>