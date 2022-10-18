package com.yn.wechatmpsdk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result<T> {
    private String msg;
    private Boolean status;
    private T data;
    public  static <T> Result<T> success(String msg,T data){
        return new Result<T>(msg,true,data);
    }
    public  static <T> Result<T> error(String msg,T data){
        return new Result<T>(msg,false,data);
    }
}
