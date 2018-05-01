package resp;

/**
 * 响应音乐消息
 * 
 * @author Administrator
 *
 */
public class MusicMessage{
	/**
	 * 音乐
	 */
	private Music Music;
	
	/**
	 * 开发者微信号
	 */
	public String ToUserName;
	/**
	 * 发送方帐号（一个OpenID）
	 */
	public String FromUserName;
	/**
	 * 消息创建时间 （整型）
	 */
	public long CreateTime;

	/**
	 * 消息类型 text、image、location、link
	 */
	public String MsgType;

	/**
	 * 消息id，64位整型
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
