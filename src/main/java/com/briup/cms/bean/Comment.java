package com.briup.cms.bean;


import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Builder
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cms_comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private String time;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article articles;

    @OneToMany
    @JoinColumn(name = "parent_id")
    private List<Comment> children;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Comment parent;




}
