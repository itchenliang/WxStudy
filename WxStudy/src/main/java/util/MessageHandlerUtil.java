package util;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import resp.Article;
import resp.NewsMessage;
import resp.TextMessage;

/**
 * 消息处理工具类 Created by xdp on 2016/1/26.
 */
public class MessageHandlerUtil {

	 /** 
     * 解析微信发来的请求（XML） 
     *  
     * @param request 
     * @return 
     * @throws Exception 
     */  
    public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {  
        // 将解析结果存储在HashMap中  
        Map<String, String> map = new HashMap<String, String>();  
  
        // 从request中取得输入流  
        InputStream inputStream = request.getInputStream();  
        // 读取输入流  
        SAXReader reader = new SAXReader();  
        Document document = reader.read(inputStream);  
        // 得到xml根元素  
        Element root = document.getRootElement();  
        // 得到根元素的所有子节点  
          
        @SuppressWarnings("unchecked")  
        List<Element> elementList = root.elements();  
  
        // 遍历所有子节点  
        for (Element e : elementList)  
            map.put(e.getName(), e.getText());  
  
        // 释放资源  
        inputStream.close();  
        inputStream = null;  
  
        return map;  
    }  

	// 根据消息类型 构造返回消息
	public static String buildXml(Map<String, String> map) {
		String result;
		String msgType = map.get("MsgType").toString();
		String Content = map.get("Content").toString();
		
		if (StringUtils.isBlank(Content)) {
			Content = "0";
		}
		String toUserName = map.get("ToUserName").toString();
		String fromUserName = map.get("FromUserName").toString();
		System.out.println("MsgType:" + msgType);
		System.out.println("用户输入的信息为：" + Content);
		if (msgType.toUpperCase().equals(MessageUtil.RESP_MESSAGE_TYPE_TEXT)) {
			//普通文本消息
//			TextMessage textMessage = new TextMessage();
//			textMessage.setFromUserName(fromUserName);
//			textMessage.setToUserName(toUserName);
//			textMessage.setMsgType(msgType);
//			textMessage.setCreateTime(new Date().getTime());
//			textMessage.setContent("您好！欢迎关注俗人的微信公众号！如想看更新内容请输入'1'");
//			return MessageUtil.textMessageToXml(textMessage);
				//result = MessageUtil.initNewsMessage(toUserName, fromUserName);
				result = buildTextMessage(map, "您好！欢迎关注俗人的微信公众号！如想看更新内容请输入'1'");
			}else {
					fromUserName = map.get("FromUserName");
				// 开发者微信号
					toUserName = map.get("ToUserName");
				result = String.format(
						"<xml>" + "<ToUserName><![CDATA[%s]]></ToUserName>" + "<FromUserName><![CDATA[%s]]></FromUserName>"
								+ "<CreateTime>%s</CreateTime>" + "<MsgType><![CDATA[text]]></MsgType>"
								+ "<Content><![CDATA[%s]]></Content>" + "</xml>",
						fromUserName, toUserName, getUtcTime(), "请回复如下关键词：\n文本\n图片\n语音\n视频\n音乐\n图文");
			}
			return result;
		 
	}

	/**	
	 * 构造文本消息
	 *
	 * @param map
	 * @param content
	 * @return
	 */
	public static String buildTextMessage(Map<String, String> map, String content) {
		// 发送方帐号
		String fromUserName = map.get("FromUserName");
		// 开发者微信号
		String toUserName = map.get("ToUserName");
		/**
		 * 文本消息XML数据格式 <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
		 * <FromUserName><![CDATA[fromUser]]></FromUserName>
		 * <CreateTime>1348831860</CreateTime>
		 * <MsgType><![CDATA[text]]></MsgType> <Content><![CDATA[this is a
		 * test]]></Content> <MsgId>1234567890123456</MsgId> </xml>
		 */
		return String.format(
				"<xml>" + "<ToUserName><![CDATA[%s]]></ToUserName>" 
						+ "<FromUserName><![CDATA[%s]]></FromUserName>"
						+ "<CreateTime>%s</CreateTime>" 
						+ "<MsgType><![CDATA[text]]></MsgType>"
						+ "<Content><![CDATA[%s]]></Content>" 
			+ "</xml>",
				fromUserName, toUserName, getUtcTime(), content);
	}

	private static String getUtcTime() {
		Date dt = new Date();// 如果不需要格式,可直接用dt,dt就是当前系统时间
		DateFormat df = new SimpleDateFormat("yyyyMMddhhmm");// 设置显示格式
		String nowTime = df.format(dt);
		long dd = (long) 0;
		try {
			dd = df.parse(nowTime).getTime();
		} catch (Exception e) {

		}
		return String.valueOf(dd);
	}
}