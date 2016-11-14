/*
 * 用户对象类
 */
package cn.gzccc.user;

public class User {

	private String userId = null;
	private String userPd = null;
	private String userName = null;
	
	/*
	 * 构造器
	 */
	public User(String userId, String userPd) {
		this.userId = userId;
		this.userPd = userPd;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setUserPd(String userPd) {
		this.userPd = userPd;
	}
}
