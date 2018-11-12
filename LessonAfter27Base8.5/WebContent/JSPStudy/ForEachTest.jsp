<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@taglib uri="/TagLib" prefix="t"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>foreach</title>
</head>
<body>
	<%
	    List<String> data = new ArrayList<String>();
	    data.add("测试");
	    data.add("foreach");
	    data.add("tag");
	    //将集合存储到pageContext对象中
	    pageContext.setAttribute("data", data);
	%>
	<%--迭代存储在pageContext对象中的data集合 --%>
	<t:foreach list="${data}" var="str">
             ${str}<br />
	</t:foreach>
</body>
</html>