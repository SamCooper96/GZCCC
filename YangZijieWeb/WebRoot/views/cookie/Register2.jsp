<%@ page language="java" pageEncoding="UTF-8"%>
<!-- 头文件 -->
<%@ include file="Head.jsp"%>
<!-- 嵌入相关java代码 -->

<body>
	<h1>用户注册第二步</h1>
	<br />
	<h3>
		<form name="theform" action="<%=path%>/views/cookie/Register1.jsp"
			method="post">
			<!-- 读取cookie第一种方法（不使用java代码，区别于Register1.jsp） -->
			性别： <input type="radio" name="gender" value="0"
				${cookie.gender.value=='0'?'checked':''} />男 &nbsp;&nbsp;<input
				type="radio" name="gender" value="1"
				${cookie.gender.value=='1'?'checked':''} />女<br /> 证件类型： <select
				name="idType">
				<option value="0" ${cookie.idType.value=='0'?'selected':''}>身份证</option>
				<option value="1" ${cookie.idType.value=='1'?'selected':''}>学生证</option>
				<option value="2" ${cookie.idType.value=='2'?'selected':''}>驾驶证</option>
				<option value="3" ${cookie.idType.value=='3'?'selected':''}>港澳台居住证</option>
			</select><br /> 
			<!-- 获取cookie的另一种写法 -->
			证件号码：<input type="text" name="idNumber"
				value="${cookie['idNumber'].value}" size="20"
				maxlength="25" /><br /> <br /> <input type="button" name="ok"
				value="上一步" onclick="this.form.submit()" />
		</form>
	</h3>
</body>
<!-- 脚文件 -->
<%@ include file="Foot.jsp"%>
