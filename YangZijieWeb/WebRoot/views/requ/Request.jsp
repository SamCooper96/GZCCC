<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();//站点的根
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String title = application.getServletContextName();//工程别名，对应于web.xml中的display-name。application上下文
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">  
    <title>${_TITLE}[内置对象request]</title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/style.css">
  </head>
  
  <body>
  <h2>
  站点根（request.getContextPath()）：<%=request.getContextPath()%><br />
  端口号（request.getLocalPort()）：<%=request.getLocalPort()%><br />
  请求的URI（request.getRequestURI()）：<%=request.getRequestURI()%><br />
  远程主机（request.getRemoteHost()）：<%=request.getRemoteHost()%><br />
  </h2>
  </body>
</html>
<%
System.out.println(request.getRemoteHost());
%>
