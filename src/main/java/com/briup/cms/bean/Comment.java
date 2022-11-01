package com.briup.cms.bean;


import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cms_comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String context;
    @Column(nullable = false)
    private String time;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article articles;

    @OneToMany(mappedBy = "comment")
    private List<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "parent_id",insertable = false,updatable = false)
    private Comment comment;

    @Column(name = "parent_id")
    @ApiModelProperty(value = "父主键")
//    @JsonIgnore
    private Integer parentId;



}
