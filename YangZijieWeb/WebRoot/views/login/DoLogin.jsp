<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();//站点的根
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String userId = request.getParameter("userId");//通过请求对象request获取页面传入的参数。
String userPd = request.getParameter("userPd");//页面传入的参数，全为字符串类型。
if(userId!=null && userPd!=null && userPd.equals("8888")){
	cn.gzccc.user.User user = new cn.gzccc.user.User(userId, userPd);
	session.setAttribute("_USER", user);//将用户实例设置到回话对象中的属性
	//当登录成功时，则重定向到“欢迎”页面。
	response.sendRedirect("Welcome.jsp");//用响应对象response进行页面重定向。
}else{
	//当登录失败时，则重定向到“出错”页面。
	session.setAttribute("_ERROR", "密码错误");
	response.sendRedirect("Error.jsp");//用响应对象response进行页面重定向。
}
%>

