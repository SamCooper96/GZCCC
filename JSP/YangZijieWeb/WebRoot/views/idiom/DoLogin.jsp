<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();//站点的根
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String userId = request.getParameter("userId");//通过请求对象request获取页面传入的参数。
	String userPd = request.getParameter("userPd");//页面传入的参数，全为字符串类型。

	//先判断用户是否存在
	String sql = " SELECT NULL FROM user WHERE user_id='" + userId
			+ "'";
	try {
		cn.gzccc.util.DBHelper dbHelper = cn.gzccc.util.DBHelper
				.getInstance();//获取单一实例。
		java.util.List<java.util.Map<String, String>> list = dbHelper
				.query(sql);//查询结果集
		if (list.isEmpty()) {
			//当登录失败时，则重定向到“出错”页面。
			session.setAttribute("_ERROR", "该用户不存在...");
			response.sendRedirect("Error.jsp");//用响应对象response进行页面重定向。
		} else {
			//再判断该用户输入的密码是否正确。
			userPd = cn.gzccc.util.MD5.encrypt(userPd);//加密密码，再与数据库进行匹配验证。
			sql = " SELECT user_name FROM user WHERE user_id='"
					+ userId + "' AND pwd='" + userPd + "'";
			list = dbHelper.query(sql);
			if (list.isEmpty()) {
				//当登录失败时，则重定向到“出错”页面。
				session.setAttribute("_ERROR", "密码错误");
				response.sendRedirect("Error.jsp");//用响应对象response进行页面重定向。
			} else {
				cn.gzccc.user.User user = new cn.gzccc.user.User(
						userId, userPd);
				java.util.Map<String, String> map = list.get(0);//取出结果集中的头记录。
				String userName = map.get("user_name");//取出对应的字段值
				user.setUserName(userName);
				session.setAttribute("_USER", user);//将用户实例设置到回话对象中的属性
				//当登录成功时，则重定向到“欢迎”页面。
				response.sendRedirect("Welcome.jsp");//用响应对象response进行页面重定向。
			}
		}
	} catch (Exception e) {
		out.println("数据库连接出错...");
	}

	/*
	 if(userId!=null && userPd!=null && userPd.equals("8888")){
	 cn.gzccc.user.User user = new cn.gzccc.user.User(userId, userPd);
	 session.setAttribute("_USER", user);//将用户实例设置到回话对象中的属性
	 //当登录成功时，则重定向到“欢迎”页面。
	 response.sendRedirect("Welcome.jsp");//用响应对象response进行页面重定向。
	 }else{
	 //当登录失败时，则重定向到“出错”页面。
	 session.setAttribute("_ERROR", "密码错误");
	 response.sendRedirect("Error.jsp");//用响应对象response进行页面重定向。
	 }
	 */
%>

