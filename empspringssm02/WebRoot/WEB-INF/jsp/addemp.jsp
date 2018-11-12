<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- 导入spring框架中提供的 根据服务器返回给前端的模型数据对象自动填充表单 -->
<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%--取得是当前发布的项目名称 --%>
<c:set var="proname" value="${pageContext.request.contextPath}"></c:set>
<%-- <c:set var="proname" value="<%=path %>"></c:set> --%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'addemp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		.editstyle{
			background-color:#EBEBE4;
			border:1px solid #A9A9A9;
			color:#545454;
		}
	</style>
  	<script type="text/javascript" src="${proname}/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${proname}/js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		function checkform(){
			var empno = $("#empno").val();
			var ename = $("#ename").val();
			var loginname = $("#loginname").val();
			var loginpwd = $("#loginpwd").val();
			$("#msg").html("");
			if(empno.length == 0){
				$("#msg").html("员工编号不能为空");
				return false;
			}
			if(ename.length == 0){
				$("#msg").html("员工姓名不能为空");
				return false;
			}
			if(loginname.length == 0){
				$("#msg").html("登录名称不能为空");
				return false;
			}
			if(loginpwd.length == 0){
				$("#msg").html("登录密码不能为空");
				return false;
			}
			return true;
		}
		
		$(function(){
			var methodflag = "${methodflag}";
			//新增操作
			if(methodflag == "doadd"){
				$("#h1").html("新增员工信息");
			//修改操作
			}else if(methodflag == "doupdate"){
				$("#h1").html("修改员工信息");
				$("#empno").addClass("editstyle");
				$("#empno").prop("readonly",true);
			}
			
			//赋初始化值
			//$("#empno").val("${empinfo.empno}");
			//设置选中下拉框的值
			/* $("#mgr").val("${empinfo.mgr}"); */
			
			//设置性别
			/* var sex = "${empinfo.sex}";
			if(sex.length>0){
				//取得name=sex的jquery对象
				var sexobjects = $("input[name=sex]");
				sexobjects.prop("checked",false);
				for(var i=0;i<sexobjects.length;i++){
					var sexobject = sexobjects.eq(i);
					if(sexobject.val() == sex){
						sexobject.prop("checked",true);
					}
				}
			} */
			//设置兴趣
			/* var enjoy = "${empinfo.enjoy}";
			if(enjoy.length>0){
				//将字符串转换成数组
				var enjoys = enjoy.split(",");
				var enjoyobjects = $("input[name=enjoy]");
				for(var i=0;i<enjoys.length;i++){
					for(var j=0;j<enjoyobjects.length;j++){
						var enjoyobject = enjoyobjects.eq(j);
						if(enjoys[i] == enjoyobject.val()){
							enjoyobject.prop("checked",true);
							break;
						}
					}
				}
			} */
		});
		
		
		function submitform(){
			//if(checkform()){
				var url="";
				var methodflag = $("#methodflag").val();
				//新增保存操作
				if(methodflag == "doadd"){
					url="${proname}/ftl/emp/doadd.action";
				//修改保存操作
				}else if(methodflag == "doupdate"){
					url="${proname}/ftl/emp/doupdate.action";
				}
				$.post(url+"?lvflag=ajax",$("#form1").serialize(),function(data){
					//ajax提交，未登录
					//先判断data.loginValidateFlag是否存在，存在说明未登录，过滤器过滤
					if(data.loginValidateFlag){
						alert("用户未登录，请登录!");
						window.parent.location.href="${proname}/tologin.action";
					}
					
					//jsr303验证显示错误信息
					if(data.errorlist){
						var errorlist = data.errorlist;
						var errormsg = "";
						for(var i=0;i<errorlist.length;i++){
							errormsg += errorlist[i].errormsg+"<br/>";
						}
						$("#msg").html(errormsg);
						return;
					}
					
					if(data.succ){
						alert(data.msg);
						window.location.href="${proname}/ftl/emp/queryto.action";
					}else{
						$("#msg").html(data.msg);
					}
				},"json");
			//}
		}
	</script>
  </head>
  
  <body>
    <div>
      <h1 id="h1">新增员工信息</h1>
      <a href="${proname}/ftl/emp.do?methodflag=queryto">查询员工数据</a>
      						<!-- 
      							commandName的值为model.addAttribute("empinfo", resultMap.get("empinfo"));的属性值，
      							将后台设置的emp对象自动绑定到该form标签中 -->
      <sform:form id="form1" commandName="empinfo">
      <input type="hidden" name="methodflag" id="methodflag" value="${methodflag}"/>
      <table width="500" border="1" style="border-collapse: collapse;">
      	<tr>
      	  <td>员工编号</td>
      	  <td>
      	    <%-- <input type="text" name="empno" id="empno" value="${empinfo.empno}" /><span style="color:red">*</span> --%>
      	    <!--  <input type="text" name="empno" id="empno" value="${empinfo.empno}"/><span style="color:red">*</span>-->
      	    <!--
      	    	sform:input 页面最终渲染的input type=“input”
      	    	path属性为emp对象中的属性名称
      	    	path的值为渲染成标签中name属性对应的值
      	    -->
      	    <sform:input path="empno" id="empno"/><span style="color:red">*</span>
      	  </td>
      	</tr>
      	<tr>
      	  <td>员工姓名：</td>
      	  <td>
      	    <%-- <input type="text" name="ename" id="ename" value="${empinfo.ename}"/><span style="color:red">*</span> --%>
      	    <sform:input path="ename" id="ename" /><span style="color:red">*</span>
      	  </td>
      	</tr>
      	<tr>
      	  <td>工种：</td>
      	  <td>
      	    <%-- <input type="text" name="job" id="job" value="${empinfo.job}"/> --%>
      	    <sform:input path="job" id="job" />
      	  </td>
      	</tr>
      	<tr>
      	  <td>上司：</td>
      	  <td>
      	    <%-- <select id="mgr" name="mgr" style="width:173px;">
      	    	<option value="">请选择</option>
      	    	 <c:if test="${not empty mgrlist}">
      	    	 	<c:forEach items="${mgrlist}" var="mgr">
      	    	 		<option value="${mgr.empno}" <c:if test="${mgr.empno == empinfo.mgr}">selected="selected"</c:if> >${mgr.ename}</option>
      	    	 		<option value="${mgr.empno}">${mgr.ename}</option>
      	    	 	</c:forEach>
      	    	 </c:if>
      	    </select> --%>
      	    <sform:select path="mgr" id="mgr" cssStyle="width:173px;">
      	    	<sform:option value="">请选择</sform:option>
      	    	<!-- 动态下拉框 用 sform:options绑定  items表示你要绑定的后台传过来的集合  
      	    		itemValue相当于value属性 值为集合中的对象中的属性名称
      	    		itemLabel 下拉框option显示的内容  值为集合中的对象中的属性名称-->
      	    	<sform:options items="${mgrlist}" itemValue="empno" itemLabel="ename"/>
      	    </sform:select>
      	  </td>
      	</tr>
      	<tr>
      	  <td>入职时间：</td>
      	  <td>
      	    <%-- <input type="text" name="hiredate" id="hiredate" 
      	    	onclick="WdatePicker({dateFmt:'yyyy/MM/dd',readOnly:true})"  
      	    	value='<fmt:formatDate value="${empinfo.hiredate}" pattern="yyyy/MM/dd"/>'/> --%>
      	    <sform:input path="hiredate" id="hiredate" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" readonly="true"/>
      	  </td>
      	</tr>
      	<tr>
      	  <td>工资：</td>
      	  <td>
      	    <%-- <input type="text" name="sal" id="sal" value="${empinfo.sal}"/> --%>
      	    <sform:input path="sal" id="sal" />
      	  </td>
      	</tr>
      	<tr>
      	  <td>奖金：</td>
      	  <td>
      	    <%-- <input type="text" name="comm" id="comm" value="${empinfo.comm}"/> --%>
      	    <sform:input path="comm" id="comm" />
      	  </td>
      	</tr>
      	<tr>
      	  <td>部门：</td>
      	  <td>
      	     <%-- <select id="deptno" name="deptno" style="width:173px;">
      	    	<option value="">请选择</option>
      	    	 <c:if test="${not empty deptlist}">
      	    	 	<c:forEach items="${deptlist}" var="dept">
      	    	 		<option value="${dept.deptno}" <c:if test="${dept.deptno==empinfo.deptno}">selected="selected"</c:if> >${dept.dname}</option>
      	    	 	</c:forEach>
      	    	 </c:if>
      	    </select> --%>
      	    <sform:select path="deptno" id="deptno" cssStyle="width:173px;">
      	    	<sform:option value="">请选择</sform:option>
      	    	<sform:options items="${deptlist}" itemValue="deptno" itemLabel="dname"/>
      	    </sform:select>
      	  </td>
      	</tr>
      	<tr>
      	  <td>登录名称：</td>
      	  <td>
      	    <%-- <input type="text" name="loginname" id="loginname" value="${empinfo.loginname}"/><span style="color:red">*</span> --%>
      	  	<sform:input path="loginname" id="loginname" /><span style="color:red">*</span>
      	  </td>
      	</tr>
      	<tr>
      	  <td>登录密码：</td>
      	  <td>
      	    <%-- <input type="text" name="loginpwd" id="loginpwd" value="${empinfo.loginpwd}"/><span style="color:red">*</span> --%>
      	    <sform:input path="loginpwd" id="loginpwd" /><span style="color:red">*</span>
      	  </td>
      	</tr>
      	<tr>
      	  <td>性别：</td>
      	  <td>
      	    <%-- <input type="radio" name="sex" value="男" <c:if test="${empty empinfo || empinfo.sex=='男' }">checked="checked"</c:if>/>男
      	    <input type="radio" name="sex" value="女" <c:if test="${empinfo.sex=='女' }">checked="checked"</c:if>/>女 --%>
      	    <!-- <input type="radio" name="sex" value="男" checked="checked"/>男
      	    <input type="radio" name="sex" value="女" />女 -->
      	    <sform:radiobutton path="sex" value="男" checked="true"/>男
      	    <sform:radiobutton path="sex" value="女"/>女
      	    
      	  </td>
      	</tr>
      	<tr>
      	  <td>兴趣：</td>
      	  <td>
      	    <!-- <input type="checkbox" name="enjoy" value="打球"/>打球
      	    <input type="checkbox" name="enjoy" value="学习"/>学习
      	    <input type="checkbox" name="enjoy" value="睡觉"/>睡觉 -->
      	    <sform:checkbox path="enjoys" value="打球"/>打球
      	    <sform:checkbox path="enjoys" value="学习"/>学习
      	    <sform:checkbox path="enjoys" value="睡觉"/>睡觉 
      	    <%-- <sform:checkboxes items="${arr}" path="enjoys"/> --%>
      	    <%-- <sform:checkboxes items="${deptlist}" path="enjoys" itemValue="deptno" itemLabel="dname"/> --%>
      	  </td>
      	</tr>
      	<tr>
      	  <td colspan="2" align="center">
      	    <input type="button" value="保存" onclick="submitform()"/>
      	    <input type="reset" value="重置"/>
      	  </td>
      	</tr>
      </table>
      </sform:form>
      <div id="msg" style="color: red">
      </div>
    </div>
  </body>
</html>
