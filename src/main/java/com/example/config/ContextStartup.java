package com.example.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.entity.Category;
import com.example.service.CategoryService;
import com.example.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.List;

/**
 * @author WangLiang
 */
@Component
@RequiredArgsConstructor
public class ContextStartup implements ApplicationRunner, ServletContextAware {

    private final CategoryService categoryService;

    ServletContext servletContext;

    private final  PostService postService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<Category> categories = categoryService.list(new QueryWrapper<Category>()
                .eq("status", 0)
        );
        servletContext.setAttribute("categorys", categories);
        postService.initWeekRank();
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
