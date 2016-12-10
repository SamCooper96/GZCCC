/*
 * 添加成语交易类
 */

package cn.gzccc.idiom.action;

import java.util.HashMap;
import java.util.Map;

import cn.gzccc.idiom.BaseAction;
import cn.gzccc.idiom.CnIdiom;
import cn.gzccc.idiom.IdiomOperator;
import cn.gzccc.util.DateUtil;

public class WordCountAction extends BaseAction {

	/*
	 * 交易执行函数，实现每个业务的具体细节。
	 */
	@Override
	public Map<String, Object> doAction(Map<String, String> paramMap) {

		// 1.先定义一个返回结果
		Map<String, Object> result = new HashMap<String, Object>();

		// 2.获取前端页面传入的参数
		String words = paramMap.get("words");

		/* 3.交易细节******************** */
		int countNum = 0;
		if(words==null || words.trim().length()==0){
			message = "文本不能为空";
		}else{
			message = null;
			countNum = words.trim().length();
		}
		result.put("message", message);
		/* *************************** */

		// 4.将结果返回给前端页面
		
		result.put("countNum", countNum);
		return result;// 将结果返回
	}

}
