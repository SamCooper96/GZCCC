<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();//站点的根
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
pageContext.setAttribute("_PATH", path);//当前页面对象。
//判断用户是否已经登录（挡板）
cn.gzccc.user.User user = (cn.gzccc.user.User)session.getAttribute("_USER");//取出来的与左边类型不对，使用强制转换
  if(user == null){
  	session.setAttribute("_ERROR", "用户未登录");
	response.sendRedirect("Error.jsp");
  }
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">  
    <title>${_TITLE}</title>
    <link rel="stylesheet" type="text/css" href="${_PATH}/css/style.css">
  </head>
