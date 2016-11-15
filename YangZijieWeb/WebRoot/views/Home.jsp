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
				<td width="40px">序号</td>
				<td>项目</td>
				<td>描述</td>
			</tr>
			<tr>
				<td>1</td>
				<td><a href="<%=path%>/views/rect/Rectangle.jsp">计算矩形面积</a></td>
				<td>JSP标签语法、JavaBean</td>
			</tr>
			<tr>
				<td>2</td>
				<td><a href="<%=path%>/views/requ/Request.jsp">请求对象（request）</a></td>
				<td>JSP内置对象，request（浏览器向服务器发出的请求）</td>
			</tr>
			<tr>
				<td>3</td>
				<td><a href="<%=path%>/views/login/Login.jsp">用户登录（session）</a></td>
				<td>用户登录，session（在一个浏览器窗口中持续对一个站点访问）</td>
			</tr>
			<tr>
				<td>4</td>
				<td><a href="<%=path%>/views/idiom/Login.jsp">中国成语词典</a></td>
				<td>成语查询，数据库操作、JSTL</td>
			</tr>
			<tr>
				<td>5</td>
				<td><a href="<%=path%>/views/cookie/Welcome.jsp">读写Cooike</a></td>
				<td>读取、写入浏览器（客户端）本地硬盘上的Cookie</td>
			</tr>
			<tr>
				<td>6</td>
				<td><a href="#">xxx</a></td>
				<td></td>
			</tr>
			<tr>
				<td>7</td>
				<td><a href="#">xxx</a></td>
				<td></td>
			</tr>
		</table>
		<!-- 以下为测试代码传送门 -->
		<a href="<%=path%>/views/test/Hello.jsp">测试</a>
	</div>
</body>
</html>
