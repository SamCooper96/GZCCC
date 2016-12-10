/*
 * 监听器
 */

package cn.gzccc.env;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyListener implements ServletContextListener,
									HttpSessionListener,
									ServletRequestListener {
	// 当工程停止时触发contextDestroyed。
	@Override
	public void contextDestroyed(ServletContextEvent sce) {}
	// 当工程初始化时触发contextInitialized。
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();// 应用对象
		String version = context.getInitParameter("version");// 获取web.xml中的有关参数。
		context.setAttribute("_VERSION", version);// 设置应用对象的属性，可以由所有的窗口所共享。
	}
	
	// 产生一个新的会话。
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		//System.out.println("产生一个新的会话："+se.getSession().getId());
	}
	// 注销一个旧的会话
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		//System.out.println("注销一个旧的会话："+se.getSession().getId());
	}
	
	// 当注销一个用户请求时，触发requestDestroyed。
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {}
	// 当用户提交一个请求时，触发requestInitialized。
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
//		HttpServletRequest hsr = (HttpServletRequest)sre.getServletRequest();
//		String uri = hsr.getRequestURI();// 用户请求的URI地址。
//		if(uri.endsWith("/views/idiom/Welcome.jsp")){
//			HttpSession session = hsr.getSession();// 获取会话
//			cn.gzccc.user.User user = (cn.gzccc.user.User)session.getAttribute("_USER");
//			if (user == null) {
//				System.out.println("未登录用户试图访问成语系统...");
//			}else{
//				System.out.println("用户（"+user.getUserName()+"）已登录成语系统...");
//			}
//		}
	}

}
