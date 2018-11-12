<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--  取得发布的项目名称-->
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>极客商城购物车</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css" />
<style>
body {
                margin-top: 20px;
                margin: 0 auto;
            }
            
            .carousel-inner .item img {
                width: 100%;
                height: 300px;
            }
            
            font {
                color: #3164af;
                font-size: 18px;
                font-weight: normal;
                padding: 0 10px;
            }
            
            .astyle{
                text-decoration:none;
                display:inline-block;
                width:20px;
                height:24px;
                border:1px solid #A9A9A9;
                vertical-align:bottom;
                text-align:center;
            }
            
            .astyle:link{
                text-decoration:none;
            }
            
            input[name='quantity']{
                width:40px;
                text-align:center;
                border:1px solid #A9A9A9;
                border-left:none;
                border-right:none
            }
</style>
<script type="text/javascript">
$(function(){
	// 没有效果，测试一下,
	/* $("input[id^='quantity']").on("change",function(event){
		event.preventDefault();
        
		   alert("mesg");
		changetotal(this);
	}) */
	
	$("#cartform").submit(function(){
		
		var length = $("#cartform input:checked").length;
		
		if(length <= 0){
			alert("没有勾选商品，不能提交");
			return false;
		}
		return true;
	});
})
function addquantity(id) {
	
	//console.log(id);
	$(id).val(parseInt($(id).val())+1);
	changetotal(id);
}
function reducequantity(obj,id) {
	var quantity = parseInt($(id).val());
	//console.log(quantity-1);
	if(quantity == 1){
		clearProduct(obj);
	}else {
		$(id).val(quantity-1);
	}
	changetotal(id);
}

function clearProduct(argument){
	console.log($(argument).parents("tr").length);
	$(argument).parents("tr").remove();
}

function changetotal(obj){
	var id = obj;
	//console.log(id);
	// 总计
	var totaltag = "#subtotal"+id.substring(id.indexOf("quantity")+8,id.length);
	// 单价的标签
	var pricetag = "#shopPrice"+id.substring(id.indexOf("quantity")+8,id.length);
	var price = parseFloat($(pricetag).val());
	//console.log(total);
	//console.log($(total).length);
	// 按理说是应该判断数值长度然后补齐
	$(totaltag).html(price*parseFloat($(id).val())+".0");
}
</script>
</head>

<body>
	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>

	<div class="container">
	 <form action="${path }/orderController" id="cartform">
	   <input type="hidden" name="methodflag" value="confirmorderitems">
	  
		<div class="row">
           
			 <div style="margin: 0 auto; margin-top: 10px; width: 950px;">
				<strong style="font-size: 16px; margin: 5px 0;">订单详情</strong>
				<table class="table table-bordered">
					<tbody>
						<tr class="warning">
						    <th></th>
							<th>图片</th>
							<th>商品</th>
							<th>价格</th>
							<th>数量</th>
							<th>小计</th>
							<th>操作</th>
						</tr>
                       
                            <c:forEach items="${orderList }" var="ordersDto">
                               <input type="hidden" name="oids" value="${ordersDto.oid }">
                                <c:forEach items="${ordersDto.productDTOs }" var="productDto">
	                                <tr class="active">
	                                <input type="hidden" id="shopPrice${ productDto.pid}" value="${productDto.shopPrice }" name="shopPrice">
	                                  <td ><input type="checkbox" value="${ productDto.pid}" name="pid"></td>
			                            <td  width="20%"><input type="hidden" name="pimage"  value="${ productDto.pimage}"> 
			                                <img src="${path }/${ productDto.pimage} " width="70"
			                                height="60"></td>
			                            <td width="20%"><input type="hidden" name="pname"  value="${productDto.pname }"><a target="_blank"> ${productDto.pname }</a></td>
			                            <td width="10%">￥${productDto.shopPrice }</td>
			                            <td width="25%">                                             
			                                 <a class="astyle" href="javascript:void(0)" onclick="reducequantity(this,'#quantity${ productDto.pid}')">-</a><input type="text"  id="quantity${ productDto.pid}" name="quantity" value="${productDto.quantity}">
			                                 <a class="astyle" href="javascript:void(0)" onclick="addquantity('#quantity${ productDto.pid}')">+</a></td>
			                            <td width="15%">￥<span class="subtotal" id="subtotal${ productDto.pid}">${productDto.shopPrice * productDto.quantity }</span></td>
			                            <td><a href="javascript:(0);" class="delete" onclick="clearProduct(this)">删除</a></td>
			                        </tr>
                                </c:forEach>  
                            </c:forEach>
                      
						
					</tbody>
				</table>
			</div>
		</div>

		<div style="margin-right: 130px;">
			<div style="text-align: right;">
				<em style="color: #ff6600;"> 登录后确认是否享有优惠&nbsp;&nbsp; </em> 赠送积分: <em
					style="color: #ff6600;">596</em>&nbsp; 商品金额: <strong
					style="color: #ff6600;">￥<span id="total">596.00元</strong>
			</div>
			<div
				style="text-align: right; margin-top: 10px; margin-bottom: 10px;">
				<a href="order_info.htm" id="clear" class="clear">清空购物车</a> <a
					href="order_info.htm"> 
					<input type="submit" width="100"  border="0"
					style="background: url('./images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
				</a>
			</div>
		</div>
       </form>
	</div>

	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>

</body>

</html>