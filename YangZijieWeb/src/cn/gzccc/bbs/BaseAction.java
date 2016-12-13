/*
 * 交易基础类
 */
package cn.gzccc.bbs;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BaseAction implements IAction {

	protected String message = null;// 处理结果
	private String error = null;// 出错信息
	private HttpSession session = null;
	private HttpServletRequest request = null;
	
	@Override
	public Map<String, Object> doAction(Map<String, String> paramMap) {
		return null;
	}

	public String getError() {
		return error;
	}

	protected void setError(String error) {
		this.error = error;
	}

	public HttpSession getSession() {return session;}
	public void setSession(HttpSession session) {this.session = session;}

	public HttpServletRequest getRequest() {return request;}
	public void setRequest(HttpServletRequest request) {this.request = request;}
	
}
