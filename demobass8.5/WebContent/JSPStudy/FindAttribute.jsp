<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>findAttributeDemo</title>
</head>
<body>
	<%
	    pageContext.setAttribute("name1", "tan");
	    request.setAttribute("name2", "wan");
	    session.setAttribute("name3", "zhao");
	    application.setAttribute("name4", "laosi");
	    String[] name = {"pageContext","request","session","application","不存在的值"};
	    // findAttr demo
	    String[] value = new String[5];
	    for (int i = 0; i < 5; i++) {
	        String index = "name" + (i+1);
	        // key ---> value
	        value[i] = (String) pageContext.findAttribute(index);
	    }
	%>
	<h1>findattr-->value</h1>
	<% 
	 for (int i = 0; i < 5; i++) {
      
      out.print("name:"+name[i]+",value:"+value[i]+"<br/>");  
     }
	%>
	<h1>使用EL表达式进行输出：</h1>
		<h3>pageContext对象的name1属性：${name1}</h3>
		<h3>request对象的name2属性：${name2}</h3>
		<h3>session对象的name3属性：${name3}</h3>
		<h3>application对象的name4属性：${name4}</h3>
		<h3>不存在的name5属性：${name5}</h3>
</body>
</html>