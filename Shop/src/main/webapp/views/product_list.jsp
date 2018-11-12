<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--  取得发布的项目名称-->
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员登录</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css" />

<style>
body {
	margin-top: 20px;
	margin: 0 auto;
	width: 100%;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}
</style>
<script type="text/javascript">
 $(function(){
	 $("#pageul li").on('click','a',function(){
		 event.preventDefault();
		var pages = parseInt("${pages}");
	
		var locataiontag = $(this).html();
		var tagnum;
		 var id;
		//console.log("pagenum:"+pagenum+",length"+pagenum.length);
		//console.log("locataiontag:"+locataiontag+",length"+locataiontag.length+","+parseInt(locataiontag));
		//console.log( $(this).parent()[0].id);
		
		  // 首先考虑点击的到底是哪一个按钮 --- >激活当前按钮
		  if(!isNaN(locataiontag)){
			  tagnum = parseInt(locataiontag);
			  $(this).parent().addClass("active").siblings().removeClass("active");
		  }else{
			  // 说明触发的是前后按钮--->直接从激活按钮那获取pagenum
			   // 取激活按钮的位置
			  var index = $("#pageul li[class='active']").index();
			
			  id = $(this).parent()[0].id;
			  // 向前
			  if(id.indexOf("pre") != -1){
				  //console.log('a');
				    // 
				
				  if(index != 1){
					   index = index -2;
					  //console.log( $("#pageul li").eq(($("#pageul li[class='active']").index()-1)));
					  $("#pageul li").eq(index).addClass("active").siblings().removeClass("active");
					  tagnum = index;
				  }else{
					  $("#pageul li").eq(1).addClass("active").siblings().removeClass("active");
					  tagnum = 1;
				  }
				
			  }else if(id.indexOf("next") != -1){
				
				  if(index != pages){
					  //console.log( $("#pageul li").eq(($("#pageul li[class='active']").index()+1)));
                      $("#pageul li").eq(index).addClass("active").siblings().removeClass("active");
                      tagnum = index;
				  }else{
					  $("#pageul li").eq(pages).addClass("active").siblings().removeClass("active");
					  tagnum = pages;
				  }
				
			  }
			 /*  console.log("index"+index);
			  console.log("tagnum"+tagnum); */
		  }
		  
		  //console.log(  $("#pageul li[class='active']").index());
		  
		  //console.log( "indexOf:" + (locataiontag.indexOf("${pages}") != -1));
		  //  disabled
		  if(tagnum == 1){
			  $("#pageul li:first").addClass("disabled").siblings().removeClass("disabled");
		  }else if(tagnum == pages){
			  $("#pageul li:last").addClass("disabled").siblings().removeClass("disabled");
		  }
		
         // 接下来就是ajax方法了
        $.get("${path}/mainController",{
                methodflag:"queryProductsPages",
                pagenum:tagnum,
                cid: "${cid}"
         },function(data){
            if(data != null){
            	
            	
            	iterator(data);
            }
         },'json') 
		 
	 })
 })
 function iterator(objs){
	 $("#productslist div").remove(":not(:first)");
	console.log(objs.length);
	  for (var i = 0; i < objs.length; i++) {
		var div = "<div class='col-md-2' style='height:240px'><a href='mainController?methodflag=queryProductInfo&pid="
				+objs[i].pid+"'> <img src='${path}/"
				+objs[i].pimage+"' width='170' height='170'"
        +"style='display: inline-block;'></a><p><a href='mainController?methodflag=queryProductInfo&pid="
        +objs[i].pid+"' style='color: green'>"
        +objs[i].pname+"</a></p><p><font color=''#FF0000'>商城价：&yen;"+objs[i].shopPrice
        + "</font></p></div>";
        console.log(div);
        $("#productslist").append(div);
	} 
 }
 
</script>
</head>

<body>
	<!-- <c:if test="${cid != null}">
        <input type="hidden" name="cid" id="cid" value="${cid }">
    </c:if> -->


	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>


	<div class="row" style="width: 1210px; margin: 0 auto;" id="productslist">
		<div class="col-md-12">
			<ol class="breadcrumb">
				<li><a href="#">首页</a></li>
			</ol>
		</div>

		<c:if test="${not empty list }">
			<!--  ,cid:${cid },pages :${pages },size :${pageSize } -->

			<c:forEach items="${list}" var="product" >
				<div class="col-md-2" style="height:240px">
					<a href="mainController?methodflag=queryProductInfo&pid=${product.pid }"> <img
						src="${path}/${product.pimage}" width="170" height="170"
						style="display: inline-block;">
					</a>
					<p>
						<a href="mainController?methodflag=queryProductInfo&pid=${product.pid }" style='color: green'>${product.pname }</a>
					</p>
					<p>
						<font color="#FF0000">商城价：&yen;${product.shopPrice }</font>
					</p>
				</div>
			</c:forEach>
		</c:if>




	</div>

	<!--分页 -->
	<div style="width: 380px; margin: 0 auto; margin-top: 50px;">
	   
		<ul class="pagination" style="text-align: center; margin-top: 10px;" id="pageul">
		 
			<li class="disabled" id="prepage"><a href="#" aria-label="Previous">&laquo;</a></li>
					
			<li class="active"><a href="#">1</a></li>
			<c:if test="${pages > 1 }">
			 <c:forEach varStatus="s" end="${pages }" begin="2">
			     <li><a href="#">${s.index}</a></li>
			 </c:forEach>
			</c:if>
			<li id="nextpage"><a href="#" aria-label="Next">&raquo;
			</a></li>
		</ul>
	</div>
	<!-- 分页结束 -->

	<!--商品浏览记录-->
	<div
		style="width: 1210px; margin: 0 auto; padding: 0 9px; border: 1px solid #ddd; border-top: 2px solid #999; height: 246px;">

		<h4 style="width: 50%; float: left; font: 14px/30px 微软雅黑">浏览记录</h4>
		<div style="width: 50%; float: right; text-align: right;">
			<a href="">more</a>
		</div>
		<div style="clear: both;"></div>

		<div style="overflow: hidden;">
		  <ul style="list-style: none;">
            <c:if test="${not empty history }">
                <c:forEach items="${history }" var="his"> 
                    <li
                    style="width: 150px; height: 216; float: left; margin: 0 8px 0 0; padding: 0 18px 15px; text-align: center;"><img
                    src="${path }/${his.pimage}" width="130px" height="130px" />
                    </li>
                </c:forEach>
            </c:if>
		
				
			</ul>

		</div>
	</div>


	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>

</body>

</html>