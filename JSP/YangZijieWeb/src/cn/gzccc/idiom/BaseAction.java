/*
 * 交易基础类
 */
package cn.gzccc.idiom;

import java.util.Map;

public class BaseAction implements IAction {

	protected String message = null;// 处理结果
	
	private String error = null;// 出错信息
	
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
	
}
