<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String basepath = request.getContextPath();
%>
<!DOCTYPE html>
<!-- 登录 注册 购物车... -->

<script type="text/javascript">
	//导航条加载时，读取数据库catego目录
	$(function(){
		
		$.ajax({
			async:"true",
			url:"<%=basepath%>/mainController",
			type:'get',
			dataType:'json',
			data:{
				methodflag:"queryCategory"
			}
		}).done(function(data){
			//console.log(data);
			var flag = data.flag;
		
			if(flag){
			    var objs = data.object;
			    for (var i = 0; i < objs.length; i++) {
					var thing = "<li><a  href="
						    +"'<%=basepath%>/mainController?"
						    +"methodflag=queryCategoryInfo&cid="
							+objs[i].cid+"&pageNum=1' data='"+objs[i].cid+"' >"
							+objs[i].cname+"</a></li>";
					$("#headnav").append(thing);
				}
			}
			var href = window.location.href;
			if(href.indexOf("cid") != -1){
		        //console.log(href.indexOf("cid"));
		        var cid = href.substring(href.indexOf("cid")+4,href.lastIndexOf("&"));
		        //console.log("cid:"+cid);
		        var selector = "#headnav li a[data='"+cid+"']";
		        $(selector).parent("li").addClass("active");
		        
		       //console.log("cid"+$(selector).length);
		    }
		})
		
		
		<%-- $.get("<%=basepath%>/mainController",{methodflag:'queryCategoryByjedis'},function(data){
		
		
		},'json') --%>
	})
</script>
<div class="container-fluid">
	<div class="col-md-4">
		<img src="img/logo.png" />
	</div>
	<div class="col-md-5">
		<img src="img/header.png" />
	</div>
	<div class="col-md-3" style="padding-top: 20px">
		<ol class="list-inline">
		<c:choose>
					<c:when test="${not empty  user}">
					   <li>${user.username}</li>
					</c:when>
					<c:when test="${empty user }">
					   <li><a href="login.jsp">登录</a></li>
					</c:when>
		</c:choose>
		 
			
			
			<li><a href="register.jsp">注册</a></li>
			<li><a href="cart.jsp">购物车</a></li>
			<li><a href="order_list.jsp">我的订单</a></li>
		</ol>
	</div>
</div>

<!-- 导航条 -->
<div class="container-fluid">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<%=basepath%>/index.jsp">首页</a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav" id="headnav">


				</ul>
				<form class="navbar-form navbar-right" role="search" id="searchform"
					method="get" action="<%=basepath%>/product_list.jsp">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search"
							name="productname" id="productname">
					</div>
					<button type="submit" class="btn btn-default">Search</button>
				</form>
			</div>
		</div>
	</nav>
</div>