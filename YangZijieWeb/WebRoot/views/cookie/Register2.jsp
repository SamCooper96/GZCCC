<%@ page language="java" pageEncoding="UTF-8"%>
<!-- 头文件 -->
<%@ include file="Head.jsp"%>
<!-- 根据用户在Register2.jsp设置所喜欢的颜色来改变页面背景颜色。 -->
<!-- <body style="background-color:${favoriteColor}"> -->
<body>
	<h1>用户注册第二步</h1>
	<br />
	<h3>
		<form name="theform" action="${_PATH}/views/cookie/Register1.jsp"
			method="post">
			<!-- 读取cookie第一种方法（不使用java代码，区别于Register1.jsp） -->
			性别： <input type="radio" name="gender" value="0"
				${gender=='0'?'checked':''} />男 &nbsp;&nbsp;<input type="radio"
				name="gender" value="1" ${gender=='1'?'checked':''} />女<br /> <br />
			证件类型：
			<c:set var="idTypeList" value="身份证,学生证,驾驶证,港澳台居住证" />
			<select name="idType">
				<c:forTokens items="${idTypeList}" delims="," var="item"
					varStatus="vs">
					<option value="${vs.index}" ${idType==vs.index?'selected':''}>${item}</option>
				</c:forTokens>
			</select> <br /> <br />
			<!-- 获取cookie的另一种写法 -->
			证件号码：<input type="text" name="idNumber" value="${idNumber}" size="20"
				maxlength="25" /><br /> <br /> 出生日期： <select name="birthYear">
				<option value=""></option>
				<c:forEach var="item" begin="1970" end="2016">
					<option value="${item}" ${birthYear==item?'selected':''}>${item}</option>
				</c:forEach>
			</select>年 <select name="birthMonth">
				<option value=""></option>
				<!-- 个位数前面补“0” -->
				<c:forEach var="item" begin="1" end="12">
					<c:if test="${item<10}">
						<c:set var="item" value="0${item}" />
					</c:if>
					<option value="${item}" ${birthMonth==item?'selected':''}>${item}</option>
				</c:forEach>
			</select>月 <select name="birthDay">
				<option value=""></option>
				<!-- 个位数前面补“0” -->
				<c:forEach var="item" begin="1" end="31">
					<c:if test="${item<10}">
						<c:set var="item" value="0${item}" />
					</c:if>
					<option value="${item}" ${birthDay==item?'selected':''}>${item}</option>
				</c:forEach>
			</select>日 <br /> <br /> 喜欢的颜色：<input type="color" name="favoriteColor"
				value="${favoriteColor}" id="favoriteColor" /> <br /> <br /> <input
				type="button" name="ok" value="上一步" onclick="this.form.submit()" />
		</form>
	</h3>

</body>
<!-- 脚文件 -->
<%@ include file="Foot.jsp"%>
