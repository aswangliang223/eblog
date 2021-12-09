package com.example.im.message;

import com.example.im.vo.ImTo;
import com.example.im.vo.ImUser;
import lombok.Data;

/**
 * @author WangLiang
 */
@Data
public class ChatImMess {

    private ImUser mine;
    private ImTo to;

}
