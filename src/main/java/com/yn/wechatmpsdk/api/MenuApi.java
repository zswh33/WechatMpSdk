package com.yn.wechatmpsdk.api;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.yn.wechatmpsdk.pojo.WechatResponse;
import com.yn.wechatmpsdk.utils.WechatErrorUtils;
import com.yn.wechatmpsdk.utils.WechatRequestUtils;


public class MenuApi {
    private final static String URL = "https://api.weixin.qq.com/cgi-bin/menu/create";
    public static WechatResponse create(String accessToken, String button){
        String body = WechatRequestUtils.post(URL, accessToken, button);
        JSONObject res = new JSONObject(body);
        if ((Integer)res.get("errcode")!=0){
            WechatErrorUtils.getLOGGER().error("创建菜单失败："+res.toJSONString(0));
        }else{
            WechatErrorUtils.getLOGGER().info("创建菜单成功："+res.toJSONString(0));
        }
        return JSONUtil.toBean(res,WechatResponse.class);
    }
}
