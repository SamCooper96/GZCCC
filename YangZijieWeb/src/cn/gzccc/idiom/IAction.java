/*
 * 交易接口类（里头的变量和函数全是抽象的）
 */
package cn.gzccc.idiom;

import java.util.Map;

public interface IAction {

	public Map<String, Object> doAction(Map<String, String> paramMap);

	public String getError();
	
}
