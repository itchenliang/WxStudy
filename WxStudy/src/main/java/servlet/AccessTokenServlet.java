package servlet;

import Common.AccessTokenInfo;
import entry.AccessToken;
import util.NetWorkHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * ���ڻ�ȡaccessToken��Servlet
 * Created by xdp on 2016/1/25.
 */
@WebServlet(
        name = "AccessTokenServlet",
        urlPatterns = {"/AccessTokenServlet"},
        loadOnStartup = 1,
        initParams = {
                @WebInitParam(name = "appId", value = "wxbe4d433e857e8bb1"),
                @WebInitParam(name = "appSecret", value = "ccbc82d560876711027b3d43a6f2ebda")
        })
public class AccessTokenServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("����WebServlet");
        super.init();

        final String appId = getInitParameter("appId");
        final String appSecret = getInitParameter("appSecret");

        //����һ���µ��߳�
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        //��ȡaccessToken
                        AccessTokenInfo.accessToken = getAccessToken(appId, appSecret);
                        //��ȡ�ɹ�
                        if (AccessTokenInfo.accessToken != null) {
                            //��ȡ��access_token ����7000��,��Լ2��Сʱ����
                            Thread.sleep(7000 * 1000);
                            //Thread.sleep(10 * 1000);//10���ӻ�ȡһ��
                        } else {
                            //��ȡʧ��
                            Thread.sleep(1000 * 3); //��ȡ��access_tokenΪ�� ����3��
                        }
                    } catch (Exception e) {
                        System.out.println("�����쳣��" + e.getMessage());
                        e.printStackTrace();
                        try {
                            Thread.sleep(1000 * 10); //�����쳣����1��
                        } catch (Exception e1) {

                        }
                    }
                }

            }
        }).start();
    }

    /**
     * ��ȡaccess_token
     *
     * @return AccessToken
     */
    private AccessToken getAccessToken(String appId, String appSecret) {
        NetWorkHelper netHelper = new NetWorkHelper();
        /**
         * �ӿڵ�ַΪhttps://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET������grant_type�̶�дΪclient_credential���ɡ�
         */
        String Url = String.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s", appId, appSecret);
        //������Ϊhttps��get���󣬷��ص����ݸ�ʽΪ{"access_token":"ACCESS_TOKEN","expires_in":7200}
        String result = netHelper.getHttpsResponse(Url, "");
        System.out.println("��ȡ����access_token="+result);
        //ʹ��FastJson��Json�ַ���������Json����
        JSONObject json = JSON.parseObject(result);
        AccessToken token = new AccessToken();
        token.setAccessToken(json.getString("access_token"));
        token.setExpiresin(json.getInteger("expires_in"));
        return token;
    }
}