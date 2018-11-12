<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=request.getContextPath()%>"></c:set>
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
	//注册事件
	$(function() {
		// 第一次页面触发
		$(query());
		// 其他按钮触发导致参数不同，回调函数不同，我觉得不如写个全局函数判断
		$('#firstbtn').click(function() {
			$('#footcurrent').html(1);
			query();

		});
		// 前一页按钮
		$('#prebtn').click(function() {
			var value = $('#footcurrent').html();
			var val = parseInt(value) - 1;
			$('#footcurrent').html(val);
			query();
		});
		// 后一页按钮
		$('#nextbtn').click(function(event) {
			var value = $('#footcurrent').html();
			var val = parseInt(value) + 1;
			$('#footcurrent').html(val);
			
			query();
		});
		// 尾页
		$('#lastbtn').click(function(event) {
			$('#footcurrent').html($('#foottotal').html());
			query();
		});

		// 1.取参数的方法 发现取这个pagenum很难，不如把pageNum也放到表单里提交--->这样取参数无法简便的封装对象，封装过度  放弃这个方法
		function getArguments() {
			// body... 
			var formParams = $('#queryform').serialize();
			var currentPage = "&pageNum=" + $('#footcurrent').html();
			// var arr =[formParams,currentPage];
			//console.log("上交的参数"+arr);
			formParams = formParams + currentPage;
			console.log("上交的参数" + formParams);
			return formParams;
		}
		$('#footcurrent').change(function(event) {
			console.log('footcurrent' + 改变);

			$('#footcurrent').html();
		});
		// 2.查询方法

		function query() {
			$.ajax({
				url : '${path}/main/query',
				type : 'get',
				dataType : 'json',
				data : {
					data : $('#queryform').serialize(),
					pageNum:$('#footcurrent').html(),
				},
			}).done(function(data) {
				// 取回来的数据是undifined但是成功了。。。

				//console.log(data.flag);
				// true会直接转换成Boolean类型。。
				if (data.flag) {
					doTrueResult(data);
				}

			}).fail(function() {
				console.log("error");
			}).always(function() {
				console.log("complete");
			});
			/*$.get('${path}/main/query',getArguments, function(data) {
			  
			   console.log('success');
			   console.log(data);
			},'json');*/
		}

		function doTrueResult(data) {
			// 修改总页数
			// 修改总页数
			$('#foottotal').html(data.pages);
			// 生成列表
			var objs = data.emp;
			console.log(objs.count);
			$('#listable tbody').children().remove();
			//console.log(objs.length);
			console.log(objs);
			for (var i = 0; i < objs.length; i++) {
				var obj = objs[i];
				console.log(obj);
				var thing = "<tr><td>" + obj.empno + "</td><td>" + obj.ename
						+ "</td><td>" + obj.sex + "</td><td>" + obj.hobbies
						+ "</td><td>" + obj.job + "</td><td>" + obj.hiredate
						+ "</td><td>" + obj.sal + "</td><td>" + obj.comm
						+ "</td><td>" + obj.deptno + "</td><td>" + obj.mgr
						+ "</td><td></tr>";
				$("#listable tbody").append(thing);

			}
			console.log('tbody');
			// 处理按钮disable的函数
			disableIndex();
			disableLast();
		}

		function disableIndex() {
			var value = $('#footcurrent').html();
			//console.log(value.length);
			if (value == 1) {
				console.log('index');
				$('#firstbtn').prop('disabled', true);
				$('#prebtn').prop('disabled', true);
			} else {
				console.log('not index');
				$('#firstbtn').prop('disabled', false);
				$('#prebtn').prop('disabled', false);
			}
		}

		function disableLast() {
			var value = $('#footcurrent').html();
			var last = $('#foottotal').html();
			if (value == last) {
				$('#nextbtn').prop('disabled', true);
				$('#lastbtn').prop('disabled', true);
			} else {
				$('#nextbtn').prop('disabled', false);
				$('#lastbtn').prop('disabled', false);
			}
		}
	})
</script>
</head>

<body>
	<nav class="nav navbar-default text-center">
		<h1>欢迎来到职员管理界面</h1>
	</nav>
	<div class="container">
		<form id="queryform">
			<div class="form-group form-inline">
				姓名: <input type="text" name="empName" value="" placeholder=""
					class="form-control"> 入职日期: <input type="text"
					name="startdate" value="" placeholder="" class="form-control">~
			</div>
			<!--<input type="hidden" name="pageNum" value="1" id="formpage" /> -->
		</form>
		<table class="table" id="listable">
			<thead>
				<tr>
					<th>编号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>兴趣爱好</th>
					<th>职业</th>
					<th>入职日期</th>
					<th>工资</th>
					<th>奖金</th>
					<th>部门</th>
					<th>上司姓名</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4">
						<h5>
							每页十条数据,当前<span id="footcurrent">1</span>页,共<span id="foottotal">x</span>页
						</h5>
					</td>
					<td colspan="7" class="text-right">
						<button class="btn btn-warning" id="firstbtn">首页</button>
						<button class="btn btn-warning" id="prebtn">上一页</button>
						<button class="btn btn-warning" id="nextbtn">下一页</button>
						<button class="btn btn-warning" id="lastbtn">尾页</button>
					</td>
				</tr>
			</tfoot>
		</table>
	</div>
</body>

</html>