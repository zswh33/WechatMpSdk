package com.yn.wechatmpsdk.utils;

import cn.hutool.json.JSONObject;
import com.thoughtworks.xstream.XStream;
import com.yn.wechatmpsdk.pojo.GeneralMessage;
import com.yn.wechatmpsdk.pojo.WechatMessage;


import java.io.InputStream;

public class CommonUtils {
    private static final XStream XSTREAM_GENERALMESSAGE = new XStream(){{
        processAnnotations(GeneralMessage.class);
        allowTypes(new Class[]{GeneralMessage.class});
    }};
    private static final XStream XSTREAM_WECHATMESSAGE = new XStream(){{
        processAnnotations(WechatMessage.class);
        allowTypes(new Class[]{WechatMessage.class});
    }};
    public static String inputStreamToString(InputStream is){
        String res = null;
        try {
            StringBuilder content = new StringBuilder("");
            byte[] b = new byte[1024];
            int lens = -1;
            while ((lens = is.read(b))>0){
                content.append(new String(b,0,lens));
            }
            res = content.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }
    public static String beanToXmlWechat(Object o) throws Exception {
        if (o instanceof GeneralMessage){
            return XSTREAM_GENERALMESSAGE.toXML(o);
        }
        if (o instanceof WechatMessage){
            return XSTREAM_WECHATMESSAGE.toXML(o);
        }
        throw new Exception("不允许的操作");
    }
    public static WechatMessage xmlToBeanWechat(String xml){
        return (WechatMessage) XSTREAM_WECHATMESSAGE.fromXML(xml);
    }


    public static <T> T JsonToObject(String json,Class<T> c){
        return new JSONObject(json).toBean(c);
    }

    public static String ObjectToJson(Object o){
        return new JSONObject(o).toJSONString(4);
    }
}
