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
  
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		*{
			margin:0px;
			padding:0px;
			border:0px;
		}
		
		#all{
			border:1px solid #000;
			width:99.8%;
			height:791px;
		}
		
		#top{
			border-bottom:1px solid #000;
			height:200px;
			text-align:center;
			position:relative;
		}
		
		#topdiv{
			/* float:right;
			margin-right:50px;
			margin-top:120px; */
			position:absolute;
			right:50px;
			bottom:10px;
		}
		
		#topdiv a{
			text-decoration:none;
			margin-left:50px;
		}
		
		#left{
			width:15%;
			border-right:1px solid #000;
			float:left;
			height:590px;
		}
		
		#main{
			width:84.7%;
			float:left;
			height:590px;
		}
		
		#left ul li{
			margin-left: 50px;
			list-style-type:none;
			margin-top:20px;
		}
		
		#left ul li a{
			text-decoration:none;
		}
	</style>
	<script type="text/javascript" src="${proname}/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
		function exitsystem(){
			window.location.href="${proname}/toexit.action";
		}
		function setifrmesrc(url){
			$("#frame").attr("src",url);
		}
		
	</script>

  </head>
  
  <body>
    <div id="all">
    	<div id="top">
    		<h1>欢迎进入员工管理系统</h1>
    		<div id="topdiv">
    			登陆人：${sessionScope.sessionempinfo.ename}
    			<a href="javascript:void(0)" onclick="exitsystem()">退出系统</a>
    		</div>
    	</div>
    	<div id="bottom">
    		<div id="left">
    			<ul>
    			  <li><a href="javascript:void(0)" onclick="setifrmesrc('')">登陆人信息</a></li>
    			  <li><a href="javascript:void(0)" onclick="setifrmesrc('${proname}/ftl/emp/queryto.action')">员工信息</a></li>
    			  <li><a href="javascript:void(0)" onclick="setifrmesrc('')">部门信息</a></li>
    			  <li><a href="javascript:void(0)" onclick="setifrmesrc('')">工资等级信息</a></li>
    			</ul>
    		</div>
    		<div id="main">
    			<iframe src="${proname}/ftl/emp/queryto.action" width="100%" height="100%" id="frame"></iframe>
    		</div>
    	</div>
    </div>
  </body>
</html>
