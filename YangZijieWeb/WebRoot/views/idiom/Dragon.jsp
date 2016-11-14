<%@ page language="java" pageEncoding="UTF-8"%>
<!-- 头文件 -->
<%@ include file="Head.jsp"%>
<!-- 页面主体 -->
<body>
	<!-- 菜单导航条 -->
	<%@ include file="Menu.jsp"%>
	<h2>当前用户：${_USER.userName}</h2>

	<!-- 多条件复合查询 -->
	<form name="theform" action="${_PATH}/Dragon.idiom" method="post">
		请输入成语的第一个字：<input type="text" name="name" value="${name}" size="12"
			maxlength="14" /> <input type="button" name="ok" value="查询"
			onclick="this.form.submit()" />
	</form>
	<br /> 共找到${count}条成语：
	<table width="1000px" align="center" border="1px">
		<tr style="line-height=120%">
			<td width="30px">序号</td>
			<td width="60px">名称</td>
			<td>拼音</td>
			<td>释义</td>
			<td>出处</td>
		</tr>
		<c:forEach items="${list}" var="item" varStatus="vs">
			<tr>
				<td>${vs.count}</td>
				<td>${item.name}</td>
				<td>${item.pinyin}</td>
				<td>${item.paraphrase}</td>
				<td>${item.provenance}</td>
			</tr>
		</c:forEach>
	</table>
</body>

<!-- 脚文件 -->
<%@ include file="Foot.jsp"%>
