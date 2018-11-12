<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/Geek" prefix="TagLib"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    //会重写所有标签内的content到大写
    <TagLib:modifybody>
	以下的返回体为skip.body
	// 由start标签控制内容
	<TagLib:returnStart>由start标签控制内容</TagLib:returnStart>
	// 由end标签控制内容
	<TagLib:returnEnd>由end标签控制内容</TagLib:returnEnd>
	<br />
	<p>使用&lt;%@taglib uri="标签库的uri" prefix="标签的使用前缀"%&gt;指令引入要使用的标签库</p>
	你的IP address is(called by java method)<%=request.getRemoteAddr()%>
	<hr />
	你的IP address is(use taglib)
	<TagLib:viewIP />
	<br/>
	<TagLib:Iterator>
	     重复输出内容
	</TagLib:Iterator>
    </TagLib:modifybody>
</body>
</html>