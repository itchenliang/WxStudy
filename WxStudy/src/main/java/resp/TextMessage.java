package resp;

/**
 * ��Ӧ�ı���Ϣ
 * 
 * @author Administrator
 *
 */
public class TextMessage extends BaseMessage{
	/**
	 * �ظ�����Ϣ����
	 */
	private String Content;
	
	/**
	 * ������΢�ź�
	 */
	private String ToUserName;
	/**
	 * ���ͷ��ʺţ�һ��OpenID��
	 */
	private String FromUserName;
	/**
	 * ��Ϣ����ʱ�� �����ͣ�
	 */
	private long CreateTime;

	/**
	 * ��Ϣ���� text��image��location��link
	 */
	private String MsgType;

	/**
	 * ��Ϣid��64λ����
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
