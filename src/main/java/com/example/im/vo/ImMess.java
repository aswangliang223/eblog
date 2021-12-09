package com.example.im.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author WangLiang
 */
@Data
public class ImMess {

    private String username;
    private String avatar;
    /**
     * 聊天窗口来源类型，从发送消息传递的to里面获取
     */
    private String type;
    private String content;
    private Long cid;
    private Boolean mine;
    private Long fromid;
    private Date timestamp;
    /**
     * 消息的来源ID（如果是私聊，则是用户id，如果是群聊，则是群组id
     */
    private Long id;
}
