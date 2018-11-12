<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*"%>
    <jsp:useBean id="person" class="jsplesson.beans.Person" scope="page"></jsp:useBean>
    <%--
使用jsp:setProperty标签设置person对象的属性值
jsp:setProperty在设置对象的属性值时会自动把字符串转换成8种基本数据类型
但是jsp:setProperty对于复合数据类型无法自动转换
--%>
<!-- name对应的时bean的id  -->
<jsp:setProperty property="name" name="person" value="白虎神皇"/>
<jsp:setProperty property="sex" name="person" value="男"/>
<jsp:setProperty property="age" name="person" value="24"/>
<jsp:setProperty property="married" name="person" value="false"/>
<%--
birthday属性是一个Date类型，这个属于复合数据类型，因此无法将字符串自动转换成Date ，用下面这种写法是会报错的
<jsp:setProperty property="birthday" name="person" value="1988-05-07"/>
--%>
<jsp:setProperty property="birthday" name="person" value="<%=new Date()%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>使用jsp:setProperty标签</title>
</head>
<body>
     <%--使用getXxx()方法获取对象的属性值 --%>
    <h2>姓名：<%=person.getName()%></h2>
    <h2>性别：<%=person.getSex()%></h2>
    <h2>年龄：<%=person.getAge()%></h2>
    <h2>已婚：<%=person.isMarried()%></h2>
     <h2>出生日期：<%=person.getBirthday()%></h2>
</body>
</html>