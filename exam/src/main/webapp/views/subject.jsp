<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--  取得发布的项目名称-->
<c:set var="proname" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>main</title>
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="viewport" content="width=device-width,init-scale=1">
<script src="webjars/jquery/3.2.1/dist/jquery.min.js"></script>
<script src="webjars/vue/2.5.13/dist/vue.min.js"></script>
<link
	href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.css
"
	rel="stylesheet" />
<link href="webjars/bootstrap/3.3.4/dist/css/bootstrap-theme.min.css"
	rel="stylesheet" type="text/css" />
<%-- <link href="${proname }/resources/css/AdminLTE.min.css" rel="stylesheet" />
<link href="${proname }/resources/css/_all-skins.min.css" rel="stylesheet" />
<link href="${proname }/resources/css/console.css" rel="stylesheet" />
<link href="${proname }/resources/css/font-awesome.min.css" rel="stylesheet" /> --%>
<script src="${proname }/resources/js/subject.js"></script>
<style type="text/css" media="screen">
ul {
	list-style: none;
}
</style>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="col-md-10" id="subjectbox">
		<div id="btnbox" class="btn-group pull-right">
			<button class="btn btn-default" type="button" id="addsubjectbtn">增加</button>
			<button class="btn btn-default" type="button" id="modsubjectbtn">修改</button>
			<button class="btn btn-default" type="button" id="delsubjectbtn">删除</button>
			<a class="btn btn-default" href="tosubject" role="button">查询全部</a>
		</div>
		
		<div id="databox">
		<h2>题目信息一览</h2>
			<div>
				<form action="" id="queryform">
					<table id="querytable" class="table table-bordered">
						<tr>
							<td>题目编号：<input type="text" name="subno" value=""
								id="queryid" /></td>
							<td>题目类型：</td>
							<td><select name="subType" id="seltype">
									<option value="null">请选择</option>
							</select></td>
							<td>题目难度:</td>
							<td align="center"><select name="difficulty" id="seldiff">
									<option value="null">请选择</option>
							</select></td>
							<td><button id="querybtn" type="button" />查询</td>
						</tr>
					</table>
				</form>
			</div>
			<div>
			 <form id="deleteform">
				<table class="table table-hover" id="subjecttable">
					<tr>
						<td align="center" width="40"><input type="checkbox"
							title="全选/全不选" onclick="checkall(this)" /></td>
						<td width="100">题号</td>
						<td width="100">题目类型</td>
						<td width="100">难度</td>
						<td width="700">内容</td>
					</tr>
				</table>
				</form>
			</div>

			<nav>
				<ul class="pager">
					<input type="hidden" name="pagenum" value="1" id="pagenum" />
					<input type="hidden" name="pages" id="pages" />
					<li id="pre"><a href="#">Previous</a></li>
					<li id="next"><a href="#">Next</a></li>
				</ul>
			</nav>

		</div>
		<div id="addbox">
		  <h2 id="subjecttitle">新增题目</h2>
			<form id="subjectform" class="form-horizontal">
			         <input type="hidden" value="" id="methodflag" name="methodflag"/>
					<div class="form-group form-inline" style="display:none;" id="modbox">
		                  <label for="subNo" class="col-sm-2 control-label"> 题目编号：</label> 
		                  <input type="text" class="form-control" name="subNo"
                            placeholder="subNo">
		            </div>
		            
		       
		            
				<div class="form-group dropdown">
					<label for="subContent" class="col-sm-2 control-label">题目类型：</label> 
						<div>
							<select name="subType" class="form-inline">
		                        <option value="null">请选择</option>
		                    </select>
						</div>
						
				</div>
				<div class="form-group dropdown">
					<label for="subContent" class="col-sm-2 control-label">题目难度:</label> 
						<select name="difficulty" class="form-inline">
						<option value="null">请选择</option>
					</select>
				</div>
				<div class="form-group">
					<label for="subContent" class="col-sm-2 control-label">题目正文：</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="subContent"
							placeholder="题目正文">
					</div>
				</div>
				<div class="form-group">
					<label for="optiona" class="col-sm-2 control-label">optiona：</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="optiona"
							placeholder="optiona">
					</div>
				</div>
				<div class="form-group">
					<label for="optionb" class="col-sm-2 control-label">optionb：</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="optionb"
							placeholder="optionb">
					</div>
				</div>
				<div class="form-group">
					<label for="optionc" class="col-sm-2 control-label">optionc：</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="optionc"
							placeholder="optionc">
					</div>
				</div>
				<div class="form-group">
					<label for="optiond" class="col-sm-2 control-label">optiond：</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="optiond"
							placeholder="optiond">
					</div>
				</div>
				<div class="form-group">
					<label for="answer" class="col-sm-2 control-label">answer：</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="answer"
							placeholder="answer">
					</div>
				</div>
				<div class="form-group">
					<label for="subAnalysis" class="col-sm-2 control-label">subAnalysis：</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="subAnalysis"
							placeholder="subAnalysis">
					</div>
				</div>
				<div class="form-group pull-right">
				    <button type="button" value="" id="addsubject">确认</button>
				</div>
               
			</form>
		</div>
</body>
</html>