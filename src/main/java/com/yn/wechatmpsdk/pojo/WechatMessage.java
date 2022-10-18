package com.yn.wechatmpsdk.pojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@XStreamAlias("xml")
public class WechatMessage {
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
    //event


    @XStreamAlias("Event")
    private String Event;//事件


    //普通消息
    @XStreamAlias("Content")
    private String content;

    @XStreamAlias("MediaId")
    private String mediaId;
    //图片消息
    @XStreamAlias("PicUrl")
    private String picUrl;
    //语音消息
    @XStreamAlias("Format")
    private String format;
    @XStreamAlias("Recognition")
    private String Recognition;//语音识别消息
    //视频消息 小视频消息
    @XStreamAlias("ThumbMediaId")
    private String thumbMediaId;
    //位置消息
    @XStreamAlias("Location_X")
    private String Location_X;
    @XStreamAlias("Location_Y")
    private String Location_Y;
    @XStreamAlias("Scale")
    private String scale;
    @XStreamAlias("Label")
    private String label;
    //链接消息
    @XStreamAlias("Title")
    private String title;
    @XStreamAlias("Description")
    private String description;
    @XStreamAlias("Url")
    private String url;


    //模板消息回应
    @XStreamAlias("Url")
    private String Status;
    //菜单key
    @XStreamAlias("EventKey")
    private String EventKey;

}
