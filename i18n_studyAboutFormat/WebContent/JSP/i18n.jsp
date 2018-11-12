<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
    //加载i18n资源文件，request.getLocale()获取访问用户所在的国家地区
    ResourceBundle myResourcesBundle = ResourceBundle.getBundle("com.i18n_study.resources.myproperties",
            request.getLocale());
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>国际化(i18n)测试</title>
</head>
<body>
	<form action="" method="post">
		<%=myResourcesBundle.getString("username")%>：<input type="text"
			name="username" /><br />
		<%=myResourcesBundle.getString("password")%>：<input type="password"
			name="password" /><br /> <input type="submit"
			value="<%=myResourcesBundle.getString("submit")%>">
	</form>
</body>
</html>