/*
 * 成语项目的Servlet
 */
package cn.gzccc.idiom;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IdiomControllor extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

	/*
	 * 响应前端的用户请求
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 获取前端页面的所有传入参数，解决字符编码问题。
		Enumeration<String> paraNames = request.getParameterNames();// 参数名字集。
		Map<String, String> paramMap = new HashMap<String, String>();// 参数“键-值”对。
		while (paraNames.hasMoreElements()) {
			String key = paraNames.nextElement();// 取出一个参数名字，并且将指针移到下一个
			String value = request.getParameter(key);
			value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
			paramMap.put(key, value);// 将参数名和值添加到映射中。
		}

		// 交易类和输出页面
		String className = null;
		String page = null;

		// 析取交易码
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf('/') + 1);
		String txcode = uri.substring(0, uri.indexOf('.'));
		Map<String, String> actionConfig = getActionConfig(txcode);
		if(actionConfig != null){
			className = actionConfig.get("class");
			page = actionConfig.get("view");
		}

		// 找到相应的交易类并执行
		IAction action;
		try {
			action = (IAction) Class.forName(className).newInstance();
			Map<String, Object> result = action.doAction(paramMap);// 执行交易
			Iterator<String> keys = result.keySet().iterator();// 键集
			while (keys.hasNext()) {
				String key = keys.next();
				Object obj = result.get(key);
				request.setAttribute(key, obj);// 将交易执行返回的结果输出给前端。
			}
			// 判断后台交易是否有配置错误信息，若有，则定向到出错页面。
			String error = action.getError();
			if (error!=null && error.length()>0) {
				page = "/views/idiom/Error.jsp";
				request.setAttribute("_ERROR", error);
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.err.println("交易执行失败..." + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.err.println("交易执行失败，找不到类：" + className);
		}

		// 发布到目标页面。
		ServletContext application = super.getServletContext();
		application.getRequestDispatcher(page).forward(request, response);
	}

	// 获取交易配置信息
	private static java.util.List<java.util.Map<String, String>> actionList = null;

	private static java.util.Map<String, String> getActionConfig(String txcode) {
		java.util.Map<String, String> actionMap = null;
		if (txcode == null || txcode.length() == 0)
			return actionMap;
		if (actionList == null) {
			// 装载配置文件
			java.io.FileInputStream fis = null;
			try {
				String path = IdiomControllor.class.getClassLoader()
						.getResource("config/").getPath();
				path = java.net.URLDecoder.decode(path, "UTF-8");// 解决路径中的中文乱码
				java.io.File file = new java.io.File(path + "actionlist.xml");// 文件对象,并联配置文件
				fis = new java.io.FileInputStream(file);// 将文件读入到输入流中
				javax.xml.parsers.DocumentBuilder docBuilder = javax.xml.parsers.DocumentBuilderFactory
						.newInstance().newDocumentBuilder();
				org.w3c.dom.Document doc = docBuilder.parse(fis);
				org.w3c.dom.Element root = doc.getDocumentElement();
				org.w3c.dom.NodeList nodes = root
						.getElementsByTagName("action");
				actionList = new java.util.ArrayList<java.util.Map<String, String>>();
				for (int i = 0; i < nodes.getLength(); i++) {
					org.w3c.dom.Node node = nodes.item(i);
					if (node.hasAttributes()) {
						java.util.Map<String, String> map = new java.util.HashMap<String, String>();
						org.w3c.dom.NamedNodeMap attrs = node.getAttributes();
						String name = attrs.getNamedItem("name").getNodeValue();
						String className = attrs.getNamedItem("class")
								.getNodeValue();
						String desc = attrs.getNamedItem("desc").getNodeValue();
						map.put("name", name);
						map.put("class", className);
						map.put("desc", desc);
						actionList.add(map);
						org.w3c.dom.NodeList viewNodes = node.getChildNodes();
						for (int j = 0; j < viewNodes.getLength(); j++) {
							org.w3c.dom.Node viewNode = viewNodes.item(j);
							if (viewNode.getNodeName().equals("view")) {
								String view = viewNode.getTextContent();
								map.put("view", view);
								break;
							}
						}
					}
				}
			} catch (Exception e) {
				System.err.println("装载交易配置文件出错！");
				e.printStackTrace();
				return null;
			} finally {
				if (fis != null)
					try {
						fis.close();
					} catch (java.io.IOException e) {
					}
			}
		}
		if (actionList != null) {
			for (java.util.Map<String, String> map : actionList) {
				if (txcode.equals(map.get("name"))) {
					return map;
				}
			}
		}
		return actionMap;
	}

}
