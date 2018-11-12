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
<script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!--  导入Validate验证插件-->
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css" />
<script type="text/javascript">
$(function() {
	  $("#orderform").validate({
          submitHandler:function(form,event){
              if(checkform()){
            	 $.ajax({
            		 url:"${path }/orderController",
            		 data: $("#orderform").serialize() ,
            		 dataType:"json",
            		 type:"get"
            	 }).done(function(data){
            		 alert(data.message);
            	 })
            	}
            }, 
          rules:{
        	  "address":{
        		  "required":true,
        	  },
              "telephone":{
                  "required":true,
                  "rangelength":[11,11]
              },
              "name":{
                  "required":true
              }
      

          },
          messages:{
        	  "address":{
                  "required":"地址不能为空",
              },
              "telephone":{
                  "required":"手机不能为空",
                  "rangelength":"手机号位数必须是11位"
              },
              "name":{
                  "required":"姓名不能为空"
              }
           
          }
      })
})
function checkform(){
    //是否登录
    var uid = '${user.username}';
    if(uid.length==0){
        alert("未登录，请登录");
        window.location.href="login.jsp";
        return false;
    }
    return true;
}
function fn1(){
    $("#orderform").submit();
}
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
			<div style="margin: 0 auto; margin-top: 10px; width: 950px;">
				<strong>订单详情</strong>
				<table class="table table-bordered">
					<tbody>
					<c:if test="${not empty orders }">
						<tr class="warning">
							<th colspan="5">订单编号:${orders.oid }</th>
						</tr>
						<tr class="warning">
							<th>图片</th>
							<th>商品</th>
							<th>价格</th>
							<th>数量</th>
							<th>小计</th>
						</tr>
						
						  <c:forEach items="${orders.productDTOs }" var="productDto">
							  <tr class="active">
	                            <td width="60" width="40%"><input type="hidden" name="pids"
	                                value="${productDto.pid }"> <img src="${path }/${ productDto.pimage}" width="70"
	                                height="60"></td>
	                            <td width="30%"><a target="_blank"> ${productDto.pname }</a></td>
	                            <td width="20%">￥${ productDto.shopPrice}</td>
	                            <td width="10%">${ productDto.quantity}</td>
	                            <td width="15%"><span class="subtotal">￥${productDto.shopPrice * productDto.quantity },${productDTO.subtotal }</span></td>
	                        </tr>
						  </c:forEach>
						</c:if>
						
					</tbody>
				</table>
			</div>

			<div style="text-align: right; margin-right: 120px;">
				商品金额: <strong style="color: #ff6600;">￥ <c:if test="${not empty orders }">${orders.total }</c:if>元</strong>
			</div>

		</div>

		<div>
			<hr />
			<form class="form-horizontal"
                style="margin-top: 5px; margin-left: 150px;" id="orderform" action="${path }/orderController">
				<input type="hidden" name="methodflag" value="createorder">
				<input type="hidden" name="oid" value="${orders.oid }">
				<div class="form-group">
					<label for="username" class="col-sm-1 control-label">地址</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" name="address"
							placeholder="请输入收货地址" >
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-1 control-label">收货人</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" name="name"
							placeholder="请输收货人" >
					</div>
				</div>
				<div class="form-group">
					<label for="confirmpwd" class="col-sm-1 control-label">电话</label>
					<div class="col-sm-5">
						<input type="telePhone" class="form-control" name="telephone"
							placeholder="请输入联系方式" >
					</div>
				</div>
			</form>

			<hr />

			<div style="margin-top: 5px; margin-left: 150px;">
				<strong>选择银行：</strong>
				<p>
					<br /> <input type="radio" name="pd_FrpId" value="ICBC-NET-B2C"
						checked="checked" />工商银行 <img src="./bank_img/icbc.bmp"
						align="middle" />&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio"
						name="pd_FrpId" value="BOC-NET-B2C" />中国银行 <img
						src="./bank_img/bc.bmp" align="middle" />&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="pd_FrpId" value="ABC-NET-B2C" />农业银行 <img
						src="./bank_img/abc.bmp" align="middle" /> <br /> <br /> <input
						type="radio" name="pd_FrpId" value="BOCO-NET-B2C" />交通银行 <img
						src="./bank_img/bcc.bmp" align="middle" />&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="pd_FrpId" value="PINGANBANK-NET" />平安银行
					<img src="./bank_img/pingan.bmp" align="middle" />&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="pd_FrpId" value="CCB-NET-B2C" />建设银行 <img
						src="./bank_img/ccb.bmp" align="middle" /> <br /> <br /> <input
						type="radio" name="pd_FrpId" value="CEB-NET-B2C" />光大银行 <img
						src="./bank_img/guangda.bmp" align="middle" />&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="pd_FrpId" value="CMBCHINA-NET-B2C" />招商银行
					<img src="./bank_img/cmb.bmp" align="middle" />

				</p>
				<hr />
				<p style="text-align: right; margin-right: 100px;">
					
						<input type="button" width="100" value="生成订单" border="0" style="background: url('./images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
                        height:35px;width:100px;color:white;" onclick="fn1()">
				
				</p>
				<hr />

			</div>
		</div>

	</div>

	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>

</body>

</html>