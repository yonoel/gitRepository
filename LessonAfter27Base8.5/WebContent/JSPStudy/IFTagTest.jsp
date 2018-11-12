<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/TagLib" prefix="tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Iftags</title>
</head>
<body>
    <tags:IFTag flag="true">
        这个flag为true，会显示
    </tags:IFTag>
    不会显示
    <tags:IFTag flag="false">
         这个flag为false，不会显示
    </tags:IFTag>
</body>
</html>