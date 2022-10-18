package com.yn.wechatmpsdk.api;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.yn.wechatmpsdk.utils.WechatAccessToken;
import lombok.Data;

public class QuotaApi {
    final private static String URL = "https://api.weixin.qq.com/cgi-bin/openapi/quota/get?access_token=";



    //一天500次，不要多次请求
    public static QuotaResponse getQuota(String accessToken,String cgiPath){
        String data = new JSONObject(){{set("cgi_path",cgiPath);}}.toJSONString(0);
        String body = HttpUtil.post(URL+ accessToken,data);
        try {
            return JSONUtil.toBean(body,QuotaResponse.class);
        }catch (Exception e){
            e.printStackTrace();
            return new QuotaResponse(){{setErrmsg("意外错误");setErrcode(body);}};
        }
    }
    @Data
    public static class QuotaResponse{
        private String errcode;
        private String errmsg;
        private Quota quota;
        @Data
        public static class Quota{
            private String dayil_limit;
            private String used;
            private String remain;
        }
    }
}
