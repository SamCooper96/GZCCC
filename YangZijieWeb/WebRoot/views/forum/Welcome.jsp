<%@ page language="java" pageEncoding="UTF-8"%>
<!-- 头文件 -->
<%@ include file="Head.jsp"%>
<!-- 页面主体 -->
<body>
	<p align="center">版本号：${_VERSION}，登录时间：${loginTime}</p>
	<!-- 菜单导航条 -->
	<%@ include file="Menu.jsp"%>
	<h2>当前用户：${_USER.userName}</h2>
</body>
<!-- 脚文件 -->
<%@ include file="Foot.jsp"%>