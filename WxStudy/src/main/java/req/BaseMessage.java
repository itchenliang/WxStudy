package req;

/**
 *  ��Ϣ���ࣨ�û� -> �����ʺţ� 
 * 
 * @author Administrator
 *
 */
public class BaseMessage {
	/**
	 * ������΢�ź�
	 */
	private String ToUserName;
	/**
	 * ���ͷ��˺�
	 */
	private String FromUserName;
	/**
	 * ��Ϣ����ʱ��
	 */
	private Long CreateTime;
	/**
	 * ��Ϣ����
	 */
	public String MsgType;

	/**
	 * ��Ϣid��64λ����
	 */
	private long MsgId;

	public long getMsgId() {
		return MsgId;
	}

	public void setMsgId(long msgId) {
		MsgId = msgId;
	}

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

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public Long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(Long createTime) {
		CreateTime = createTime;
	}
}
