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
 * ��Ϣ�������� Created by xdp on 2016/1/26.
 */
public class MessageHandlerUtil {

	 /** 
     * ����΢�ŷ���������XML�� 
     *  
     * @param request 
     * @return 
     * @throws Exception 
     */  
    public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {  
        // ����������洢��HashMap��  
        Map<String, String> map = new HashMap<String, String>();  
  
        // ��request��ȡ��������  
        InputStream inputStream = request.getInputStream();  
        // ��ȡ������  
        SAXReader reader = new SAXReader();  
        Document document = reader.read(inputStream);  
        // �õ�xml��Ԫ��  
        Element root = document.getRootElement();  
        // �õ���Ԫ�ص������ӽڵ�  
          
        @SuppressWarnings("unchecked")  
        List<Element> elementList = root.elements();  
  
        // ���������ӽڵ�  
        for (Element e : elementList)  
            map.put(e.getName(), e.getText());  
  
        // �ͷ���Դ  
        inputStream.close();  
        inputStream = null;  
  
        return map;  
    }  

	// ������Ϣ���� ���췵����Ϣ
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
		System.out.println("�û��������ϢΪ��" + Content);
		if (msgType.toUpperCase().equals(MessageUtil.RESP_MESSAGE_TYPE_TEXT)) {
			//��ͨ�ı���Ϣ
//			TextMessage textMessage = new TextMessage();
//			textMessage.setFromUserName(fromUserName);
//			textMessage.setToUserName(toUserName);
//			textMessage.setMsgType(msgType);
//			textMessage.setCreateTime(new Date().getTime());
//			textMessage.setContent("���ã���ӭ��ע���˵�΢�Ź��ںţ����뿴��������������'1'");
//			return MessageUtil.textMessageToXml(textMessage);
				//result = MessageUtil.initNewsMessage(toUserName, fromUserName);
				result = buildTextMessage(map, "���ã���ӭ��ע���˵�΢�Ź��ںţ����뿴��������������'1'");
			}else {
					fromUserName = map.get("FromUserName");
				// ������΢�ź�
					toUserName = map.get("ToUserName");
				result = String.format(
						"<xml>" + "<ToUserName><![CDATA[%s]]></ToUserName>" + "<FromUserName><![CDATA[%s]]></FromUserName>"
								+ "<CreateTime>%s</CreateTime>" + "<MsgType><![CDATA[text]]></MsgType>"
								+ "<Content><![CDATA[%s]]></Content>" + "</xml>",
						fromUserName, toUserName, getUtcTime(), "��ظ����¹ؼ��ʣ�\n�ı�\nͼƬ\n����\n��Ƶ\n����\nͼ��");
			}
			return result;
		 
	}

	/**	
	 * �����ı���Ϣ
	 *
	 * @param map
	 * @param content
	 * @return
	 */
	public static String buildTextMessage(Map<String, String> map, String content) {
		// ���ͷ��ʺ�
		String fromUserName = map.get("FromUserName");
		// ������΢�ź�
		String toUserName = map.get("ToUserName");
		/**
		 * �ı���ϢXML���ݸ�ʽ <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
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
		Date dt = new Date();// �������Ҫ��ʽ,��ֱ����dt,dt���ǵ�ǰϵͳʱ��
		DateFormat df = new SimpleDateFormat("yyyyMMddhhmm");// ������ʾ��ʽ
		String nowTime = df.format(dt);
		long dd = (long) 0;
		try {
			dd = df.parse(nowTime).getTime();
		} catch (Exception e) {

		}
		return String.valueOf(dd);
	}
}