package servlet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import resp.Article;
import resp.NewsMessage;
import resp.TextMessage;
import util.MessageUtil;

/**
 * 核心服务类 
 * @author Administrator
 *
 */
public class CoreService {
	 /** 
     * 处理微信发来的请求 
     *  
     * @param request 
     * @return 
     */  
    public static String processRequest(HttpServletRequest request) {  
    	// 默认返回的文本消息内容
        String respMessage = null;  
        //String respContext ="";
        try {  
            // xml请求解析  
            Map<String, String> requestMap = MessageUtil.parseXml(request);  
  
            // 发送方帐号（open_id）  
            String fromUserName = requestMap.get("FromUserName");  
            // 公众帐号  
            String toUserName = requestMap.get("ToUserName");  
            // 消息类型  
            String msgType = requestMap.get("MsgType");  
           
            // 默认回复此文本消息  
            TextMessage textMessage = new TextMessage();  
            textMessage.setToUserName(fromUserName);  
            textMessage.setFromUserName(toUserName);  
            textMessage.setCreateTime(new Date().getTime());  
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);  
            textMessage.setFuncFlag(0);  
            // 由于href属性值必须用双引号引起，这与字符串本身的双引号冲突，所以要转义  
            textMessage.setContent("您好！欢迎关注俗人的微信公众号！如想看更新内容请输入'1'");  
            // 将文本消息对象转换成xml字符串  
            respMessage = MessageUtil.textMessageToXml(textMessage);  
            
            
            // 文本消息  
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {  
                // 接收用户发送的文本消息内容  
                String content = requestMap.get("Content");  
  
                // 创建图文消息  
                NewsMessage newsMessage = new NewsMessage();  
                newsMessage.setToUserName(fromUserName);  
                newsMessage.setFromUserName(toUserName);  
                newsMessage.setCreateTime(new Date().getTime());  
                newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);  
                newsMessage.setFuncFlag(0);
  
                List<Article> articleList = new ArrayList<Article>();  
                // 单图文消息  
                if ("1".equals(content)) {  
                    Article article = new Article();  
                    article.setTitle("JAVA面试题大全");  
                    article.setDescription("大家好，欢迎来到陈亮的公众号，这是一些java面试题，请大家笑纳！！！");  
                    article.setPicUrl("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1525087927&di=53925f1aef732b52981db807348254d2&src=http://img.sj33.cn/uploads/allimg/201401/7-140126231522E0.jpg");  
                    article.setUrl("https://blog.csdn.net/jiujiedexiaoming/article/details/55510865");  
                    articleList.add(article);  
                    // 设置图文消息个数  
                    newsMessage.setArticleCount(articleList.size());  
                    // 设置图文消息包含的图文集合  
                    newsMessage.setArticles(articleList);  
                    // 将图文消息对象转换成xml字符串  
                    respMessage = MessageUtil.newsMessageToXml(newsMessage);  
                }  
                // 单图文消息---不含图片  
                else if ("2".equals(content)) {  
                    Article article = new Article();  
                    article.setTitle("微信公众帐号开发教程Java版");  
                    // 图文消息中可以使用QQ表情、符号表情  
                    article.setDescription("柳峰，80后，" + emoji(0x1F6B9)  
                            + "，微信公众帐号开发经验4个月。为帮助初学者入门，特推出此系列连载教程，也希望借此机会认识更多同行！\n\n目前已推出教程共12篇，包括接口配置、消息封装、框架搭建、QQ表情发送、符号表情发送等。\n\n后期还计划推出一些实用功能的开发讲解，例如：天气预报、周边搜索、聊天功能等。");  
                    // 将图片置为空  
                    article.setPicUrl("");  
                    article.setUrl("http://blog.csdn.net/lyq8479");  
                    articleList.add(article);  
                    newsMessage.setArticleCount(articleList.size());  
                    newsMessage.setArticles(articleList);  
                    respMessage = MessageUtil.newsMessageToXml(newsMessage);  
                }  
                // 多图文消息  
                else if ("3".equals(content)) {  
                    Article article1 = new Article();  
                    article1.setTitle("微信公众帐号开发教程\n引言");  
                    article1.setDescription("");  
                    article1.setPicUrl("http://0.xiaoqrobot.duapp.com/images/avatar_liufeng.jpg");  
                    article1.setUrl("http://blog.csdn.net/lyq8479/article/details/8937622");  
  
                    Article article2 = new Article();  
                    article2.setTitle("第2篇\n微信公众帐号的类型");  
                    article2.setDescription("");  
                    article2.setPicUrl("http://avatar.csdn.net/1/4/A/1_lyq8479.jpg");  
                    article2.setUrl("http://blog.csdn.net/lyq8479/article/details/8941577");  
  
                    Article article3 = new Article();  
                    article3.setTitle("第3篇\n开发模式启用及接口配置");  
                    article3.setDescription("");  
                    article3.setPicUrl("http://avatar.csdn.net/1/4/A/1_lyq8479.jpg");  
                    article3.setUrl("http://blog.csdn.net/lyq8479/article/details/8944988");  
  
                    articleList.add(article1);  
                    articleList.add(article2);  
                    articleList.add(article3);  
                    newsMessage.setArticleCount(articleList.size());  
                    newsMessage.setArticles(articleList);  
                    respMessage = MessageUtil.newsMessageToXml(newsMessage);  
                }  
                // 多图文消息---首条消息不含图片  
                else if ("4".equals(content)) {  
                    Article article1 = new Article();  
                    article1.setTitle("微信公众帐号开发教程Java版");  
                    article1.setDescription("");  
                    // 将图片置为空  
                    article1.setPicUrl("");  
                    article1.setUrl("http://blog.csdn.net/lyq8479");  
  
                    Article article2 = new Article();  
                    article2.setTitle("第4篇\n消息及消息处理工具的封装");  
                    article2.setDescription("");  
                    article2.setPicUrl("http://avatar.csdn.net/1/4/A/1_lyq8479.jpg");  
                    article2.setUrl("http://blog.csdn.net/lyq8479/article/details/8949088");  
  
                    Article article3 = new Article();  
                    article3.setTitle("第5篇\n各种消息的接收与响应");  
                    article3.setDescription("");  
                    article3.setPicUrl("http://avatar.csdn.net/1/4/A/1_lyq8479.jpg");  
                    article3.setUrl("http://blog.csdn.net/lyq8479/article/details/8952173");  
  
                    Article article4 = new Article();  
                    article4.setTitle("第6篇\n文本消息的内容长度限制揭秘");  
                    article4.setDescription("");  
                    article4.setPicUrl("http://avatar.csdn.net/1/4/A/1_lyq8479.jpg");  
                    article4.setUrl("http://blog.csdn.net/lyq8479/article/details/8967824");  
  
                    articleList.add(article1);  
                    articleList.add(article2);  
                    articleList.add(article3);  
                    articleList.add(article4);  
                    newsMessage.setArticleCount(articleList.size());  
                    newsMessage.setArticles(articleList);  
                    respMessage = MessageUtil.newsMessageToXml(newsMessage);  
                }  
                // 多图文消息---最后一条消息不含图片  
                else if ("5".equals(content)) {  
                    Article article1 = new Article();  
                    article1.setTitle("第7篇\n文本消息中换行符的使用");  
                    article1.setDescription("");  
                    article1.setPicUrl("http://0.xiaoqrobot.duapp.com/images/avatar_liufeng.jpg");  
                    article1.setUrl("http://blog.csdn.net/lyq8479/article/details/9141467");  
  
                    Article article2 = new Article();  
                    article2.setTitle("第8篇\n文本消息中使用网页超链接");  
                    article2.setDescription("");  
                    article2.setPicUrl("http://avatar.csdn.net/1/4/A/1_lyq8479.jpg");  
                    article2.setUrl("http://blog.csdn.net/lyq8479/article/details/9157455");  
  
                    Article article3 = new Article();  
                    article3.setTitle("如果觉得文章对你有所帮助，请通过博客留言或关注微信公众帐号xiaoqrobot来支持柳峰！");  
                    article3.setDescription("");  
                    // 将图片置为空  
                    article3.setPicUrl("");  
                    article3.setUrl("http://blog.csdn.net/lyq8479");  
  
                    articleList.add(article1);  
                    articleList.add(article2);  
                    articleList.add(article3);  
                    newsMessage.setArticleCount(articleList.size());  
                    newsMessage.setArticles(articleList);  
                    respMessage = MessageUtil.newsMessageToXml(newsMessage);  
                }else{
                	 respMessage = String.format(
         					"<xml>" + "<ToUserName><![CDATA[%s]]></ToUserName>"
         							+ "<FromUserName><![CDATA[%s]]></FromUserName>"
         							+ "<CreateTime>%s</CreateTime>"
         							+ "<MsgType><![CDATA[text]]></MsgType>"
         							+ "<Content><![CDATA[%s]]></Content>" 
         				+ "</xml>",
         					fromUserName, toUserName, getUtcTime(), "请回复如下关键词：\n"
         							+ "1.java面试题大全\n"
         							+ "2.微信公众号开发教程\n"
         							+ "3.百度\n"
         							+ "4.新闻\n"
         							+ "5.音乐\n"
         							+ "6.视频");
                }
            } // 文本消息
//            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
//            	respMessage = "您发送的是文本消息！";
//            }
            // 图片消息
//            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
//            	textMessage.setContent("您发送的是图片消息！");
//            	respMessage = MessageUtil.textMessageToXml(textMessage);
//            }
//            // 语音消息
//            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
//            	textMessage.setContent("您发送的是语音消息！");
//            	respMessage = MessageUtil.textMessageToXml(textMessage);
//            }
//            // 视频消息
//            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) {
//            	textMessage.setContent("您发送的是视频消息！");
//            	respMessage = MessageUtil.textMessageToXml(textMessage);
//            }
//            // 视频消息
//            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_SHORTVIDEO)) {
//            	textMessage.setContent("您发送的是小视频消息！");
//            	respMessage = MessageUtil.textMessageToXml(textMessage);
//            }
//            // 地理位置消息
//            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
//            	textMessage.setContent("您发送的是地理位置消息！");
//            	respMessage = MessageUtil.textMessageToXml(textMessage);
//            }
//            // 链接消息
//            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
//            	textMessage.setContent("您发送的是链接消息！");
//            	respMessage = MessageUtil.textMessageToXml(textMessage);
//            }
            // 事件推送
//            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
//                // 事件类型
//                String eventType = requestMap.get("Event");
//                // 关注
//                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
//                	textMessage.setContent("谢谢您的关注！暂未开放，请稍候。。。！");
//                	respMessage = MessageUtil.textMessageToXml(textMessage);
//                }
//                // 取消关注
//                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
//                    // TODO 取消订阅后用户不会再收到公众账号发送的消息，因此不需要回复
//                }
//                // 扫描带参数二维码
//                else if (eventType.equals(MessageUtil.EVENT_TYPE_SCAN)) {
//                    // TODO 处理扫描带参数二维码事件
//                }
//                // 上报地理位置
//                else if (eventType.equals(MessageUtil.EVENT_TYPE_LOCATION)) {
//                    // TODO 处理上报地理位置事件
//                }
//                // 自定义菜单
//                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
//                    // TODO 处理菜单点击事件
//                }
//            }
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        System.out.println(respMessage);
        return respMessage;  
    }  
  
    /** 
     * emoji表情转换(hex -> utf-16) 
     *  
     * @param hexEmoji 
     * @return 
     */  
    public static String emoji(int hexEmoji) {  
        return String.valueOf(Character.toChars(hexEmoji));  
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
