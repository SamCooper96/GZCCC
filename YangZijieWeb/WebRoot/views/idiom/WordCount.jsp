<%@ page language="java" pageEncoding="UTF-8"%>
<!-- 头文件 -->
<%@ include file="Head.jsp"%>
<!-- 页面主体 -->
<body>
	<!-- 菜单导航条 -->
	<%@ include file="Menu.jsp"%>
	<h2>当前用户：${_USER.userName}</h2>

	<div align="center">
	<form name="theform" action="${_PATH}/WordCount.idiom" method="post">
		<h3>请输入文本内容：</h3>
		<textarea name="words" rows="20" cols="80">[文本内容]</textarea>
		<br /> <br />
		<input type="button" name="ok" value="统计字数" onclick="this.form.submit()" />
		<h3>字数统计：${words}</h3>
	</form>
	</div>
</body>

<!-- 脚文件 -->
<%@ include file="Foot.jsp"%>
