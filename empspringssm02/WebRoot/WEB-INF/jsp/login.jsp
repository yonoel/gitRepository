<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:set var="proname" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		#div1{
			border: 1px solid #000;
			margin:0px auto;
			width:400px;
			height:220px;
			
		}
		
		#table1{
			width:300px;
			border: 1px solid #000;
			border-collapse: collapse;
			margin:0px auto;
		}
		#table1 td{
			border: 1px solid #000;
		}
		
		h1{
			text-align:center;
		}
		
		#msg{
			margin:0px auto;
			color: red;
			width:300px;
		}
		
	</style>
	<script type="text/javascript" src="${proname}/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
		function checkform(){
			var loginname = $("#loginname").val();
			var loginpwd = $("#loginpwd").val();
			$("#msg").html("");
			if(loginname.length==0){
				$("#msg").html("登录名不能为空");
				return false;
			}
			
			if(loginpwd.length==0){
				$("#msg").html("密码不能为空");
				return false;
			}
			return true;
		}
		
		function submitform(){
			if(checkform()){
				//$.post("login?methodflag=dologin",)
				//将登录名和密码存储到cookie中
				//document.cookie = "cookieloginname="+$("#loginname").val();
				//document.cookie = "cookieloginpwd="+$("#loginpwd").val();
				$.post("${proname}/dologin.action",$("#form1").serialize(),function(data){
					if(data.succ){
						alert(data.msg);
						window.location.href="${proname}/tomain.action";
					}else{
						$("#msg").html(data.msg);
					}
				},"json");
			}
		}
	</script>
  </head>
  
  <body>
    <div id="div1">
      <h1>欢迎登陆员工管理系统</h1>
      <form id="form1">
      <input type="hidden" id="methodflag" name="methodflag" value="dologin"/>
      <table id="table1">
        <tr>
          <td>
                             登陆名：
          </td>
          <td>
          	<input type="text" id="loginname" name="loginname" />        
          </td>
        </tr>
        <tr>
          <td>
                            登陆密码：
          </td>
          <td>
          	<input type="text" id="loginpwd" name="loginpwd"/>        
          </td>
        </tr>
        <tr align="center">
          <td colspan="2">
            <input type="button" value="登录" onclick="submitform()"/>
            <input type="reset" value="重置"/>
          </td>
        </tr>
      </table>
      </form>
      <div id="msg">
      </div>
    </div>
  </body>
</html>
