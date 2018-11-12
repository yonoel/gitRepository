<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--  取得发布的项目名称-->
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员登录</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css" />
<script type="text/javascript">
	$(function() {
		$("#buydiv").on("click", 'a', function(event) {
			event.preventDefault();
			$("#quantity").val($("#quantity2").val()) ;
		    $("#addOrderitems").submit();
			//console.log("aa");
			//var num = $("#quantity").val();
			//console.log(num);
			/* $.ajax({
				url : "${path}/orderController",
				type : "post",
				data : {
					methodflag : "doOrderitems",
					pid : "${object.pid}",
					quantity : num
				},
				dataType : "json"
			}).done(function(data) {
				if (data) {
					window.location.href = "${path}/cart.jsp";
				} else {
					alert("购买失败");
				}
			}) */
			
		})
	})
</script>

<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}
</style>
</head>

<body>
	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div
				style="border: 1px solid #e4e4e4; width: 930px; margin-bottom: 10px; margin: 0 auto; padding: 10px; margin-bottom: 10px;">
				<a href="${path }/index.jsp">首页&nbsp;&nbsp;&gt;</a> <a
					href="${path }/mainController?methodflag=queryProductInfo&pid=${object.pid}">${object.pname }&nbsp;&nbsp;&gt;</a>
				<a>无公害蔬菜</a>
			</div>

			<div style="margin: 0 auto; width: 950px;">
				<div class="col-md-6">
					<img style="opacity: 1; width: 400px; height: 350px;" title=""
						class="medium" src="${path}/${object.pimage}">
				</div>

				<div class="col-md-6">
					<!-- 其实表单嵌套更好 -->
				
					<form action="${path}/orderController" method="post" id="addOrderitems">
						<input type="hidden" name="methodflag" value="addOrderitems" /> 
						<input type="hidden" name="pid" value="${object.pid}" />
						<input type="hidden" name="pname" value="${object.pname }"/>
						<input type="hidden" name="pimage" value="${object.pimage }"/>
						<input type="hidden" name="shopPrice" value="${object.shopPrice }"/>	
						<input type="hidden" name="quantity" value="1" id="quantity"/>
					</form>
					<div>
						<strong>${object.pname }</strong>
					</div>
					<div
						style="border-bottom: 1px dotted #dddddd; width: 350px; margin: 10px 0 10px 0;">
						<div>${object.pid }</div>
					</div>

					<div style="margin: 10px 0 10px 0;">
						亿家价: <strong style="color: #ef0101;">￥：${object.shopPrice }元/份</strong>
						参 考 价：
						<del>￥${object.marketPrice }元/份</del>
					</div>

					<div style="margin: 10px 0 10px 0;">
						促销: <a target="_blank" title="限时抢购 (2014-07-30 ~ 2015-01-01)"
							style="background-color: #f07373;">${object.shopPrice }</a>
					</div>

					<div
						style="padding: 10px; border: 1px solid #e7dbb1; width: 330px; margin: 15px 0 10px 0;; background-color: #fffee6;">
						<div style="margin: 5px 0 10px 0;">白色</div>

						<div
							style="border-bottom: 1px solid #faeac7; margin-top: 20px; padding-left: 10px;">
							购买数量: <input id="quantity2" name="quantity" value="1"
								maxlength="4" size="10" type="text">
						</div>

						<div style="margin: 20px 0 10px 0;; text-align: center;"
							id="buydiv">
							<a href="javascript:void(0)"> <input
								style="background: url('./images/product.gif') no-repeat scroll 0 -600px rgba(0, 0, 0, 0); height: 36px; width: 127px;"
								value="加入购物车" type="button">
							</a> &nbsp;收藏商品
						</div>
					</div>
					<div>
						<a
							href="${path }/mainController?methodflag=queryCategoryInfo&cid=${object.cid}">返回商品列表</a>
					</div>

				</div>

			</div>
			<div class="clear"></div>
			<div style="width: 950px; margin: 0 auto;">
				<div
					style="background-color: #d3d3d3; width: 930px; padding: 10px 10px; margin: 10px 0 10px 0;">
					<strong>商品介绍</strong> ${object.pdesc }
				</div>

				<div>
					<img
						src="image/r___________renleipic_01/bigPic139f030b-d68b-41dd-be6d-b94cc568d3c5.jpg">
				</div>

				<div
					style="background-color: #d3d3d3; width: 930px; padding: 10px 10px; margin: 10px 0 10px 0;">
					<strong>商品参数</strong>
				</div>
				<div style="margin-top: 10px; width: 900px;">
					<table class="table table-bordered">
						<tbody>
							<tr class="active">
								<th colspan="2">基本参数</th>
							</tr>
							<tr>
								<th width="10%">级别</th>
								<td width="30%">标准</td>
							</tr>
							<tr>
								<th width="10%">标重</th>
								<td>500</td>
							</tr>
							<tr>
								<th width="10%">浮动</th>
								<td>200</td>
							</tr>
						</tbody>
					</table>
				</div>

				<div style="background-color: #d3d3d3; width: 900px;">
					<table class="table table-bordered">
						<tbody>
							<tr class="active">
								<th><strong>商品评论</strong></th>
							</tr>
							<tr class="warning">
								<th>暂无商品评论信息 <a>[发表商品评论]</a></th>
							</tr>
						</tbody>
					</table>
				</div>

				<div style="background-color: #d3d3d3; width: 900px;">
					<table class="table table-bordered">
						<tbody>
							<tr class="active">
								<th><strong>商品咨询</strong></th>
							</tr>
							<tr class="warning">
								<th>暂无商品咨询信息 <a>[发表商品咨询]</a></th>
							</tr>
						</tbody>
					</table>
				</div>
			</div>

		</div>
	</div>


	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>

</body>

</html>