<%@ page language="java" pageEncoding="UTF-8"%>
<jsp:useBean id="rect" class="cn.gzccc.bean.Rectangle"/>
<jsp:setProperty property="width" value="0" name="rect"/>
<jsp:setProperty property="height" value="0" name="rect"/>
<%
String path = request.getContextPath();//站点的根
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String width = request.getParameter("width");//获取传入参数（矩形宽度）
String height = request.getParameter("height");//获取传入参数（矩形高度）
try{
	rect.setWidth(Integer.parseInt(width));
	rect.setHeight(Integer.parseInt(height));
}catch(NumberFormatException e){
	;// 捕捉到异常后捕捉事情（加个分号“；”空语句）
}
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">  
    <title>${_TITLE}[计算矩形面积]</title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/style.css">
  </head>
  
  <body>
  <form name="theform" action="<%=path%>/views/rect/Rectangle.jsp">
  宽度：<input type="text" name="width" value="" size="4" maxlength="5" />
  &nbsp;&nbsp;高度：<input type="text" name="height" value="" size="4" maxlength="5" />
  &nbsp;&nbsp;<input type="button" value="确定" onclick="this.form.submit()"/>
  </form>
  &nbsp;宽度：<jsp:getProperty name="rect" property="width"/><br>
  &nbsp;高度：<jsp:getProperty name="rect" property="height"/><br>
  &nbsp;面积：<jsp:getProperty name="rect" property="area"/><br>
  <!-- SVG高级标签（只适用于HTML5浏览器） -->
  <%-- SVG高级标签（只适用于HTML5浏览器） --%>
  <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
       width="700px" height="500px"
       style="background-color:#999;">
    <rect id="rect_1" x="40px" y="40px" 
    width="<jsp:getProperty name="rect" property="width"/>px" 
    height="<%=rect.getHeight() %>px" 
    style="stroke:#FF0000;stroke-width:1px;"/>
    <text x="40px" y="30px" fill="#666"
    style="font-size:20px; stroke:#fff"><%=rect.getArea()%></text>
  </svg>
  
  </body>
</html>
