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
    <title>${_TITLE}</title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/style.css">
  </head>
  
  <body>
  <%
  cn.gzccc.user.User user = (cn.gzccc.user.User)session.getAttribute("_USER");//从会话当中去某个值出来
  if(user == null){
  	out.println("用户未登录...");
  }else{
  	out.println("当前用户：" + user.getUserId());
  }
  %>
  </body>
</html>
