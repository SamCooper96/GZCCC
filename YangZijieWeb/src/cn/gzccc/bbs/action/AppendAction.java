/*
 * 发帖交易类
 */

package cn.gzccc.bbs.action;

import java.util.HashMap;
import java.util.Map;

import cn.gzccc.bbs.BaseAction;
import cn.gzccc.bbs.data.Forum;
import cn.gzccc.user.User;
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
		String title = paramMap.get("title");

		/* 3.交易细节******************** */
		if (title == null || title.trim().length()==0) {
			super.setError("标题不能为空...");
			return result;
		}
		title = title.trim();// 去掉标题空格。
		User user = (User)super.getSession().getAttribute("_USER");
		if (user == null) {
			super.setError("用户未登录...");
			return result;
		}
		String forumId = DateUtil.getFlowNo();// 索引号
		String author = user.getUserId();// 用户ID号（作者）
		String makeDate = DateUtil.getCurrentDate();// 日期
		System.out.println(forumId+"*"+title+"*"+author+"*"+makeDate);
		Forum forum = new Forum(forumId);
		forum.setAuthor(author);
		forum.setTitle(title);
		forum.setMakeDate(makeDate);
		/* ***************************** */

		// 4.将结果返回给前端页面
		result.put("title", title);
		return result;// 将结果返回
	}

}
