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

public class AppendAction extends BaseAction {

	/*
	 * 交易执行函数，实现每个业务的具体细节。
	 */
	@Override
	public Map<String, Object> doAction(Map<String, String> paramMap) {

		// 1.先定义一个返回结果
		Map<String, Object> result = new HashMap<String, Object>();

		// 2.获取前端页面传入的参数
		String name = paramMap.get("name");
		String pinyin = paramMap.get("pinyin");
		String paraphrase = paramMap.get("paraphrase");
		String provenance = paramMap.get("provenance");
		String example = paramMap.get("example");

		/* 3.交易细节******************** */
		if(name==null || name.trim().length()==0){
			message = "成语名称不能为空...";
		}else if(pinyin==null || pinyin.trim().length()==0){
			message = "成语拼音不能为空...";
		}else{
			// 如果该成语已在数据库中存在，则不允许添加。
			name = name.trim();
			try {
				boolean exist = IdiomOperator.isIdiomExist(name);
				if(exist){
					message = "添加失败，该成语已存在...";
					super.setError("添加失败，该成语已存在...");
				}else{
					// 将成语添加到数据库表中。
					String itemId = DateUtil.getFlowNo();// 生成一个带有时间戳的流水号。
					CnIdiom cnIdiom = new CnIdiom();
					cnIdiom.setItemId(itemId);
					cnIdiom.setName(name);
					cnIdiom.setPinyin(pinyin);
					cnIdiom.setParaphrase(paraphrase);
					cnIdiom.setProvenance(provenance);
					cnIdiom.setExample(example);
					IdiomOperator.appendCnidiom(cnIdiom);// 执行插入。
					message = "已成功添加一条成语...";
				}
			} catch (Exception e) {
				message = "添加成语失败...["+e.getMessage()+"]";
				e.printStackTrace();
			}
		}
		result.put("message", message);
		/* *************************** */

		// 4.将结果返回给前端页面
		result.put("name", name);
		result.put("pinyin", pinyin);
		result.put("paraphrase", paraphrase);
		result.put("provenance", provenance);
		result.put("example", example);
		return result;// 将结果返回
	}

}
