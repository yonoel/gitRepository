<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在JavaBean中存放数据</title>
<jsp:useBean id="Bean" class="jsplesson.beans.SampleBean2" />
</head>
<body>
	
	<%--方法一
   <jsp:setProperty name="Bean" property="*" /> 自动 装填，表单的name = Bean的property，清一色的String类
  --%>
  <%-- 方法二 
  
  <jsp:setProperty name = "sampleBean2" property = "id"/>

  <jsp:setProperty name = "sampleBean2" property = "name"/>
  --%>

   <%--方法三 
      <jsp:setProperty name = "sampleBean2" property = "addr" value = "洛阳师范学院"/>
   --%>


  <%-- 方法四 bean属性的名字可以与request参数不同--%>

  <jsp:setProperty name = "Bean" property = "sex" param = "theSex"/>

  <jsp:setProperty name = "Bean" property = "age" param = "theAge"/>
	<center>

		编号:<jsp:getProperty name="Bean" property="id" /><br> 
		姓名:<jsp:getProperty
			name="Bean" property="name" /><br> 
			性别:<jsp:getProperty
			name="Bean" property="sex" /><br> 
			年龄:<jsp:getProperty
			name="Bean" property="age" /><br> 
			住址:<jsp:getProperty
			name="Bean" property="addr" /><br>

	</center>
</body>
</html>