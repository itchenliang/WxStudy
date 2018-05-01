package req;

/**
 * 文本消息实体类textMessage
 * 
 * @author Administrator
 *
 */
public class TextMessage extends BaseMessage {
	/**
	 * 文本消息内容
	 */
	public String Context;

	public String getContext() {
		return Context;
	}

	public void setContext(String context) {
		Context = context;
	}
}
