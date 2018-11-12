<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--  取得发布的项目名称-->
<c:set var="proname" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<script src="https://cdn.bootcss.com/jquery-json/2.6.0/jquery.json.min.js"></script>
<script src="${proname }/resources/js/My97DatePicker/WdatePicker.js"></script>
<script src="${proname }/resources/js/paper.js"></script>
<script src="${proname }/resources/js/json2.js"></script>
<title>Insert title here</title>
<style type="text/css" media="screen">
ul {
	list-style: none;
}
</style>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="col-md-10" id="paperbox">

		<div id="btnbox" class="btn-group pull-right">
			<button class="btn btn-default" type="button" id="addpaperbtn">新增试卷</button>
			<button class="btn btn-default" type="button" id="modpaperbtn">修改试卷</button>
			<button class="btn btn-default" type="button" id="autopaperbtn">智能出卷</button>
			<button class="btn btn-default" type="button" id="setsubjectbtn">试题设置</button>
			<button class="btn btn-default" type="button" id="delpaperbtn">删除试卷</button>
			<a class="btn btn-default" href="totestpaper" role="button">查询全部试卷</a>
		</div>
		<div id="databox">
			<h2>试卷信息一览</h2>
			<form id="dataform">
				<table class="table table-hover" id="papertable">
					<tr>
						<td align="center" width="40"><input type="checkbox"
							title="全选/全不选" onclick="checkall(this)" /></td>
						<td width="100">试卷名称</td>
						<td width="500">时间</td>
						<td width="200">总时长</td>
						<td width="200">发布时间</td>
						<td width="100">总分</td>
					</tr>
				</table>

				<nav>
				<ul class="pager">
					<input type="hidden" name="pagenum" value="1" id="pagenum" />
					<input type="hidden" name="pages" id="pages" />
					<li id="pre"><a href="#">Previous</a></li>
					<li id="next"><a href="#">Next</a></li>
				</ul>
				</nav>
			</form>
		</div>
		<div id="addbox" class="col-md-6">
			<h2 id="papertitle">新增试卷</h2>
			<form id="paperform" class="form-horizontal">

				<input type="hidden" value="" id="methodflag" name="methodflag" />
				<input type="hidden" id="testno" name="testno"> <input
					type="hidden" id="testtime" name="testtime">
				<div class="form-group form-inline">
					<label for="testname" class="col-sm-2 control-label"> 试卷名称：</label>
					<input type="text" class="form-control" name="testname"
						id="testname" placeholder="testname">
				</div>
				<div class="form-group form-inline">
					<label for="tstart" class="col-sm-2 control-label"> 开始时间：</label> <input
						type="text" class="form-control" name="tstart"
						onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" id="tstart"
						onchange="gettesttime()" placeholder="tstart">
				</div>
				<div class="form-group form-inline">
					<label for="tend" class="col-sm-2 control-label"> 结束时间：</label> <input
						onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
						onchange="gettesttime()" type="text" class="form-control"
						name="tend" placeholder="tend" id="tend">
				</div>

				<div class="form-group form-inline">
					<label for="announcetime" class="col-sm-2 control-label">
						发布时间：</label> <input type="text" class="form-control" name="announcetime"
						onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
						id="announcetime" placeholder="announcetime">

				</div>
				<div class="form-group">
					<button type="button" id="addpaper">确认</button>
					<button type="reset" id="resetbtn">重置</button>
				</div>

			</form>
		</div>
		<div id="autopaperbox" class="col-md-6">
			<h2>智能出卷</h2>
			<!--   一个新增按钮 -->
			<div class="btn-group">
				<button type="button" id="newsubject">新增栏目</button>
			</div>
			<div id="autopaperdiv">
				
					<table id="autopapertable" class="table">
					   <tbody>
						<tr>
							<td>题目类型：</td>
							<td><select name="subType" id="seltype">
									<option value="null">请选择</option>
							</select></td>
							<td>题目难度:</td>
							<td align="center"><select name="difficulty" id="seldiff">
									<option value="null">请选择</option>
							</select></td>
							<td>题目数量：</td>
							<td><input type="text" name="subjectnum" ></td>
							<td>每题分值：</td>
							<td><input type="text" name="subjectscore"
								></td>
							<td><button onclick="deleteparent(this)">删除</button></td>
						</tr>
						</tbody>
					</table>
					<div class="btn-group">
						<button type="button" id="newpaper">确认</button>
						<button type="reset">重置</button>
					</div>
			</div>
		</div>
		<div id="setsubjectbox" class="col-md-6">
		  <h2>试题设置</h2>
		     <h3></h3>
		   <h5>考试开始</h5>
		</div>
	</div>
</body>
</html>