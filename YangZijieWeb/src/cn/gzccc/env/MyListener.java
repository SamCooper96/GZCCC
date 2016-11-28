/*
 * 监听器
 */

package cn.gzccc.env;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
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
	public void contextInitialized(ServletContextEvent sce) {}
	
	// 产生一个新的会话。
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("产生一个新的会话："+se.getSession().getId());
	}
	// 注销一个旧的会话
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("注销一个旧的会话："+se.getSession().getId());
	}
	
	// 
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		
	}
	// 
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println(sre.getServletRequest().getRemoteHost());
	}

}
