package entry;

/**
 * AccessToken������ģ��-->΢��ͨ�ýӿ�ƾ֤ 
 * 
 * @author Administrator
 *
 */
public class AccessToken {
	// ��ȡ����ƾ֤
	private String accessToken;
	// ƾ֤��Чʱ�䣬��λ����
	private int expiresin;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public int getExpiresin() {
		return expiresin;
	}

	public void setExpiresin(int expiresin) {
		this.expiresin = expiresin;
	}

}
