package resp;

import java.util.List;

/**
 * ��Ӧͼ����Ϣ ��ͼ����Ϣ�� ��ͼ�ĵ�ʱ�� Articles ֻ��һ��������
 * 
 * @author Administrator
 *
 */
public class NewsMessage{
	/**
	 * ͼ����Ϣ����������Ϊ10������
	 */
	private int ArticleCount;
	/**
	 * ����ͼ����Ϣ��Ϣ��Ĭ�ϵ�һ��itemΪ��ͼ
	 */
	private List<Article> Articles;
	
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

	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}

	public List<Article> getArticles() {
		return Articles;
	}

	public void setArticles(List<Article> articles) {
		Articles = articles;
	}
}
