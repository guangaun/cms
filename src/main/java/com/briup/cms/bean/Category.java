package com.briup.cms.bean;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 *目录
 *

* @author: your name

* @since JDK 1.8

*/
@Getter
@Setter
@ToString
@Entity
@Table(name = "cms_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    private String description;
    private Integer no;
    @OneToMany(cascade=CascadeType.ALL,mappedBy = "category")
//    @JsonIgnore
    private List<Category> children;

    @Column(name = "parent_id")
    @ApiModelProperty(value = "父主键")
//    @JsonIgnore
    private Integer parentId;

    @ManyToOne
    @JoinColumn(name = "parent_id",insertable = false,updatable = false)
    @JsonIgnore
    private Category category;

    @OneToMany
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private List<Article> articles;








}
