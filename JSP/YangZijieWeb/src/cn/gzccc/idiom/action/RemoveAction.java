/*
 * 添加成语交易类
 */

package cn.gzccc.idiom.action;

import java.util.HashMap;
import java.util.Map;

import cn.gzccc.idiom.BaseAction;
import cn.gzccc.idiom.IdiomOperator;
public class RemoveAction extends BaseAction {

	/*
	 * 交易执行函数，实现每个业务的具体细节。
	 */
	@Override
	public Map<String, Object> doAction(Map<String, String> paramMap) {

		// 1.先定义一个返回结果
		Map<String, Object> result = new HashMap<String, Object>();

		// 2.获取前端页面传入的参数
		String name = paramMap.get("name");
		
		/* 3.交易细节******************** */
		if(name==null || name.trim().length()==0){
			message = "成语名称不能为空...";
		}else{
			try {
				IdiomOperator.removeCnidiom(name);
				message = "已成功删除该成语["+name+"]...";
			}catch (Exception e) {
				super.setError("删除成语失败...["+e.getMessage()+"]");
				e.printStackTrace();
			}
		}
		
		result.put("message", message);
		/* ***************************** */

		// 4.将结果返回给前端页面
		result.put("name", name);
		return result;// 将结果返回
	}

}
