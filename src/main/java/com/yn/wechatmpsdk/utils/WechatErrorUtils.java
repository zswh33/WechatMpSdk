package com.yn.wechatmpsdk.utils;

import cn.hutool.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class WechatErrorUtils {
    private final static Logger LOGGER = LoggerFactory.getLogger(WechatErrorUtils.class);
    public static Logger getLOGGER() {
        return LOGGER;
    }

    public static String isError(JSONObject jsonObject){
        if(!jsonObject.containsKey("errcode")){
            return null;
        }
        int errcode = (Integer) jsonObject.get("errcode");
        String errorMsg = getResponse(String.valueOf(errcode));
        if (errorMsg==null){
            return "未知错误,错误信息："+jsonObject;
        }else {
            return errorMsg;
        }

    }
    final private static HashMap<String,String> map = new HashMap<String, String>(){{
        put("-1","系统繁忙，此时请开发者稍候再试");
        put("0","请求成功");
        put("40001","AppSecret错误或者 AppSecret 不属于这个公众号，请开发者确认 AppSecret 的正确性");
        put("40002","请确保grant_type字段值为client_credential");
        put("40164","调用接口的 IP 地址不在白名单中，请在接口 IP 白名单中进行设置。");
        put("89503","此 IP 调用需要管理员确认,请联系管理员");
        put("89501","此 IP 正在等待管理员确认,请联系管理员");
        put("89506","24小时内该 IP 被管理员拒绝调用两次，24小时内不可再使用该 IP 调用");
        put("89507","1小时内该 IP 被管理员拒绝调用一次，1小时内不可再使用该 IP 调用");
    }};
    private static String getResponse(String code){
        return map.get(code);
    }

}
