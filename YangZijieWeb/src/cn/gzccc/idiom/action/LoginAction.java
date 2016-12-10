/*
 * 用户登录交易类
 */

package cn.gzccc.idiom.action;

import java.util.HashMap;
import java.util.Map;

import cn.gzccc.idiom.BaseAction;

public class LoginAction extends BaseAction {

	/*
	 * 交易执行函数，实现每个业务的具体细节。
	 */
	@Override
	public Map<String, Object> doAction(Map<String, String> paramMap) {

		// 1.先定义一个返回结果
		Map<String, Object> result = new HashMap<String, Object>();

		// 2.获取前端页面传入的参数
		String userId = paramMap.get("userId");//通过请求对象request获取页面传入的参数。
		String userPd = paramMap.get("userPd");//页面传入的参数，全为字符串类型。

		/* 3.交易细节******************** */

		//先判断用户是否存在
		String sql = " SELECT NULL FROM user WHERE user_id='" + userId
				+ "'";
		try {
			cn.gzccc.util.DBHelper dbHelper = cn.gzccc.util.DBHelper
					.getInstance();//获取单一实例。
			java.util.List<java.util.Map<String, String>> list = dbHelper
					.query(sql);//查询结果集
			if (list.isEmpty()) {
				super.setError("该用户不存在...");
			} else {
				//再判断该用户输入的密码是否正确。
				userPd = cn.gzccc.util.MD5.encrypt(userPd);//加密密码，再与数据库进行匹配验证。
				sql = " SELECT user_name FROM user WHERE user_id='"
						+ userId + "' AND pwd='" + userPd + "'";
				list = dbHelper.query(sql);
				if (list.isEmpty()) {
					super.setError("密码错误");
				} else {
					cn.gzccc.user.User user = new cn.gzccc.user.User(
							userId, userPd);
					java.util.Map<String, String> map = list.get(0);//取出结果集中的头记录。
					String userName = map.get("user_name");//取出对应的字段值
					user.setUserName(userName);
					super.getSession().setAttribute("_USER", user);//将用户实例设置到回话对象中的属性
				}
			}
		} catch (Exception e) {
			super.setError("数据库连接出错（"+e.getMessage()+"）...");
		}
		/* ***************************** */

		// 4.将结果返回给前端页面
		result.put("loginTime", cn.gzccc.util.DateUtil.getCurrentTime());
		return result;// 将结果返回
	}

}
