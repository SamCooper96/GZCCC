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
<!-- 嵌入相关java代码 -->
<%
String name = request.getParameter("name");
if(name!=null && name.trim().length()>0){
	// 写Cookie
	Cookie ck = new Cookie("myCookie", name);// 以“键-值”对的形式实例化一个Cookie。
	ck.setMaxAge(10*60);// 设置有效期（若不设置则无生存期；若为0则表示要删除某个Cooike）。
	response.addCookie(ck);// 将这个Cookie发送给客户端
}
// 从客户端的Cookie数据中读取有关信息，如果能读出，则填入对应的文本框中（回读信息）。
Cookie[] cookies = request.getCookies();// 获取客户端的Cookie数据。
if(cookies != null){
	for(Cookie cookie:cookies){
		if(cookie.getName().equals("myCookie")){
			name = cookie.getValue();
			break;
		}
	}
}
%>
<body>
	<h1>写入Cookie</h1>
	<br />
	<form name="theform" action="<%=path%>/views/cookie/WriteCookie.jsp" method="post">
		请输入要写入Cooike的内容：<input type="text" name="name" value="<%=(name!=null)?name:""%>" size="20"
			maxlength="25" /> <input type="button" name="ok" value="写Cooike"
			onclick="this.form.submit()" />
	</form>
</body>
</html>
