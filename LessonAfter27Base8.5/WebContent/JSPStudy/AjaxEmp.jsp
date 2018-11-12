<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% String basepath = request.getContextPath(); %>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>实现Ajax增删改查</title>
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
		var currentpage = $('#currentpage');
		// first
		var first = $.ajax({
			url : '<%=basepath%>/Empmain',
			type : 'get',
			dataType : 'json',
			data : {
				methodflag : 'queryindex',
				pagenum : "1"
			},
		}).done(function(json) {
			// 首次访问带来了参数
			iterator(json);
			console.log("success");
			$('#firstbtn').prop('disabled', true);
			$('#prebtn').prop('disabled', true);
		}).fail(function() {
			console.log("error");
		}).always(function() {
			console.log("complete");
		});

		// 封装所有button的点击事件
		$('#btns').on('click', 'button', function(event) {
			event.preventDefault();
			/* Act on the event */
			var id = this.id;
			var page = $('#currentpage').val();
		    var totalpage = parseInt($('#totalpage').val());
			//根据id改变隐藏域的page属性
			if (id.indexOf("first") != -1) {
				page = 1;
			} else if (id.indexOf("pre") != -1) {
				page = parseInt(page) - 1;
			} else if (id.indexOf("next") != -1) {
				page = parseInt(page) + 1;
			} else if (id.indexOf("last") != -1) {
				// 设一个隐藏域来保存总页数
				page = totalpage;
			}
			$('#currentpage').val(page);
			//console.log(page);

			$.get('<%=basepath%>/Empmain', {
				methodflag : "query",
				pagenum : page
			}, function(data) {

				iterator(data);
				if (page == 1) {
					// 回调函数里的this指向的是事件
					console.log(this);
					console.log(this.url);
					for (var i = 0; i < this.length; i++) {
						console.log(this[i]);
					}
					$('#firstbtn').prop('disabled', true);
					$('#prebtn').prop('disabled', true);
				} else {
					$('#firstbtn').prop('disabled', false);
					$('#prebtn').prop('disabled', false);
				}
				// 设一个隐藏域来保存总页数
				if (page == totalpage) {
					$('#lastbtn').prop('disabled', true);
					$('#nextbtn').prop('disabled', true);
				} else {
					$('#lastbtn').prop('disabled', false);
					$('#nextbtn').prop('disabled', false);
				}
			}, 'json');

		});

		// fistbtn
		/*$("#indexbtn").on('click',function(event){
			currentpage.val(1);
		    event.preventDefault();
		  
		    
		})*/
		// prebtn
		/*$("#prebtn").on('click', function(event) {
			var n = currentpage.val();
		    var pre = parseInt(n)-1;
		
		    currentpage.val(pre);
		    event.preventDefault();
		    
		    $.ajax({
		            url: '/LessonAfter27Base8.5/Empmain',
		        type: 'get',
		        dataType: 'json',
		    data: {
		        methodflag: 'query',
		        page:pre+"",
		    }
		    }).done(function(json){
		        $('tbody').children().remove();
		        iterator(json); 
		    })
			
			
			
			
		})*/
		// nextbtn
		/* $.('#nextbtn').on('click', function(event) {
			var n = currentpage.val();
			var next = parseInt(n)+1;
		
			currentpage.val(next);
			
		    event.preventDefault();
		 
		    $.ajax({
		            url: '/LessonAfter27Base8.5/Empmain',
		        type: 'get',
		        dataType: 'json',
		    data: {
		        methodflag: 'query',
		        page:next+"",
		    }
		    }).done(function(json){
		    	$('tbody').children().remove();
		        iterator(json); 
		    })
		})*/
		function iterator(argument) {
			$('tbody').children().remove();

			if (argument != null && argument.length > 0) {

				for (var i = 0; i < argument.length; i++) {

					var obj = argument[i];
					if (obj.totalpage == null) {
						var tr = "<tr><th>" + obj.id + "</th><th>" + obj.name
								+ "</th><th>" + obj.job + "</th><th>" + obj.mgr
								+ "</th><th>" + obj.hireDate + "</th><th>"
								+ obj.sal + "</th><th>" + obj.comm
								+ "</th><th>" + obj.deptNo + "</th></tr>";
						$('tbody').append(tr);
					}else{
						$('#totalpage').val(obj.totalpage);
					}

				}
			}
		}
	})
</script>
</head>
<body>
	<nav class="]nav navbar-default">
	<div class="container">
		<h1>CRUD by AJAX</h1>
	</div>
	</nav>
	<div class="container">
		<form>
			<div class="container panel panel-info">
				<!-- Default panel contents -->
				<div class="panel-heading">实现EMP表增删改查使用AJAX技术</div>
				<table class="table">
					<thead>
						<tr>
							<th>NO</th>
							<th>Name</th>
							<th>Job</th>
							<th>Mgr</th>
							<th>HireDate</th>
							<th>Sal</th>
							<th>Comm</th>
							<th>Deptno</th>
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
				<div class="container" id="btns">
					<button type="button" class="button btn-primary">查询</button>
					<input type="hidden" name="" value="1" id="totalpage">
					<input type="hidden" name="" value="1" id="currentpage">
					<button class="btn btn-warning" id="firstbtn">首页</button>
					<button class="btn btn-warning" id="prebtn">上一页</button>
					<button class="btn btn-warning" id="nextbtn">下一页</button>
					<button class="btn btn-warning" id="lastbtn">尾页</button>
				</div>

			</div>
		</form>
	</div>
</body>
</html>