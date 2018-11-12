<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>首页</title>
</head>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
<script type="text/javascript">
	$(function() {
		
		$("#logout")
				.click(
						function(event) {
							/* Act on the event */
							//访问LogoutServlet 查询
							window.location.href = "${pageContext.request.contextPath}/LogoutServlet";
						});

	});
</script>
</head>
<body>
	<h2>Hello!!!!</h2>
	<c:if test="${user==null}">
		<a href="${pageContext.request.contextPath}/Servlet/RegisterUIServlet"
			target="_blank">注册</a>
		<a href="${pageContext.request.contextPath}/Servlet/LoginUIServlet">登陆</a>
	</c:if>
	<hr />
	<!-- 当客户登录以后才能进行操作 -->
	<c:if test="${user!=null}">
           欢迎您：${user.userName}<br />
		<form action="${pageContext.request.contextPath}/QueryServlet"
			method="post">
			<!-- 查询 -->
			<h4>请输入用户名查询</h4>
			<input type="text" name="userName" value=""> <input
				type="submit" name="submitbtn" value="查询" id="query"><br />
		</form>
		<form action="${pageContext.request.contextPath}/DeleteServlet"
			method="post">
			<!-- 删除 -->
			<h4>请输入用户名删除</h4>
			<input type="text" name="userName" value=""> <input
				type="submit" name="" value="删除" id="delete"><br />
		</form>
		<!-- 修改 -->
		<h4>修改本账户信息</h4>
		<form
        action="${pageContext.request.contextPath}/UpdateServlet"
        method="post">
        <table width="60%" border="1">
            <tr>
                <td>用户名</td>
                <td>
                    <%--使用EL表达式${}提取存储在request对象中的formbean对象中封装的表单数据(formbean.userName)以及错误提示消息(formbean.errors.userName)--%>
                    <input type="text" name="userName" value="${formbean.userName}">
                    ${formbean.errors.userName}
                </td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="userPwd"
                    value="${formbean.userPwd}">${formbean.errors.userPwd}</td>
            </tr>
            <tr>
                <td>确认密码</td>
                <td><input type="password" name="confirmPwd"
                    value="${formbean.confirmPwd}">${formbean.errors.confirmPwd}</td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td><input type="text" name="email" value="${formbean.email}">${formbean.errors.email}</td>
            </tr>
            <tr>
                <td>生日</td>
                <td><input type="text" name="birthday"
                    value="${formbean.birthday}">${formbean.errors.birthday}</td>
            </tr>
            <tr>
                <td><input type="reset" value="清空"></td>
                <td><input type="submit" value="提交"></td>
            </tr>
        </table>
    </form>
        <!-- 退出 -->
		<hr />
		<input type="button" value="退出登陆" id="logout" />

	</c:if>

</body>
</html>
