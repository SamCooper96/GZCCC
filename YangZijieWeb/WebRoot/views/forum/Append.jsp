<%@ page language="java" pageEncoding="UTF-8"%>
<!-- 头文件 -->
<%@ include file="Head.jsp"%>
<!-- 页面主体 -->
<body>
	<!-- 菜单导航条 -->
	<%@ include file="Menu.jsp"%>
	<h2>[发帖]当前用户：${_USER.userName}</h2>
	<form name="theform" action="${_PATH}/Append.bbs" method="post">
		标题：<input type="text" class="text0" name="title" value="title" maxlength="32"/>
		<br /><br />
		<input type="button" value="发帖" onclick="this.form.submit()" />
	</form>
	${title}
</body>
<!-- 脚文件 -->
<%@ include file="Foot.jsp"%>