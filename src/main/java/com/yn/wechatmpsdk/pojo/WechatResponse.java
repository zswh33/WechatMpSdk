package com.yn.wechatmpsdk.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * 微信回应信息使用这个对象
 * 0        成功
 * 40003 	touser字段 openid 为空或者不正确
 * 40037 	订阅模板 id 为空不正确
 * 43101 	用户拒绝接受消息，如果用户之前曾经订阅过，则表示用户取消了订阅关系
 * 47003 	模板参数不准确，可能为空或者不满足规则，errmsg会提示具体是哪个字段出错
 * 41030 	page路径不正确
 */
public class WechatResponse {
    private String errcode;
    private String errmsg;
    private String msgid;
    private String media_id;
    private String created_id;
}

