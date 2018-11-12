<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<nav class="navbar navbar-default">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<h1>Wellcome to function page</h1>
				</div>
				<div class="text-right col-md-3 col-md-offset-8">
					<span style="font-size: 24px;">${loginuser}</span>
					<button class="btn btn-primary" id="logoutbtn">退出</button>
				</div>
			</div>
		</div>
	</nav>

	<div class="col-md-1 pull-left">
		
				<!-- sidebar menu: : style can be found in sidebar.less -->
				<ul class="">
					<li><a href="touser" title="" type="button"
						class="btn btn-default btn-success " id="login">登录人</a></li>
					<br>
					<li><a href="tosubject" title="" type="button"
						class="btn btn-default btn-success " id="subject">出题目</a></li>
					<br>
					<li><a href="totestpaper" title="" type="button"
						class="btn btn-default btn-success" >出试卷</a></li>
				</ul>
			
	</div>
	
