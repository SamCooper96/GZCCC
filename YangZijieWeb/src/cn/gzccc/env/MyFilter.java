package cn.gzccc.env;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MyFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	@Override
	public void destroy() {}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hsr = (HttpServletRequest)request;
		HttpSession session = hsr.getSession();
		String uri = hsr.getRequestURI();// 取出用户请求的URI。
		//对于试图通过非正常途径修改成语库的行为进行拦截。
		cn.gzccc.user.User user = (cn.gzccc.user.User)session.getAttribute("_USER");
		if (user == null && !uri.endsWith("/Login.idiom")) {
			String errorPage = "/views/idiom/Error.jsp";
			String error = "确保正常登录后使用...";
			request.setAttribute("_ERROR", error);
			session.getServletContext().getRequestDispatcher(errorPage).forward(request, response);
		}else{
			chain.doFilter(request, response);// 继续前进。
		}
		
	}

}
