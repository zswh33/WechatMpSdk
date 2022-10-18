package com.yn.wechatmpsdk.pojo;

import cn.hutool.json.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TemplateMessage {
    String touser;
    String template_id;
    String page;
    MiniProgram miniprogram;
    Object data;
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class  MiniProgram{
        String appid;
        String pagepath;
    }
}
