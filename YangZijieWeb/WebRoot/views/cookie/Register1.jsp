<%@ page language="java" pageEncoding="UTF-8"%>
<!-- 头文件 -->
<%@ include file="Head.jsp"%>
<!-- 嵌入相关java代码 -->
<%
	String userType = null;
	String userName = null;
	String doneType = null;
	String openBank = null;
	// 从客户端的Cookie数据中读取有关信息，如果能读出，则填入对应的文本框中（回读信息）。
	Cookie[] cookies = request.getCookies();// 获取客户端的Cookie数据。
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			String key = cookie.getName();
			String value = cookie.getValue();
			// 注意这里会出现乱码问题，要解决乱码。
			value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
			if (key.equals("userType")) {
				userType = value;
			} else if (key.equals("userName")) {
				userName = value;
			} else if (key.equals("doneType")) {
				doneType = value;
			} else if (key.equals("openBank")) {
				openBank = value;
			}
		}
	}
%>
<body>
	<h1>用户注册第一步</h1>
	<br />
	<h3>
		<form name="theform" action="<%=path%>/views/cookie/Register2.jsp"
			method="post">
			用户类别：<input type="radio" name="userType" value="0" checked />个人账号
			&nbsp;&nbsp;<input type="radio" name="userType" value="0"
				<%=("0".equals(userType)) ? "checked" : ""%> />单位账号<br /> 用户名称：<input
				type="text" name="userName"
				value="<%=(userName != null) ? userName : ""%>" size="20" maxlength="25" /><br />
			结算方式：<input type="radio" name="doneType" value="0"
				<%=("0".equals(doneType)) ? "checked" : ""%> />现金 &nbsp;&nbsp;<input
				type="radio" name="doneType" value="1"
				<%=("1".equals(doneType)) ? "checked" : ""%> />微信支付 &nbsp;&nbsp;<input
				type="radio" name="doneType" value="2"
				<%=("2".equals(doneType)) ? "checked" : ""%> />支付宝<br /> 开户行：<input
				type="text" name="openBank"
				value="<%=(openBank != null) ? openBank : ""%>" size="20" maxlength="25" /><br />
			<br /> <input type="button" name="nextBt" value="下一步"
				onclick="this.form.submit()" />
		</form>
	</h3>
</body>
<!-- 脚文件 -->
<%@ include file="Foot.jsp"%>
