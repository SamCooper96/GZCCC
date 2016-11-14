package cn.gzccc.run;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import cn.gzccc.util.DBHelper;

public class MyStartup extends HttpServlet{

	String appName = null;
	
	/*
	 * 重写父类的init函数
	 * （init函数是启动函数，在工程启动时会自动执行。）
	 */
	@Override
	public void init() throws ServletException {
		super.init();//调用父类的同名函数。
		
		//Web工程的上下文对象，该对象可以由整个工程的所有对象共享。
		ServletContext context = super.getServletContext();
		appName = context.getServletContextName();//工程别名
		
		//设置全局属性，可以在所有Java和JSP中共享。
		context.setAttribute("_TITLE", appName);//以键-值对的形式设置属性。
		
		//工程启动画面
		/**精美输出**************************/
		int symbol = "*".charAt(0);
		String runInfo = (char)symbol+"        "+appName+" Startup        "+(char)symbol;
		StringBuffer stars = new StringBuffer();
		StringBuffer space = new StringBuffer();
		int length = runInfo.getBytes().length;
		for(int i=0; i<length; i++){
			stars.append((char)symbol);
			if(i==0 || i==length-1){
				space.append((char)symbol);//星号
			}else{
				space.append((char)32);//空格
			}
		}
		System.out.println("\n"+stars.toString()+"\n"+space+"\n"+runInfo+"\n"+space+"\n"+stars.toString()+"\n");
		/***********************************/
		
		// 测试数据库连接
		String sql = "select COUNT(*) as Count from cn_idiom";
		try {
			DBHelper dbHelper = DBHelper.getInstance();//获取单一实例。
			List<Map<String, String>> list = dbHelper.query(sql);//查询结果集
			Map<String, String> map = list.get(0);//取出第一行记录。
			String count = map.get("Count");//通过字段名（键），取出
			System.out.println("数据库连接成功，共有"+count+"条成语。");
		} catch (Exception e) {
			System.err.println("数据库连接出错...");
		}
		System.out.println("\n\n");
	}
	
	/*
	 * destroy函数也是对父类函数的重写
	 * destroy函数是销毁函数，在工程停止的时候会自动执行
	 */
	@Override
	public void destroy() {
		super.destroy();
		
		System.out.println(appName+"已停止...");
	}
}
