package com.briup.cms.web.vm;

import lombok.Data;

/**
 * @ClassName CommentVM
 * @Description 接收前端发送的json字符串，分装成之地当的一个对象
 * @Author Gc
 * @Date 2022/11/2 19:06
 */

@Data
public class CommentVM {
    private String content;
    private String time;
    private Integer articleId;
    private Integer parentId;

}
