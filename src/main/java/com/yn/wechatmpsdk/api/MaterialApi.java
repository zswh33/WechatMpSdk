package com.yn.wechatmpsdk.api;

import cn.hutool.json.JSONUtil;
import com.yn.wechatmpsdk.pojo.WechatResponse;
import com.yn.wechatmpsdk.utils.CommonUtils;
import com.yn.wechatmpsdk.utils.WechatRequestUtils;

import java.io.File;
import java.util.HashMap;

public class MaterialApi {
    private String URL = "https https://api.weixin.qq.com/cgi-bin/media/upload";

    /**
     *
     * @param accessToken accessToken
     * @param type 类型。image,voice,video,thumb
     * @return
     */
    public WechatResponse uploadMaterial(String accessToken, String type, File file){
        if (type==null)type = "image";
        String url = URL + "?access_token="+accessToken+"&type="+type;
        String res = WechatRequestUtils.post(URL, new HashMap<String, Object>() {{
            put("media", file);
        }});
        return JSONUtil.toBean(res,WechatResponse.class);
    }

}
