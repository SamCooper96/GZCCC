<%@ page language="java" pageEncoding="UTF-8"%>
<!-- 头文件 -->
<%@ include file="Head.jsp"%>
<!-- 根据用户在Register2.jsp设置所喜欢的颜色来改变页面背景颜色。 -->
<body style="background-color:${favoriteColor}">
	<h1>用户注册第一步</h1>
	<br />
	<h3>
		<form name="theform" action="${_PATH}/views/cookie/Register2.jsp" method="post">
			用户类别：
			<input type="radio" name="userType" value="0" ${userType=='0'?'checked':''} /> 个人账号&nbsp;&nbsp; 
			<input type="radio" name="userType" value="1" ${userType=='1'?'checked':''} /> 单位账号<br /> <br /> 
			用户名称：<input type="text" name="userName" value="${userName}" size="20" maxlength="25" /><br /> <br />
			结算方式：
			<c:forTokens items="现金,支票,信用卡,微信,支付宝" delims="," var="item"
				varStatus="vs">
				<input type="radio" name="doneType" value="${vs.index}"
					${doneType==vs.index?'checked':''} />
					${item}&nbsp;&nbsp;
			</c:forTokens>
			<br /> <br /> 
			开户行：<input type="text" name="openBank" value="${openBank}" size="20" maxlength="25" /><br /> <br />
			开户日期：
			<input type="date" name="openDate" value="${_DATE}" /> <br /> <br /> 
			<input type="button" name="nextBt" value="下一步" onclick="this.form.submit()" />
		</form>
	</h3>
</body>
<!-- 脚文件 -->
<%@ include file="Foot.jsp"%>
