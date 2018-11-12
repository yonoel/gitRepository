<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=request.getContextPath()%>"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Examples</title>
<meta name="description" content="">
<meta name="keywords" content="">
<link
	href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.css
"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
<script
	src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js
"></script>
<script type="text/javascript">
	$(function() {

		// ajax验证事件
		$("#accountname").on('blur', function(event) {
			event.preventDefault();
			/* Act on the event */
			var value = $(this).val();

			if (value.length > 0) {
				$.ajax({
					url : '${path}/loginName.do',
					type : 'post',
					dataType : 'json',
					data : {
						empName : value
					},
				}).done(function(data) {
					if (!data.flag) {
						$('#message').html(data.order);
					}
					//console.log("success");
				})
			}

		}).on('focus', function(event) {
			event.preventDefault();
			/* Act on the event */
			$('#message').html('');
		});

		// 表单提交
		$('form').submit(function(event) {
			/* Act on the event */
			return checkform();
		});

		// form 验证
		function checkform() {
			var name = $("#accountname").val();
			var psd = $('#accountpsd').val();

			if (name.length < 1) {
				$("#message").html('姓名不能为空');
				return false;
			}
			if (psd.length < 1) {
				$('#psdmessage').html("密码不能为空");
				return false;
			}
			return true;
		}

		$('#accountpsd').on('foucs', function(event) {
			event.preventDefault();
			/* Act on the event */
			$('#psdmessage').html('');
		});
	});
</script>
<style type="text/css">
</style>
</head>

<body>
	<nav class="navbar navbar-default">
	<div class="container text-center">
		<h1>Hello</h1>
	</div>
	</nav>
	<div class="container">
		<c:if test="${account == null }">
			<div class="row">
				<div class="col-md-5 col-md-offset-4">
					<form action="${path }/dologin.action" method="post"
						id="accountlogin">
						<div class="form-group">
							<label for="accountname">Your Name:</label>
							<spf:input path="command" type="text" class="form-control"
								id="accountname" placeholder="Name" name="ename"
								required="required" value="" />

							<span id="message" style="color: red">${order}</span>
						</div>
						<div class="form-group">
							<label for="accountpsd">Your Password:</label>
							<spf:input path="command" type="password" class="form-control"
								id="accountpsd" placeholder="password" name="password"
								required="required" value="" />
						</div>
						<div class="container">
							<div class="row">
								<div class="col-md-2 ">
									<input type="checkbox" name="remember" />Remember me <input
										type="hidden" name="remember" value="false" />
								</div>
								<div class="form-group btn-group  col-md-5 col-md-offset-1">
									<button type="submit" class="btn btn-primary" id="submitbtn">Submit</button>
									<button type="reset" class="btn btn-primary" id="resetbtn">Reset</button>
								</div>
							</div>
						</div>
					</form>
		</c:if>
		<c:if test="${account != null }">
			<div class="container text-center">
				<h1>你好 ${account.ename}</h1>
				<a href="main">点我去功能界面</a>
			</div>
		</c:if>
	</div>
	</div>
	</div>
</body>

</html>