package com.example.im.vo;

import lombok.Data;

/**
 * @author WangLiang
 */
@Data
public class ImUser {

    public final static String ONLINE_STATUS = "online";
    public final static String HIDE_STATUS = "hide";

    private Long id;
    private String username;
    /**
     * 在线状态 online：在线、hide：隐身
     */
    private String status;
    /**
     * 我的签名
     */
    private String sign;
    /**
     * 我的头像
     */
    private String avatar;
    /**
     * 是否我发送的消息
     */
    private Boolean mine;
    /**
     * 消息内容
     */
    private String content;
}
