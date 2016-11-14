<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();//站点的根
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">  
    <title>${_TITLE}[用户登录]</title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/style.css">
  </head>
  
  <body>
  <form name="theform" action="<%=path%>/views/idiom/DoLogin.jsp" method="post">
	  <table width="300" align="center" border="1">
	  	<tr>
	  		<td align="right">用户账号：</td>
	  		<td align="left"><input type="text" name="userId" value="1504220236" size="12" maxlength="15" /></td>
	  	</tr>
	  	<tr>
	  		<td align="right">密码：</td>
	  		<td align="left"><input type="password" name="userPd" value="8888" size="12" maxlength="15" /></td>
	  	</tr>
	  	<tr>
	  		<td align="center" colspan="2">
	  			<input type="button" value="确定" onclick="this.form.submit()"/>
	  		</td>
	  	</tr>
	  </table>
  </form>
  </body>
</html>
