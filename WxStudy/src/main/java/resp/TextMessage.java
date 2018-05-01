package resp;

/**
 * 响应文本消息
 * 
 * @author Administrator
 *
 */
public class TextMessage extends BaseMessage{
	/**
	 * 回复的消息内容
	 */
	private String Content;
	
	/**
	 * 开发者微信号
	 */
	private String ToUserName;
	/**
	 * 发送方帐号（一个OpenID）
	 */
	private String FromUserName;
	/**
	 * 消息创建时间 （整型）
	 */
	private long CreateTime;

	/**
	 * 消息类型 text、image、location、link
	 */
	private String MsgType;

	/**
	 * 消息id，64位整型
	 */
	private long FuncFlag;

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public long getFuncFlag() {
		return FuncFlag;
	}

	public void setFuncFlag(long funcFlag) {
		FuncFlag = funcFlag;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}
