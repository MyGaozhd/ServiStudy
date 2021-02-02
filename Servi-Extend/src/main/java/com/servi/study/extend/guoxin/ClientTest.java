package com.servi.study.extend.guoxin;

import com.baiwang.bop.client.IBopClient;
import com.baiwang.bop.client.ILoginClient;
import com.baiwang.bop.client.impl.BopRestClient;
import com.baiwang.bop.client.impl.PostLogin;
import com.baiwang.bop.request.impl.LoginRequest;
import com.baiwang.bop.request.impl.input.CollectRequest;
import com.baiwang.bop.request.impl.input.v2.CollectRequestV2;
import com.baiwang.bop.respose.entity.LoginResponse;
import com.baiwang.bop.respose.entity.input.v2.CollectResponseV2;
import com.servi.study.json.IJsonUtil;

/**
 * @author servi
 * @date 2021/2/2
 */
public class ClientTest {
    public static void main(String[] args) {
        String url = "https://sandbox-openapi.baiwang.com/router/rest";
        ILoginClient loginClient = new PostLogin(url);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setAppkey("1000429");
        loginRequest.setAppSecret("6c8e9c46-b3f9-4794-8870-8cb49cf51104");
        loginRequest.setUserName("admin_3000000063568");
        loginRequest.setPasswordMd5("Aa123456");
        loginRequest.setUserSalt("3542f6e10d8c4bcc908b8d80c336e495");
        LoginResponse loginResponse = loginClient.login(loginRequest);

        String token = loginResponse.getAccess_token();//记录

        System.out.println("token:" + token);

        CollectRequestV2 req = new CollectRequestV2();
        req.setInvoiceCode("011001800204");
        req.setInvoiceNumber("21148382");
        req.setBillingDate("20190124");
        req.setCheckCode("181943");
        req.setTotalAmount("467.96");
        req.setTaxNo("91110000600001760P");
        IBopClient client = new BopRestClient(url, "1000429", "6c8e9c46-b3f9-4794-8870-8cb49cf51104");
        CollectResponseV2 res = client.execute(req, token, CollectResponseV2.class);
        System.out.println(IJsonUtil.toJson(res));
    }
}
