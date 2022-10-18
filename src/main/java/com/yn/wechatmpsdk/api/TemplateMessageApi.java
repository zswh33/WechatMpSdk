package com.yn.wechatmpsdk.api;

import cn.hutool.json.JSONObject;
import com.yn.wechatmpsdk.pojo.TemplateMessage;
import com.yn.wechatmpsdk.pojo.WechatResponse;
import com.yn.wechatmpsdk.utils.CommonUtils;
import com.yn.wechatmpsdk.utils.WechatRequestUtils;

public class TemplateMessageApi {
    final static private String URL = "https://api.weixin.qq.com/cgi-bin/message/template/send";
    public static WechatResponse send(String accessToken, TemplateMessage message){
        String post = WechatRequestUtils.post(URL, accessToken, CommonUtils.ObjectToJson(message));
        return CommonUtils.JsonToObject(post, WechatResponse.class);
    }

}
