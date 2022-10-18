package com.yn.wechatmpsdk.utils;

import java.util.HashMap;
import java.util.Map;

public class MapUtils {
    public static class InnerMap {
        Map<String,Object> map;
        public InnerMap(){map=new HashMap<>();}
        public InnerMap put(String key, Object value){map.put(key,value);return this;}
        public Map<String ,Object> build(){return map;}
    }
    public static InnerMap map(){
        return new InnerMap();
    }
}
