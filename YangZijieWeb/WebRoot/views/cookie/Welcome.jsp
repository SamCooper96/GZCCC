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
	<div id="wrap">
		<table width="500px" align="center" border="1px">
			<tr>
				<td>1</td>
				<td><a href="<%=path%>/views/cookie/WriteCookie.jsp"> →
						写Cookie</a></td>
				<td>向客户端本地写入Cooike文件。</td>
			</tr>
			<tr>
				<td>2</td>
				<td><a href="<%=path%>/views/cookie/ReadCookie.jsp"> →
						读Cookie</a></td>
				<td>读取客户端本地的Cooike信息。</td>
			</tr>
			<tr>
				<td>3</td>
				<td><a href="<%=path%>/views/cookie/Register1.jsp">
				用户注册</a></td>
				<td>分页面注册</td>
			</tr>
		</table>
	</div>
</body>
</html>
