package com.example.im.message;

import com.example.im.vo.ImMess;
import lombok.Data;

/**
 * @author WangLiang
 */
@Data
public class ChatOutMess {

    private String emit;
    private ImMess data;

}
