<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();//站点的根
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">  
    <title>${_TITLE}[错误提示]</title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/style.css">
  </head>
  
  <body>
  <h1>出错(${_ERROR })...</h1>
  </body>
</html>
