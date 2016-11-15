<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();//站点的根
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
	<h1>读取Cookie</h1>
	<br />
<%
Cookie[] cookies = request.getCookies();// 获取客户端的Cookie数据。
if(cookies != null){
	for(Cookie cookie:cookies){
		String name = cookie.getName();
		String value = cookie.getValue();
		int maxAge = cookie.getMaxAge();// 注意单位是秒。
		out.println("名字："+name+"；内容："+value+"；生存期（秒）："+maxAge+"。<br />");
	}
}

%>
</body>
</html>
