<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String basepath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>极客商城首页</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		// 查询最热商品
		$.ajax({
            url:"<%=basepath%>/mainController",
            type:'get',
            dataType:'json',
            data:{
                methodflag:"queryHotProducts",
                pageNum:"1",
                pageSize:"9",
            }
        }).done(function(data){
            //console.log(data);
            var flag = data.flag;
            if(flag){
            	
                var objs = data.object;
                 for (var i = 0; i < objs.length; i++) {
                    var thing =   "<div class='col-md-2' style='text-align: center; height: 200px; padding: 10px 0px;'><a href='product_info.jsp'> <img src='<%=basepath%>/"+objs[i].pimage+"' width='130' height='130'" 
                    +" style='display: inline-block;'></a><p><a href='product_info.jsp' style='color: #666'>"+objs[i].pname
                    +"</a></p><p><font color='#E4393C' style='font-size: 16px'>&yen;"+objs[i].shopPrice+"</font></p></div>";
                    $("#hotproducts").append(thing);
                } 
            }
        })
		// 查询最新商品
        $.ajax({
            url:"<%=basepath%>/mainController",
            type:'get',
            dataType:'json',
            data:{
                methodflag:"queryNewProducts",
                pageNum:"1",
                pageSize:"9",
            }
        }).done(function(data){
            //console.log(data);
            var flag = data.flag;
            if(flag){
                
                var objs = data.object;
                 for (var i = 0; i < objs.length; i++) {
                    var thing =   "<div class='col-md-2' style='text-align: center; height: 200px; padding: 10px 0px;'><a href='product_info.jsp'> <img src='<%=basepath%>/"+objs[i].pimage+"' width='130' height='130'" 
                    +" style='display: inline-block;'></a><p><a href='product_info.jsp' style='color: #666'>"+objs[i].pname
                    +"</a></p><p><font color='#E4393C' style='font-size: 16px'>&yen;"+objs[i].shopPrice+"</font></p></div>";
                    $("#newProducts").append(thing);
                } 
            }
        })
	})
</script>
</head>

<body>
	<div class="container-fluid">

		<!-- 引入header.jsp -->
		<jsp:include page="/header.jsp"></jsp:include>

		<!-- 轮播图 -->
		<div class="container-fluid">
			<div id="carousel-example-generic" class="carousel slide"
				data-ride="carousel">
				<!-- 轮播图的中的小点 -->
				<ol class="carousel-indicators">
					<li data-target="#carousel-example-generic" data-slide-to="0"
						class="active"></li>
					<li data-target="#carousel-example-generic" data-slide-to="1"></li>
					<li data-target="#carousel-example-generic" data-slide-to="2"></li>
				</ol>
				<!-- 轮播图的轮播图片 -->
				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<img src="img/1.jpg">
						<div class="carousel-caption">
							<!-- 轮播图上的文字 -->
						</div>
					</div>
					<div class="item">
						<img src="img/2.jpg">
						<div class="carousel-caption">
							<!-- 轮播图上的文字 -->
						</div>
					</div>
					<div class="item">
						<img src="img/3.jpg">
						<div class="carousel-caption">
							<!-- 轮播图上的文字 -->
						</div>
					</div>
				</div>

				<!-- 上一张 下一张按钮 -->
				<a class="left carousel-control" href="#carousel-example-generic"
					role="button" data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#carousel-example-generic"
					role="button" data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
		</div>

		<!-- 热门商品 -->
		<div class="container-fluid">
			<div class="col-md-12">
				<h2>
					热门商品&nbsp;&nbsp;<img src="img/title2.jpg" />
				</h2>
			</div>
			<div class="col-md-2"
				style="border: 1px solid #E7E7E7; border-right: 0; padding: 0;">
				<img src="products/hao/big01.jpg" width="205" height="404"
					style="display: inline-block;" />
			</div>
			<div class="col-md-10" id="hotproducts">
				<div class="col-md-6"
					style="text-align: center; height: 200px; padding: 0px;">
					<a href="product_info.jsp"> <img
						src="products/hao/middle01.jpg" width="516px" height="200px"
						style="display: inline-block;">
					</a>
				</div>
			

				
			</div>
		</div>

		<!-- 广告条 -->
		<div class="container-fluid">
			<img src="products/hao/ad.jpg" width="100%" />
		</div>

		<!-- 最新商品 -->
		<div class="container-fluid">
			<div class="col-md-12">
				<h2>
					最新商品&nbsp;&nbsp;<img src="img/title2.jpg" />
				</h2>
			</div>
			<div class="col-md-2"
				style="border: 1px solid #E7E7E7; border-right: 0; padding: 0;">
				<img src="products/hao/big01.jpg" width="205" height="404"
					style="display: inline-block;" />
			</div>
			<div class="col-md-10" id="newProducts">
				<div class="col-md-6"
					style="text-align: center; height: 200px; padding: 0px;">
					<a href="product_info.jsp"> <img
						src="products/hao/middle01.jpg" width="516px" height="200px"
						style="display: inline-block;">
					</a>
				</div>

				
			</div>
		</div>

		<!-- 引入footer.jsp -->
		<jsp:include page="/footer.jsp"></jsp:include>

	</div>
</body>

</html>