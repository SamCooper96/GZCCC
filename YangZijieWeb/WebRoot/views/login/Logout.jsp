<%@ page language="java" pageEncoding="UTF-8"%>
<!-- 退出登录，注销会话（将会话中的所有属性全部清除）。运用session.invalidate()。 -->
<% session.invalidate(); %>
<jsp:forward page="Login.jsp"></jsp:forward>
<!-- 这个表示是JSP动作指令标签，forward表示页面跳转，跳转到Logout.jsp。教材中P104有详细说明。 -->