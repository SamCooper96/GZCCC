/*
 * 成语接龙交易类
 */

package cn.gzccc.idiom.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.gzccc.idiom.BaseAction;
import cn.gzccc.idiom.CnIdiom;
import cn.gzccc.idiom.IdiomOperator;

public class DragonAction extends BaseAction {

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
		if (name != null && name.trim().length() > 0) {
			name = name.trim();
			String sql = "SELECT * FROM cn_idiom WHERE name LIKE '" + name
					+ "%'";
			try {
				List<CnIdiom> list = new ArrayList<CnIdiom>();
				cn.gzccc.util.DBHelper dbHelper = cn.gzccc.util.DBHelper
						.getInstance();// 获取单一实例。
				List<Map<String, String>> maps = dbHelper.query(sql);// 查询结果集
				String head = name;// 成语头字。
				while (!maps.isEmpty()) {
					int i = 0;// 要取出第i个记录，其中i为随机数。
					double d = Math.random();// 取随机数，0.0 >= d < 1.0。
					i = (int) (d * maps.size());// 对结果进行取整，转换为int数据类型。
					Map<String, String> map = maps.get(i);// 取其中一条记录。
					CnIdiom cnIdiom = new CnIdiom();
					cnIdiom.setItemId(map.get("item_id"));
					cnIdiom.setName(map.get("name"));
					cnIdiom.setPinyin(map.get("pinyin"));
					cnIdiom.setParaphrase(map.get("paraphrase"));
					cnIdiom.setProvenance(map.get("provenance"));
					cnIdiom.setExample(map.get("example"));
					cnIdiom.setRemark(map.get("remark"));
					list.add(cnIdiom);
					// 接着再找下一个。
					String tail = map.get("name");// 出去成语全名。
					tail = tail.substring(tail.length() - 1);// 取出成语的最后一个字。
					// 如果接龙形成一个环路则不再往下进行（即最后一个成语的尾字是第一个成语的头字）。
					// “这样的做法不怎么妥当...”
					if (head.equals(tail)) {
						break;
					}
					head = tail;// 匹配完毕后，本次的“尾”就成了下一次的“头”。
					sql = "SELECT * FROM cn_idiom WHERE name LIKE '" + tail
							+ "%'";
					maps = dbHelper.query(sql);
				}
				result.put("list", list);// 查询结果集
				result.put("count", list.size());// 查询结果记录数。
			} catch (Exception e) {
				;
			}
		}

		/* *************************** */

		// 4.将结果返回给前端页面
		result.put("name", name);
		return result;// 将结果返回
	}

}
