package com.yn.wechatmpsdk.utils;

import cn.hutool.http.HttpUtil;

import java.util.HashMap;
import java.util.Map;

public class WechatRequestUtils {

    public static class token{
        private final static String URL = "https://api.weixin.qq.com/cgi-bin/token";
        private Map<String,Object> map;
        private token(String grant_type){
            map = new HashMap<>();
            map.put("grant_type",grant_type);
        }
        public static token get(String grantType){
            return new token(grantType);
        }
        public token form(String key,String value){map.put(key,value);return this;}
        public String exec(){
            return HttpUtil.get(URL,map);
        }
    }

    public static String get(String url, String accessToken, MapUtils.InnerMap map){
        return HttpUtil.get(url,map.put("access_token",accessToken).build());
    }

    public static String post(String url,String accessToken,String jsonString){
        return HttpUtil.post(url+"?access_token="+accessToken,jsonString);
    }
    public static String post(String urlWithParam,HashMap<String,Object> map){
        return HttpUtil.post(urlWithParam,map);
    }
}
