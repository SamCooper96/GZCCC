<%@ page language="java" pageEncoding="UTF-8"%>
<!-- 头文件 -->
<%@ include file="Head.jsp"%>
<!-- 页面主体 -->
<body>
	<!-- 菜单导航条 -->
	<%@ include file="Menu.jsp"%>
	<h2>当前用户：${_USER.userName}</h2>

	<!-- 多条件复合查询 -->
	<form name="theform" action="${_PATH}/Remove.idiom" method="post">
		名称：<input type="text" name="name" value="${name}" size="12" maxlength="14" />
		<input type="button" name="ok" value="删除成语" onclick="this.form.submit()" />
	</form>
	${message}
</body>

<!-- 脚文件 -->
<%@ include file="Foot.jsp"%>
