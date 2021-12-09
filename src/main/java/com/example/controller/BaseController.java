package com.example.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.service.*;
import com.example.shiro.AccountProfile;
import org.apache.shiro.SecurityUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.web.bind.ServletRequestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 74650
 */
public class BaseController {

    @Resource
    HttpServletRequest req;

    @Resource
    PostService postService;

    @Resource
    CommentService commentService;

    @Resource
    UserService userService;

    @Resource
    UserMessageService messageService;

    @Resource
    UserCollectionService collectionService;

    @Resource
    CategoryService categoryService;

    @Resource
    WsService wsService;

    @Resource
    SearchService searchService;

    @Resource
    AmqpTemplate amqpTemplate;

    @Resource
    ChatService chatService;
    public Page getPage() {
        int pn = ServletRequestUtils.getIntParameter(req, "pn", 1);
        int size = ServletRequestUtils.getIntParameter(req, "size", 10);
        return new Page(pn, size);
    }
    protected AccountProfile getProfile() {
       return (AccountProfile)SecurityUtils.getSubject().getPrincipal();
    }
    protected Long getProfileId() {
        return getProfile().getId();
    }
}
