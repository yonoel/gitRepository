<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>avoid repeat dopost</title>
<script type="text/javascript">
	var isCommitted = false;//表单是否已经提交标识，默认为false
	function dosubmit() {
		if (isCommitted == false) {
			isCommitted = true;//提交表单后，将表单是否已经提交标识设置为true
			return true;//返回true让表单正常提交
		} else {
			return false;//返回false那么表单将不提交
		}
	}
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath}/DoFormServlet" onsubmit="return dosubmit()"
		 method = "post">
		用户名：<input type="text" name="username"> <input type="submit"
			value="提交" id="submit">
	</form>
</body>
</html>