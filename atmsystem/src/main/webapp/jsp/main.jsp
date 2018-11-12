<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>main</title>
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="viewport" content="width=device-width,init-scale=1">
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

		var indexbox = $("#indexbox");
		indexbox.siblings('div').css('display', 'none');
		//inde
		$("#index").on('click', function(event) {
			event.preventDefault();
			/* Act on the event */
			window.location.href = "index.jsp";
		});
		// query
		$("#query").on('click', function(event) {
			event.preventDefault();
			/* Act on the event */
			$("#querybox").show().siblings().hide();

		});
		// draw
		$("#draw").on('click', function(event) {
			event.preventDefault();
			/* Act on the event */
			$("#drawbox").show().siblings().hide();
		});
		// save
		$("#save").on('click', function(event) {
			event.preventDefault();
			/* Act on the event */
			$("#savebox").show().siblings().hide();
		});
		 // transfer
        $("#transfer").on('click', function(event) {
            event.preventDefault();
            /* Act on the event */
            $("#transferbox").show().siblings().hide();
        });
		
		
		// logout
		$("#logoutbtn").click(function(event) {
			/* Act on the event */
			window.location.href = "logout";
		});
		// index
		$("#index").click(function(event) {
			/* Act on the event */
			window.location.href = "index";
		});
	});
</script>
<style type="text/css" media="screen">
ul {
	list-style: none;
}
</style>
</head>

<body>
	<nav class="navbar navbar-default">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<h1>Wellcome to function page</h1>
				</div>
				<div class="text-right col-md-3 col-md-offset-8">
					<span style="font-size: 24px;">${account.name}</span>
					<button class="btn btn-primary" id="logoutbtn">退出</button>
				</div>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-md-2">
				<ul>
					
					<li><a href="query" title="" type="button"
						class="btn btn-lg btn-success " id="query">查询</a></li>
					<br>
					<li><a href="draw" title="" type="button"
						class="btn btn-lg btn-success " id="draw">取款</a></li>
					<br>
					<li><a href="save" title="" type="button"
						class="btn btn-lg btn-success" id="save">存款</a></li>
						<br>
					<li><a href="save" title="" type="button" class="btn btn-lg btn-success" id="transfer">
					转账</a></li>
				</ul>
			</div>
			<div class="col-md-10">
				<div id="indexbox" class="col-md-offset-1">
                    <h1 class="text-left">${message}</h1>
                </div>
				<div class="query panel panel-default" id="querybox">
                    <div class="panel-heading">
                        <h2 >
                                您的信息如下：
                                </h2>
                    </div>
                    <table class="table">
                      
                        
                        <div class="col-md-1">
                            <tbody>
                                <tr>
                                    <td>
                                        <label for="" class="form-inline">id:</label>
                                    </td>
                                    <td>
                                        ${account.id}
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label for="" class="form-inline">name:</label>
                                    </td>
                                    <td>
                                        ${account.name}
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label for="" class="form-inline">cash:</label>
                                    </td>
                                    <td>
                                     ${account.cash}
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label for="" class="form-inline">birthday:</label>
                                    </td>
                                    <td>
                                        ${account.birthday}
                                    </td>
                                </tr>
                            </tbody>
                        </div>
                    </table>
                </div>
				<div class="draw col-md-4 panel panel-default" id="drawbox">
					<form action="draw" method="post" accept-charset="utf-8">
						<div class="form-group panel-heading">
							<h2>取款</h2>
						</div>
						<div class="form-group ">
							<label>取款金额:&nbsp; <input type="text" name="draw"
								value="" class="orderMessage" >
							</label> 
						</div>
						<div class="form-group col-md-offset-6">
							<button type="submit" class="btn btn-primary">submit</button>
							<button type="reset" class="btn btn-primary">reset</button>
						</div>
					</form>
				</div>
				<div class="draw col-md-4 panel panel-default" id="savebox">
					<form action="save" method="post" accept-charset="utf-8">
						<div class="form-group panel-heading">
							<h2>存款</h2>
						</div>
						<div class="form-group ">
							<label>存款金额:&nbsp; <input type="text" name="save"
								value="" class="orderMessage">
							</label>
						</div>
						<div class="form-group col-md-offset-6">
							<button type="submit" class="btn btn-primary">submit</button>
							<button type="reset" class="btn btn-primary">reset</button>
						</div>
					</form>
				</div>
				<div class="draw col-md-4 panel panel-default" id="transferbox">
                    <form action="transfer" method="post" accept-charset="utf-8">
                        <div class="form-group panel-heading">
                            <h2>转账</h2>
                        </div>
                        <div class="form-group ">
                            <label>转账金额:&nbsp;
                                <input type="text" name="transfer" value="" class="orderMessage">
                            </label>
                            <span class="message"></span>
                        </div>
                        <div class="form-group ">
                            <label>转账账户:&nbsp;
                                <input type="text" name="name" value="" class="orderMessage">
                            </label>
                            <span class="message"></span>
                        </div>
                        <div class="form-group col-md-offset-6">
                            <button type="submit" class="btn btn-primary">submit</button>
                            <button type="reset" class="btn btn-primary">reset</button>
                        </div>
                    </form>
                </div>
			</div>
		</div>
	</div>
</body>

</html>