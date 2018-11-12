<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String basepath=request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.css
" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js
"></script>
<title>Insert title here</title>
<script type="text/javascript">

</script>
</head>
<body>
    <form action="<%=basepath %>/testform" method="get">
        <input type="text" value="a" name="oid">
        <input type="text" value="a1" name="pid">
        <input type="text" value="a2" name="pid">
        <input type="text" value="b" name="oid">
        <input type="text" value="b1" name="pid">
        <input type="text" value="b2" name="pid">
        <input type="text" value="b3" name="pid">
        <button type="submit">submit</button>
    </form>
</body>
</html>