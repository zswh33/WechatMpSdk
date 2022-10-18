package com.yn.wechatmpsdk.utils;


import org.apache.commons.codec.digest.DigestUtils;

import java.util.Arrays;
import java.util.List;

/**
 * 开发者接入API的数据验证
 */
public class WechatMpDeveloperAccessVaild {
    //微信那边要填入token，这里自己定义
    private static final String token = "awsl";
    /**
     * https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Access_Overview.html
     * 将timestamp、nonce和token字典序排序，拼接后进行sha1加密，然后与signature进行比对，一致则返回true，否则返回false
     * @param signature 加密签名，用于验证
     * @param timestamp 时间戳，与加密签名核对的参数之一
     * @param nonce 随机数，与加密签名核对的参数之一
     * @return x
     */
    public static boolean WechatMpDeveloperAccessDataVaild(String signature,String timestamp,String nonce){
        //变成数组，然后排序，最后拼接
        List<String> strs = Arrays.asList(nonce, timestamp, token);
        strs.sort((a,b)->a.compareTo(b));
        //拼接
        StringBuilder ori = new StringBuilder("");
        strs.forEach(str->ori.append(str));
        //sha1
        String end = DigestUtils.sha1Hex(ori.toString());
        //比对并返回
        return end.equals(signature);
    }
}
