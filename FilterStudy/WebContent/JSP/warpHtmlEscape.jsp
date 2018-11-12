<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>html过滤器测试</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/ServletDemo2"
		method="post">
		留言:
		<textarea rows="8" cols="70" name="message">
           <script type="text/javascript">
				while (true) {
					alert("死循环了，我会不停地弹出了");
				}
			</script>
        <a href="http://www.cnblogs.com">访问博客园</a>
           </textarea>
		<input type="submit" value="发表">
	</form>
</body>
</html>