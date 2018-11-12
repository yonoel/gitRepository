<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String basepath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head></head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员注册</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css" />
<!--  导入Validate验证插件-->
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript">
	$(function() {
		// 用户名不能重复存在的ajax校验
		$("#username").on('blur',function(){
			
			  if($('#username').val().length > 0){
				  $.ajax({
		                url:"<%=basepath%>/userController"
		                ,
		                data:{
		                    methodflag:"login",
		                    username:$("#username").val(),
		                    
		                },
		               dataType:'json',
		            }).success(function(data){
		                // 为真则存在
		               
		                if(data.flag){
		                    $('#namemessage').html("用户存在");
		                 
		                }
		            })
			  }
			
			
		}).on('focus',function(){
			$('#namemessage').html("");
		})
		<%-- $('#registerform').submit(function() {
		    var checkflag = checkform();
				    if (checkflag) {
		                // 为真，ajax提交
		                console.log('提交');
		                 $.get('<%=basepath%>/userController', $('form').serialize(), function(data) {
		                                var registerflag = data.flag;
		                                if (registerflag) {
		                                    alert("注册成功，跳转首页面");
		                                     window.location = '<%=basepath%>/index.jsp'
							}
						}, 'json')
					}
					return false;
				}) --%>
		//定义校验规则
        $("#registerform").validate({
	        submitHandler:function(form,event){
	        	
	        		postform();
	        	}, 
            rules:{
                "username":{
                    "required":true,
                   
                },
                "password":{
                    "required":true,
                    "rangelength":[6,16],
                    "equalTo":"#confirmpwd"
                },
                "confirmpwd":{
                    "required":true
                },
                "email":{
                    "required":true,
                    "email":true
                },
                "telephone":{
                    "required":true,
                    "rangelength":[11,11]
                },
                "name":{
                    "required":true
                },
                "birthday":{
                    "required":true
                },
                "yzm":{
                    "required":true,
                   
                }

            },
            messages:{
                "username":{
                    "required":"用户名不能为空",
                    "checkusername":"用户名已经存在"
                },
                "password":{
                    "required":"密码不能为空",
                    "rangelength":"密码的长度需要在6-16之间",
                    "equalTo":"密码与确认密码一致"
                    
                },
                "confirmpwd":{
                    "required":"确认密码不能为空"
                },
                "email":{
                    "required":"邮箱不能为空",
                    "email":"必须满足邮箱格式"
                },
                "telephone":{
                    "required":"手机不能为空",
                    "rangelength":"手机号位数必须是11位"
                },
                "name":{
                    "required":"姓名不能为空"
                },
                "birthday":{
                    "required":"出生日期不能为空"
                },
                "yzm":{
                    "required":"验证码必须输入",
                  
                }
            }
        })
        
       
        
	})
	function checkform() {
		var user = $("#username").val();
		var psd = $("#password").val();
		var confirmpwd = $('#confirmpwd').val();
		//用户名不能为空
		if (user.length == 0) {
			alert("用户名不能为空");
			return false;
		}
		//密码不能为空
		if (pwd.length == 0) {
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
		//两次密码不相同
		if (psd != confirmpwd) {
			alert("两次密码不相同");
			return false;
		}
		//至少包含 6 个字符
		if (pwd.length < 6) {
			alert("密码至少包含 6 个字符");
			return false;
		}
		return true;
	}
	
	function changeCode(){
		
        $("#checkimg").attr("src","<%=basepath%>/getcheckcode?methodflag=register&random="+Math.random());
    }
	
	function postform(){
		$.ajax({
			url:"<%=basepath%>/userController",
			data:$('#registerform').serialize(),
			dataType:'json',
		}).success(function(data){
			    var loginflag = data.flag;
	            var message = data.message;
	           // console.log(data);
	              // 跳转页面
	            alert(message);
	              if(loginflag){
	            	  window.location = '<%=basepath%>/index.jsp'
	              }
		})
       <%--  $.get("<%=basepath%>/userController", $('#registerform').serialize(), function(data) {
            var loginflag = data.flag;
            var message = data.message;
            console.log(data);
            alert(message);
            if (!loginflag) {
              
                $('#namemessage').html(message);
            }else{
                // 说明是表单提交
                 
                    // 成功需要seesion域里增加一个对象
                   // window.location = '<%=basepath%>/index.jsp';           
          }

      }, 'json') --%>
  }
</script>

<style>
label.error {
	color: red;
}

body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}

font {
	color: #3164af;
	font-size: 18px;
	font-weight: normal;
	padding: 0 10px;
}
</style>
</head>
<body>

	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>

	<div class="container"
		style="width: 100%; background: url('image/regist_bg.jpg');">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8"
				style="background: #fff; padding: 40px 80px; margin: 30px; border: 7px solid #ccc;">
				<font>会员注册</font>USER REGISTER
				<form class="form-horizontal" style="margin-top: 5px;"
					id="registerform">
					<input type="hidden" name="methodflag" value="register"
						id="methodflag" /> <input type="hidden" name="times" value="1"
						id="times" />
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="username"
								name="username" placeholder="请输入用户名"> <span
								id="namemessage" style="color: red"></span>
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="password"
								name="password" placeholder="请输入密码">
						</div>
					</div>
					<div class="form-group">
						<label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="confirmpwd"
								placeholder="请输入确认密码">
						</div>
					</div>
					<div class="form-group">
						<label for="telephone" class="col-sm-2 control-label">电话</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="telephone"
								name="telephone" placeholder="telephone">
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-6">
							<input type="email" class="form-control" id="email" name="email"
								placeholder="Email">
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">姓名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="name" name="name"
								placeholder="请输入姓名" required="required">
						</div>
					</div>
					<div class="form-group opt">
						<label for="sex" class="col-sm-2 control-label">性别</label>
						<div class="col-sm-6">
							<label class="radio-inline"> <input type="radio"
								name="sex" value="男" checked="checked"> 男
							</label> <label class="radio-inline"> <input type="radio"
								name="sex" value="女"> 女
							</label>
						</div>
					</div>
					<div class="form-group">
						<label for="birthday" class="col-sm-2 control-label">出生日期</label>
						<div class="col-sm-6">
							<input type="date" class="form-control" name="birthday"
								id="birthday">
						</div>
					</div>

					<div class="form-group">
						<label for="yzm" class="col-sm-2 control-label">验证码</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" name="yzm" id="yzm">
						
						</div>
						<div class="col-sm-2">
							<img src="<%=basepath%>/getcheckcode?methodflag=register" onclick="changeCode()"
								id="checkimg" />
						</div>

					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" width="100" value="注册" name="submit"
								style="background: url('./images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
						</div>
					</div>
				</form>
			</div>

			<div class="col-md-2"></div>

		</div>
	</div>

	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>




