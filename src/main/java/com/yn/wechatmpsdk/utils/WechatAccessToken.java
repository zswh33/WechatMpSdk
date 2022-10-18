package com.yn.wechatmpsdk.utils;

import cn.hutool.json.JSONObject;
import com.yn.wechatmpsdk.pojo.AccessToken;
import com.yn.wechatmpsdk.pojo.Result;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class WechatAccessToken {
    private final static String grantType = "client_credential";
    /**
     * 向微信服务器请求token，成功返回失效时间，失败返回-1
     * @return 返回整数，-1表示失败
     */
    public static Result<AccessToken> getToken(String appId, String secret){
        String body = WechatRequestUtils.token.get(grantType)
                .form("appid",appId)
                .form("secret",secret)
                .exec();
        JSONObject res = new JSONObject(body);
        String errorMsg = WechatErrorUtils.isError(res);
        if (errorMsg!=null){
            return Result.error(errorMsg,null);
        }else {
            if (!res.containsKey("access_token") || !res.containsKey("expires_in")){
                return Result.error("意料之外的错误："+body,null);
            }
            AccessToken accessToken = new AccessToken(
                    (String)res.get("access_token"),
                    String.valueOf(res.get("expires_in"))
            );
            return Result.success("成功",accessToken);

        }
    }
}
