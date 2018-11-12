<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

    $('#submitbtn').on('click', function(event) {
        event.preventDefault();
        /* Act on the event */
       /*  if (!checkform()) {
            return;
        } else { */
            var user = $("#accountname").val();
            var psd = $("#accountpsd").val();
            var remember = $(":checked").length;
            $.ajax({
                    url: 'dolongin',
                    type: 'post',
                    dataType: 'json',
                    data: $("#loginform").serialize()
                
                })
                .done(function(data) {
                	alert(data.message)
                	if(data.flag){
                		//跳转页面
                		window.location.href = "touser"
                	}
                })
                .always(function() {
                    console.log("complete");
                });

        /* } */
    });

    function checkform() {

        var user = $("#accountname").val();
        var psd = $("#accountpsd").val();

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
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') ||
                    (c >= '0' && c <= '9') || c == '_')) {
                alert("用户名只能包含 a-z、0-9 和下划线");
                return false;
            }
        }

        //至少包含 6 个字符
        if (pwd.length < 6) {
            alert("密码至少包含 6 个字符");
            return false;
        }
        return true;
    }


})
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
       
        <div class="row">
            <div class="col-md-5 col-md-offset-4">
                  
                 
                
                    <form action="addAccount" method="post" id="loginform">
                        <div class="form-group">
                            <label for="accountname">Your Name:</label>
                            <input  type="text" class="form-control"
                                id="accountname" placeholder="loginuser" name="loginuser"
                                required="required" value="" />
                            <span id="message"></span>
                        </div>
                        <div class="form-group">
                            <label for="accountpsd">Your Password:</label>
                            <input  type="password" class="form-control"
                                id="accountpsd" placeholder="Password" name="password"
                                required="required" value="" />
                        </div>
                        <div class="container">
                            <div class="row">
                                <div class="col-md-2 ">
                                    <input type="checkbox" name="remember" />Remember me <input
                                        type="hidden" name="remember" value="false" />
                                </div>
                                <div class="form-group btn-group  col-md-5 col-md-offset-1">
                                    <button type="button" class="btn btn-primary" id="submitbtn">Submit</button>
                                    <button type="reset" class="btn btn-primary" id="resetbtn">Reset</button>
                                </div>
                            </div>
                        </div>
                    </form>
              
               <%--  <c:if test="${!empty loginuser}">
                    <div class="container text-center">
                        <h1>你好 ${account.name}</h1>
                        <a href="main">点我去功能界面</a>
                    </div>
                </c:if> --%>
            </div>
        </div>
    </div>
</body>

</html>