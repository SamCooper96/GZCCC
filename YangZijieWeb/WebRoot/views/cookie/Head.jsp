<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<%
	String path = request.getContextPath();//站点的根
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("_PATH", path);//当前页面对象。
	//获取传入参数，将各个参数写到客户端本地（获取前端页面的所有传入参数，解决字符编码问题）。
	java.util.Enumeration<String> paraNames = request
			.getParameterNames();// 参数名字集。
	while (paraNames.hasMoreElements()) {
		String key = paraNames.nextElement();// 取出一个参数名字，并且将指针移到下一个
		String value = request.getParameter(key);
		// 写Cookie
		Cookie ck = new Cookie(key, value);// 以“键-值”对的形式实例化一个Cookie。
		ck.setMaxAge(30 * 60);// 设置有效期为“30分钟”（若不设置则无生存期；若为0则表示要删除某个Cooike）。
		response.addCookie(ck);// 将这个Cookie发送给客户端
	}
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>${_TITLE}</title>
<link rel="stylesheet" type="text/css" href="${_PATH}/css/style.css">
</head>