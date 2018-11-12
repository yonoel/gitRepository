<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试paramtag</title>
</head>
<body>
    // 动态导入rel页面
    <jsp:include page="/JSPStudy/rel.jsp">
        <jsp:param value="hello" name="param1"/>
        <jsp:param value="world" name="param2"/>
    </jsp:include>
</body>
</html>