package com.yn.wechatmpsdk.pojo;


import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XStreamAlias("xml")
public class GeneralMessage {
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
    private String msgType;
    //<![CDATA[text]]>
    //text, image, voice, video/shortvideo,

    //普通消息
    @XStreamAlias("Content")
    private String content;
}
