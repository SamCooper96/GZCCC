/*
 * 成语查询交易类
 */

package cn.gzccc.idiom.action;

import java.util.HashMap;
import java.util.Map;

import cn.gzccc.idiom.BaseAction;
import cn.gzccc.idiom.CnIdiom;
import cn.gzccc.idiom.IdiomOperator;

public class QueryAction extends BaseAction {

	/*
	 * 交易执行函数，实现每个业务的具体细节。
	 */
	@Override
	public Map<String, Object> doAction(Map<String, String> paramMap) {

		// 1.先定义一个返回结果
		Map<String, Object> result = new HashMap<String, Object>();

		// 2.获取前端页面传入的参数
		String name = paramMap.get("name");
		String paraphrase = paramMap.get("paraphrase");
		String provenance = paramMap.get("provenance");

		/* 3.交易细节******************** */
		CnIdiom idiom = new CnIdiom();
		idiom.setName(name);
		idiom.setParaphrase(paraphrase);
		idiom.setProvenance(provenance);
		java.util.List<CnIdiom> list = IdiomOperator.getIdioms(idiom);// 查询结果集
		result.put("list", list);// 查询结果集
		result.put("count", list.size());// 查询结果记录数。
		/* *************************** */

		// 4.将结果返回给前端页面
		result.put("name", name);
		result.put("paraphrase", paraphrase);
		result.put("provenance", provenance);
		return result;// 将结果返回
	}

}
