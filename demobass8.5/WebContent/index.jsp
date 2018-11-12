<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>demobase8.5</title>
<base href=""<%= basePath %>>
</head>
<body>
    <%  out.print("hello world,this is called by java<br/>"); %>
    
    <%
        session.setAttribute("name", "session对象");//使用session对象,设置session对象的属性
        out.print(session.getAttribute("name")+"<br/>");//获取session对象的属性
        pageContext.setAttribute("name", "pageContext对象");//使用pageContext对象,设置pageContext对象的属性
        out.print(pageContext.getAttribute("name")+"<br/>");//获取pageContext对象的属性
        application.setAttribute("name", "application对象");//使用application对象,设置application对象的属性
        out.print(application.getAttribute("name")+"<br/>");//获取application对象的属性
        out.print("out对象"+"<br/>");//使用out对象
        out.print("服务器调用index.jsp页面时翻译成的类的名字是："+page.getClass()+"<br/>");//使用page对象
        out.print("处理请求的Servlet的名字是："+config.getServletName()+"<br/>");//使用config对象
        out.print("getContentType:"+response.getContentType()+"<br/>");//使用response对象
        out.print("getContextPath"+request.getContextPath()+"<br/>");//使用request对象
%>
    <h1>Hello</h1>
    <h2>This is a index.jsp</h2>
</body>
</html>