package cn.gzccc.bbs.data;

public class Forum {
	
	private String forumId = null;// 索引号
	private String title = null;// 标题
	private String content = null;// 内容
	private String author = null;// 作者
	private String makeDate = null;// 日期
	private String remark = null;// 备注
	
	public Forum(String forumId) {
		this.forumId = forumId;
	}
	
	public String getForumId() {return forumId;}
	public void setForumId(String forumId) {this.forumId = forumId;}
	
	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}
	
	public String getContent() {return content;}
	public void setContent(String content) {this.content = content;}
	
	public String getAuthor() {return author;}
	public void setAuthor(String author) {this.author = author;}
	
	public String getMakeDate() {return makeDate;}
	public void setMakeDate(String makeDate) {this.makeDate = makeDate;}
	
	public String getRemark() {return remark;}
	public void setRemark(String remark) {this.remark = remark;}
	
	
}
