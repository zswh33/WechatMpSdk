package com.yn.wechatmpsdk.api;

import cn.hutool.json.JSONObject;
import com.yn.wechatmpsdk.pojo.TemplateMessage;
import com.yn.wechatmpsdk.pojo.WechatResponse;
import com.yn.wechatmpsdk.utils.WechatErrorUtils;
import com.yn.wechatmpsdk.utils.WechatRequestUtils;


@Deprecated
public class SubscriptionMessageApi {
    final static private String URL = "https://api.weixin.qq.com/cgi-bin/message/subscribe/bizsend";

    /**
     * 向用户发送订阅信息
     * @param accessToken token
     * @param message 信息对象
     * @return 微信的回应
     */
    public static WechatResponse send(String accessToken, TemplateMessage message){
        try {
            String res =new JSONObject(message).toJSONString(0);
            WechatErrorUtils.getLOGGER().info(res);
            String post = WechatRequestUtils.post(URL, accessToken, res);
            WechatResponse wechatResponse = new JSONObject(post).toBean(WechatResponse.class);
            return wechatResponse;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
