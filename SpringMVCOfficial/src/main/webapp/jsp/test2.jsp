<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String basepath=request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.css
" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js
"></script>
<title>Insert title here</title>
</head>
<body>
    <form id="form" method="post">  
    <label for="id">id:</label>  
    <input type="text" id="id" name="id" value="${id}"/><br/>  
  
    <label for="name">name:</label>  
    <input type="text" id="name" name="id" value="${name}"/><br/>  
  
    <input id="submit-btn" type="submit" value="submit"/>  
  
</form>  
  
<script type="text/javascript">  
    $("#submit-btn").click(function() {  
        $(this).closest("form").attr("action", "/submit");  
        $("#id").val("123");  
        $("#name").val("zhangsan");  
        return false;  
    });  
</script>  
</body>
</html>