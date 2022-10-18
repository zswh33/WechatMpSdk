package com.yn.wechatmpsdk.pojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@XStreamAlias("xml")
public class ImageMessage {
    @XStreamAlias("ToUserName")
    private String toUserName;
    @XStreamAlias("FromUserName")
    private String fromUserName;
    @XStreamAlias("CreateTime")
    private String createTime;
    @XStreamAlias("MsgId")
    private String msgId;
    @XStreamAlias("MsgDataId")
    private String msgDataId;
    @XStreamAlias("Idx")
    private String idx;
    @XStreamAlias("MsgType")
    private String msgType;//image

    //image
    @XStreamAlias("MediaId")
    private String MediaId;

    @XStreamAlias("PicUrl")
    private String PicUrl;

}
