package com.servi.study.extend.xfire;

import com.servi.study.log.ServiLogger;
import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.transport.http.CommonsHttpMessageSender;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.HttpURLConnection;

/**
 * webservice调用方法工具类
 *
 */
public class WSUtil {

    /**
     * webservice调用方法通用方法
     *
     * @param url
     * @param method
     * @param request
     * @return
     */
    public static String getWebserviceResponse(String url, String method, String request) {
        long start = System.currentTimeMillis();
        Client client = null;
        Object[] resultObjects = null;
        try {
//			WSClient.trustAllHttpsCertificates();//添加对https的支持
            client = new Client(new URL(url));
            resultObjects = client.invoke(method, new Object[]{request});
      //      ServiLogger.log("返回报文：" + (String) resultObjects[0]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            ServiLogger.log(e.getMessage());
            return "false";
        } catch (Exception e) {
            e.printStackTrace();
            ServiLogger.log(e.getMessage());
            return "false";
        }
        return (String) resultObjects[0];
    }

    /**
     * webservice调用方法通用方法
     *
     * @param url
     * @param method
     * @param request
     * @return
     */
    public static String getWebserviceResponse2(String url, String method, String request) {
        long start = System.currentTimeMillis();
        Client client = null;
        Object[] resultObjects = null;
        try {

            int timeout = 50000;
            try {

                HttpURLConnection conn = (HttpURLConnection) new URL(url)
                        .openConnection();
                conn.setReadTimeout(timeout);
                conn.setConnectTimeout(timeout);
                client = new Client(conn.getInputStream(), null);
                // 设置发送的超时限制,单位是毫秒，30秒;
                client.setProperty(CommonsHttpMessageSender.HTTP_TIMEOUT,
                        String.valueOf(timeout));
                client.setProperty(CommonsHttpMessageSender.DISABLE_KEEP_ALIVE,
                        "true");
                client.setProperty(
                        CommonsHttpMessageSender.DISABLE_EXPECT_CONTINUE, "true");

            } catch (Exception e) {
                e.printStackTrace();
            }

            resultObjects = client.invoke(method, new Object[]{request});
        } catch (MalformedURLException e) {
            e.printStackTrace();
            ServiLogger.log(e.getMessage());
            return "false";
        } catch (Exception e) {
            e.printStackTrace();
            ServiLogger.log(e.getMessage());
            return "false";
        }
        return (String) resultObjects[0];
    }
}
