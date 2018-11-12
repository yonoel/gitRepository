<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%
    String basepath = request.getContextPath();
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.css
"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
<script
	src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js
"></script>
<title>Insert title here</title>
</head>
<body>
	<%
	    List<String> list = new ArrayList<String>();
	    list.add("zs");
	    list.add("ls");
	    list.add("ww");
	    list.add("xx"); 
	    list.add("qw");
	    
	    List<String> list2 = new ArrayList<String>();
        list.add("zs2");
        list.add("ls2");
        list.add("ww2");
        list.add("xx2"); 
        list.add("qw2");
	    
	    List<List<String>> list3 = new ArrayList<List<String>>();
	    
	    list3.add(list);
	    list3.add(list2);
	    for (int i = 0; i < list3.size(); i++) {
	           
            for (int j = 0; j < list3.get(i).size(); j++) {
                out.print(list3.get(i).get(j)+"<br>");
            }
        }
	    request.setAttribute("list3", list3);
	%>
	<hr>
		  <c:forEach items="${list3}" var ="arr">
	
		      <c:forEach items="${arr }" var ="num">
		          ${num }<br>
		      </c:forEach>
		   </c:forEach> 
	<hr>
	
</body>
</html>