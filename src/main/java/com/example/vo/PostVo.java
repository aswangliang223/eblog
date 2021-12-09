package com.example.vo;

import com.example.entity.Post;
import lombok.Data;

/**
 * @author WangLiang
 */
@Data
public class PostVo extends Post {

    private Long authorId;
    private String authorName;
    private String authorAvatar;

    private String categoryName;

}
