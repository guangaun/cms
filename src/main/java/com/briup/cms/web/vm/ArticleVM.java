package com.briup.cms.web.vm;

import com.briup.cms.bean.Category;
import lombok.Data;

/**
 * @ClassName ArtivleVM
 * @Description 新增资讯时的参数
 * @Author Gc
 * @Date 2022/11/2 14:43
 */

@Data
public class ArticleVM {
    private String title;
    private String content;
    private Category category;
}
