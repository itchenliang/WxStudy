package resp;

/**
 * ��Ӧ������Ϣ
 * 
 * @author Administrator
 *
 */
public class MusicMessage{
	/**
	 * ����
	 */
	private Music Music;
	
	/**
	 * ������΢�ź�
	 */
	public String ToUserName;
	/**
	 * ���ͷ��ʺţ�һ��OpenID��
	 */
	public String FromUserName;
	/**
	 * ��Ϣ����ʱ�� �����ͣ�
	 */
	public long CreateTime;

	/**
	 * ��Ϣ���� text��image��location��link
	 */
	public String MsgType;

	/**
	 * ��Ϣid��64λ����
	 */
	public long FuncFlag;

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

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}
}
