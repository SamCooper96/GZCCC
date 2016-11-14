<%@ page language="java" pageEncoding="UTF-8"%>
<!-- 头文件 -->
<%@ include file="Head.jsp" %>
  <!-- 页面主体 -->
  <body>
  <!-- 菜单导航条 -->
  <%@ include file="Menu.jsp" %>
  <h2>
  当前用户：${_USER.userId}
  </h2>
  </body>
<!-- 脚文件 -->
<%@ include file="Foot.jsp"%>