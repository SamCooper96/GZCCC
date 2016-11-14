/*
 * 成语数据的操作类，解决成语的增删改查。
 */
package cn.gzccc.idiom;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IdiomOperator {

	/*
	 * 查询成语
	 */
	public static List<CnIdiom> getIdioms(CnIdiom idiom) {
		List<CnIdiom> list = new ArrayList<CnIdiom>();
		String name = idiom.getName();
		String paraphrase = idiom.getParaphrase();
		String provenance = idiom.getProvenance();
		if (name == null && paraphrase == null && provenance == null) {
			return list;
		}
		if (name.trim().length() == 0 && paraphrase.trim().length() == 0
				&& provenance.trim().length() == 0) {
			return list;
		}
		// 数据库查询
		String sql = "select * from cn_idiom WHERE 1=1 ";// 注意后面有空格
		if (name != null && name.trim().length() > 0) {
			sql += "AND name LIKE '%" + idiom.getName() + "%' ";
		}
		if (paraphrase != null && paraphrase.trim().length() > 0) {
			sql += "AND paraphrase LIKE '%" + idiom.getParaphrase() + "%' ";
		}
		if (provenance != null && provenance.trim().length() > 0) {
			sql += "AND provenance LIKE '%" + idiom.getProvenance() + "%' ";
		}
		try {
			cn.gzccc.util.DBHelper dbHelper = cn.gzccc.util.DBHelper
					.getInstance();// 获取单一实例。
			List<Map<String, String>> maps = dbHelper.query(sql);// 查询结果集
			for (Map<String, String> map : maps) {
				CnIdiom cnIdiom = new CnIdiom();
				cnIdiom.setItemId(map.get("item_id"));
				cnIdiom.setName(map.get("name"));
				cnIdiom.setPinyin(map.get("pinyin"));
				cnIdiom.setParaphrase(map.get("paraphrase"));
				cnIdiom.setProvenance(map.get("provenance"));
				cnIdiom.setExample(map.get("example"));
				cnIdiom.setRemark(map.get("remark"));
				list.add(cnIdiom);
			}
		} catch (Exception e) {
			;
		}
		return list;
	}
	
	/*
	 * 添加成语
	 */
	public static void appendCnidiom(CnIdiom cnIdiom) throws Exception{
		if (cnIdiom==null) return;
		String sql = "INSERT INTO cn_idiom "
				+"(item_id, name, pinyin, paraphrase, provenance, example) "
				+"VALUES "
				+"('"+cnIdiom.getItemId()+"', '"+cnIdiom.getName()+"', '"+cnIdiom.getPinyin()+"', '"+cnIdiom.getParaphrase()+"', '"+cnIdiom.getProvenance()+"', '"+cnIdiom.getExample()+"')";
		cn.gzccc.util.DBHelper dbHelper = cn.gzccc.util.DBHelper.getInstance();// 获取单一实例。
		dbHelper.update(sql);
	}
	
	/*
	 * 删除成语
	 */
	public static void removeCnidiom(String name) throws Exception{
		String sql = "DELETE FROM cn_idiom WHERE name='"+name+"'";
		cn.gzccc.util.DBHelper dbHelper = cn.gzccc.util.DBHelper.getInstance();// 获取单一实例。
		dbHelper.update(sql);
	}
	
	/*
	 * 判断某成语在数据库中是否已存在。
	 */
	public static boolean isIdiomExist(String name) throws Exception{
		boolean exist = false;
		String sql = "SELECT NULL FROM cn_idiom WHERE name='"+name+"'";
		cn.gzccc.util.DBHelper dbHelper = cn.gzccc.util.DBHelper
				.getInstance();// 获取单一实例。
		List<Map<String, String>> maps = dbHelper.query(sql);// 查询结果集
		if (! maps.isEmpty()) exist = true;
		return exist;
	}
	
}
