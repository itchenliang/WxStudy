package event;

/**
 * �Զ���˵��¼�
 * 
 * @author Administrator
 *
 */
public class MenuEvent extends BaseEvent {
	// �¼�KEYֵ�����Զ���˵��ӿ���KEYֵ��Ӧ
	private String EventKey;

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
}
