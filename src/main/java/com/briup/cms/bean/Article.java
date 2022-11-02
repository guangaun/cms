package com.briup.cms.bean;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Builder
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cms_atricle")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String title;
//    @Column(length = 1024)
    private String content;
    @Column(name = "public_time")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date publishTime;
    private Integer status;
    @Column(name = "read_times")
    private Integer readTimes;
    @Column(name = "thumb_up")
    private Integer thumbUp;
    @Column(name="thumb_down")
    private Integer thumbDown;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Comment comment;


    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", category=" + category.getId() +
                ", comment=" + comment +
                '}';
    }
}
