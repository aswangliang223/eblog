package com.example.config;

import com.example.template.HotsTemplate;
import com.example.template.PostsTemplate;
import com.example.template.TimeAgoMethod;
import com.jagregory.shiro.freemarker.ShiroTags;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author WangLiang
 */
@Configuration
@RequiredArgsConstructor
public class FreemarkerConfig {

    private final freemarker.template.Configuration configuration;

    private final PostsTemplate postsTemplate;

    private final  HotsTemplate hotsTemplate;

    @PostConstruct
    public void setUp() {
        configuration.setSharedVariable("timeAgo", new TimeAgoMethod());
        configuration.setSharedVariable("posts", postsTemplate);
        configuration.setSharedVariable("hots", hotsTemplate);
        configuration.setSharedVariable("shiro", new ShiroTags());
    }
}
