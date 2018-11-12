<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:set var="proname" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'empinfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		#querytable{
			width:1000px;
			border:1px solid #000;
			border-collapse: collapse;
			border-bottom:none;
		}
		
		#querytable td{
			border:1px solid #000;
			border-bottom:none;
		}
		
		#querytable input[type=text]{
			width:100px;
		}
		
		#datatable{
			width:1000px;
			border:1px solid #000;
			border-collapse: collapse;
		}
		
		#datatable td{
			border:1px solid #000;
		}
		
		#pydiv{
			width:998px;
			border:1px solid #000;
			border-top:none;
			height:25px;
			line-height:25px;
		}
		
		#pyimgagediv{
			float: right;
			margin-right:5px;
			/* margin-top:3px; */
		}
	</style>
	<script type="text/javascript" src="${proname}/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${proname}/js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		$(function(){
			//设置下拉框的值
			$("#deptnolike").val("${selemp.deptno}");
			
			//发送ajax做页面的查询操作
			ajaxquery(1);
		});
		
		function add(){
			//员工新增跳转
			window.location.href="${proname}/ftl/emp/addto.action";
			//部门新增跳转
			//window.location.href="${proname}/ftl/dept/addto.action";
		}
		
		function edit(){
			var empnoobjects = $("input[name=empnos]:checked");
			//点击修改时，必须选择table中的checkbox
			//未选择报错
			if(empnoobjects.length==0){
				alert("请勾选数据");
				return;
			}
			//多选报错
			if(empnoobjects.length>1){
				alert("请选择一条数据");
				return;
			}
			//修改只能选择一条数据
			window.location.href="${proname}/ftl/emp/updateto.action?empno="+empnoobjects.val();
		}
		
		function del(){
			var empnoobjects = $("input[name=empnos]:checked");
			//点击修改时，必须选择table中的checkbox
			//未选择报错
			if(empnoobjects.length==0){
				alert("请勾选数据");
				return;
			}
			var flag = window.confirm("你确定要删除此数据吗？");
			if(flag){
				/*var empnos = "";
				for(var i=0;i<empnoobjects.length;i++){
					var empnoobject = empnoobjects.eq(i);
					if(i==empnoobjects.length-1){
						empnos += empnoobject.val();
					}else {
						empnos += empnoobject.val()+",";
					}
				}
				//删除可以删除多条
				window.location.href="emp?methodflag=dodelete&empno="+empnos;*/
				
				$.post("${proname}/ftl/emp/dodelete.action?lvflag=ajax",$("#dataform").serialize(),function(data){
					//ajax提交，未登录
					//先判断data.loginValidateFlag是否存在，存在说明未登录，过滤器过滤
					if(data.loginValidateFlag){
						alert("用户未登录，请登录!");
						window.parent.location.href="${proname}/tologin.action";
					}
					
					if(data.succ){
						alert(data.msg);
						window.location.href="${proname}/ftl/emp/queryto.action";
					}else{
						$("#msg").html(data.msg);
					}
				},"json");
			}
		}
		
		function checkall(){
			$("input[name=empnos]").prop("checked",$("#checkall").prop("checked"));
		}
		
		
		//ajax查询
		function ajaxquery(pagenum){
			$("#msg").html("");
			$("#pagenum").val(pagenum);
			$.post("${proname}/ftl/emp/query.action?lvflag=ajax",$("#queryform").serialize(),function(data){
				//ajax提交，未登录
				//先判断data.loginValidateFlag是否存在，存在说明未登录，过滤器过滤
				if(data.loginValidateFlag){
					alert("用户未登录，请登录!");
					window.parent.location.href="${proname}/login.do?methodflag=tologin";
				}
				
				//jsr303验证显示错误信息
				if(data.errorlist){
					var errorlist = data.errorlist;
					var errormsg = "";
					for(var i=0;i<errorlist.length;i++){
						errormsg += errorlist[i].errormsg+"<br/>";
					}
					$("#msg").html(errormsg);
					//return;
				}
					
				//清空table中的class=trclass行对象
				$(".trclass").remove();
				//取得emplist数据，重新设置表格数据
				var emplist = data.emplist;
				if(emplist != null && emplist.length>0){
					for(var i=0;i<emplist.length;i++){
						var emp = emplist[i];
						var mgrname="";
						var hiredate="";
						var sal="";
						var comm="";
						var dname="";
						var loginname="";
						var loginpwd="";
						var sex="";
						var enjoy="";
						//判断该emp对象中是否存在mgrname属性，存在结果为true false：该属性不存在
						if(emp.mgrinfo && emp.mgrinfo.ename){
							mgrname = emp.mgrinfo.ename;
						}
						if(emp.hiredate){
							var date = new Date(emp.hiredate);
							hiredate = getHiredate(date);
						}
						if(emp.sal){
							sal = emp.sal;
						}
						if(emp.comm){
							comm = emp.comm;
						}
						if(emp.deptinfo && emp.deptinfo.dname){
							dname = emp.deptinfo.dname;
						}
						if(emp.loginname){
							loginname = emp.loginname;
						}
						if(emp.loginpwd){
							loginpwd = emp.loginpwd;
						}
						if(emp.sex){
							sex = emp.sex;
						}
						if(emp.enjoy){
							enjoy = emp.enjoy;
						}
						var trobject = "<tr class='trclass'>"+
      		  						   "<td><input type='checkbox' name='empnos' value='"+emp.empno+"'/></td>"+
						      		   "<td>"+(i+1)+"</td>"+
						   			   "<td>"+emp.empno+"</td>"+
						   			   "<td>"+emp.ename+"</td>"+
						   			   "<td>"+emp.job+"</td>"+
						   			   "<td>"+mgrname+"</td>"+
						   			   "<td>"+hiredate+"</td>"+
						   			   "<td>"+sal+"</td>"+
						   			   "<td>"+comm+"</td>"+
						   			   "<td>"+dname+"</td>"+
						   			   "<td>"+loginname+"</td>"+
						   			   "<td>"+loginpwd+"</td>"+
						   			   "<td>"+sex+"</td>"+
						   			   "<td>"+enjoy+"</td>"+
						   			   "</tr>";
						 //将行对象添加table中
						 $("#datatable").append(trobject);
					}
				}
				//取得分页数据，重写设置
				var pageinfo = data.pageinfo;
				//设置总记录数
				//设置当前页数
				//设置总页数
				$("#sdatacount").html(pageinfo.dataCount);
				$("#spagenum").html(pageinfo.pageNum);
				$("#spagecount").html(pageinfo.pageCount);
				$("#pyimgagediv").empty();
				var pageObject="";
				//设置首页，上一页，下一页，尾页
				if(pageinfo.pageNum == 1){
					pageObject+="<img src='${proname}/images/maind_54.gif'/>&nbsp;<img src='${proname}/images/maind_56.gif'/>&nbsp;";
				}else {
					pageObject+="<a href='javascript:void(0)' onclick='ajaxquery(1)'><img src='${proname}/images/main_54.gif'/></a>&nbsp;"+
 							 	"<a href='javascript:void(0)' onclick='ajaxquery("+(pageinfo.pageNum-1)+")'><img src='${proname}/images/main_56.gif'/></a>&nbsp;";
				}
				if(pageinfo.pageNum == pageinfo.pageCount){
					pageObject+="<img src='${proname}/images/maind_58.gif'/>&nbsp;<img src='${proname}/images/maind_60.gif'/>&nbsp;";
				}else {
					pageObject+="<a href='javascript:void(0)' onclick='ajaxquery("+(pageinfo.pageNum+1)+")'><img src='${proname}/images/main_58.gif'/></a>&nbsp;"+
 							 	"<a href='javascript:void(0)' onclick='ajaxquery("+pageinfo.pageCount+")'><img src='${proname}/images/main_60.gif'/></a>&nbsp;";
					
				}
				$("#pyimgagediv").html(pageObject);
				
			},"json");
		}
		
		
		function getHiredate(date){
			return date.getFullYear()+"/"+buzero((date.getMonth()+1)+"")+"/"+buzero(date.getDate()+"");
		}
		
		function buzero(str){
			if(str.length==1){
				return "0"+str;
			}
			return str;
		}
	</script>
  </head>
  
  <body>
    <h1>员工查询一览</h1>
    <input type="button" value="新增" onclick="add()"/>
    <input type="button" value="修改" onclick="edit()"/>
    <input type="button" value="删除" onclick="del()"/>
    <form style='margin:0px' id="queryform">
      <input type="hidden" name="pagenum" id="pagenum" />
      <table id="querytable">
    	<tr>
    	  <td>
    		 姓名：<input type='text' name='ename' id='ename' value="${selemp.ename}"/>
    	  </td>
    	  <td>
    		入职时间：
    		<input type='text' name='startlike' id='startlike' onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" value="<fmt:formatDate value="${selemp.startlike}" pattern="yyyy/MM/dd"/>"/>
    		-
    	    <input type='text' name='endlike' id='endlike' onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" value="<fmt:formatDate value="${selemp.endlike}" pattern="yyyy/MM/dd"/>"/>
    	  </td>
    	  <td>
    		部门：
    		<select id="deptno" name="deptno">
    			<option value="">全部</option>
    			<c:if test="${not empty deptlist}">
    				<c:forEach items="${deptlist}" var="dept">
    					<option value="${dept.deptno}">${dept.dname}</option>
    				</c:forEach>
    			</c:if>
    		</select>
    	  </td>
    	  <td>
    		 <input type='button' value='查询' onclick="ajaxquery(1)"/>
    	  </td>
        </tr>
      </table>
    </form>
    <form style='margin:0px' id="dataform">
    <table id="datatable">
 	  <tr>
 	  	<td><input type="checkbox" title="全选/全不选" id="checkall" onclick="checkall()"/></td>
 	  	<td>序号</td>
 		<td>员工编号</td>
 		<td>姓名</td>
 		<td>工种</td>
 		<td>上司</td>
 		<td>入职时间</td>
 		<td>工资</td>
 		<td>奖金</td>
 		<td>部门</td>
 		<td>登录名</td>
 		<td>登录密码</td>
 		<td>性别</td>
 		<td>兴趣</td>
      </tr>
 	</table>
 	</form>
 	<div id="pydiv">
 		共有<span id="sdatacount"></span>条记录,当前第<span id="spagenum"></span>页,共<span id="spagecount"></span>页
 		<div id="pyimgagediv">
 		</div>
 	</div>
 	<div id="msg" style="color:red">
 		${msg}
 	</div>
  </body>
</html>
