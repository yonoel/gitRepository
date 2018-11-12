<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String basepath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员登录</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css" />
<script type="text/javascript">
	$(function() {
		$('#loginform').submit(function() {
		
			var checkflag = checkform();
			//console.log(checkflag);
				if (checkflag) {
					// 前段校验，ajax提交
					console.log('提交');
					postform();
				}
		
			return false;
			})
			
		// 动态验证用户名
		 $("#username").on('blur',function(){
			 $.get("<%=basepath%>/userController",{methodflag:'login',username:$('#username').val()},function(data){
				 //console.log(data);
				 if(!data.flag){
					 $('#namemessage').html(data.message);
				 }
			 },'json')
		 }).on('focus',function(){
			 $('#namemessage').html('');
		 })
		    // window.location = '<%=basepath%>/index.jsp';
	})
  function postform(){
          $.get("<%=basepath%>/userController", $('#loginform').serialize(), function(data) {
              var loginflag = data.flag;
        	  var message = data.message;
        	  console.log(data);
              if (!loginflag) {
                  alert(message);
                  $('#namemessage').html(message);
              }else{
            	 
            	
            	  if($('#times').val() != "1"){
            		  alert(message);
            		  // 成功需要seesion域里增加一个对象
            		  window.location = '<%=basepath%>/index.jsp';
				}

			}

		}, 'json')
	}

	function checkform() {
		var user = $("#username").val();
		var psd = $("#password").val();

		//用户名不能为空
		if (user.length == 0) {
			alert("用户名不能为空");
			return false;
		}
		//密码不能为空
		if (psd.length == 0) {
			alert("密码不能为空");
			return false;
		}
		//只能包含 a-z、0-9 和下划线
		for (var i = 0; i < user.length; i++) {
			var c = user.charAt(i);
			if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')
					|| (c >= '0' && c <= '9') || c == '_')) {
				alert("用户名只能包含 a-z、0-9 和下划线");
				return false;
			}
		}

		//至少包含 6 个字符
		if (psd.length < 6) {
			alert("密码至少包含 6 个字符");
			return false;
		}
		return true;
	}
	
function changeCode(){
        
        $("#checkimg").attr("src","<%=basepath%>/getcheckcode?methodflag=login&random="+Math.random());
    }
</script>

<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}

.container .row div {
	/* position:relative;
				 float:left; */
	
}

font {
	color: #666;
	font-size: 22px;
	font-weight: normal;
	padding-right: 17px;
}
</style>
</head>
<body>

	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>


	<div class="container"
		style="width: 100%; height: 460px; background: #FF2C4C url('images/loginbg.jpg') no-repeat;">
		<div class="row">
			<div class="col-md-7">
				<!--<img src="./image/login.jpg" width="500" height="330" alt="会员登录" title="会员登录">-->
			</div>

			<div class="col-md-5">
				<div
					style="width: 440px; border: 1px solid #E7E7E7; padding: 20px 0 20px 30px; border-radius: 5px; margin-top: 60px; background: #fff;">
					<font>会员登录</font>USER LOGIN
					<div>&nbsp;</div>
					<form class="form-horizontal" id="loginform">
						<input type="hidden" name="methodflag" value="login" /> 
						<div class="form-group">
							<label for="username" class="col-sm-2 control-label">用户名</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="username"
									name="username" placeholder="请输入用户名" /> <span id="namemessage"
									style="color: red"></span>
							</div>
						</div>
						<div class="form-group">
							<label for="password" class="col-sm-2 control-label">密码</label>
							<div class="col-sm-6">
								<input type="password" class="form-control" id="password"
									name="password" placeholder="请输入密码" />
							</div>
						</div>
						<div class="form-group">
							<label for="yzm" class="col-sm-2 control-label">验证码</label>
							<div class="col-sm-3">
								<input type="text" class="form-control" name="yzm" id="yzm">
							</div>
							<div class="col-sm-3">
								<img src="<%=basepath%>/getcheckcode?methodflag=login" onclick="changeCode()"
                                id="checkimg" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<div class="checkbox">
									<label> <input type="checkbox" name="autologin">
										自动登录
									</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label> <input
										type="checkbox" name="remember"> 记住用户名
									</label>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<input type="submit" width="100" value="登录"
									style="background: url('./images/login.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>