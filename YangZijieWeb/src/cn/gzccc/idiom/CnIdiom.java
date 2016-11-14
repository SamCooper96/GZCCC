/*
 * 成语对象类（与数据库中的成语表的结构相对应）
 */
package cn.gzccc.idiom;

public class CnIdiom {

	private String itemId = null;// 索引号
	private String name = null;// 成语
	private String pinyin = null;// 拼音
	private String paraphrase = null;// 释义
	private String provenance = null;// 出处
	private String example = null;// 示例
	private String remark = null;// 备注

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public String getParaphrase() {
		return paraphrase;
	}

	public void setParaphrase(String paraphrase) {
		this.paraphrase = paraphrase;
	}

	public String getProvenance() {
		return provenance;
	}

	public void setProvenance(String provenance) {
		this.provenance = provenance;
	}

	public String getExample() {
		return example;
	}

	public void setExample(String example) {
		this.example = example;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
