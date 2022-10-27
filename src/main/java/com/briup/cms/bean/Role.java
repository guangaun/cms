package com.briup.cms.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@ToString
@Entity
@Table(name = "cms_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "description")
    private String description;
    @OneToMany
    @JoinColumn(name = "role_id")
    @JsonIgnore// 转换为json字符串时，忽略掉不需要的属性
    private List<User> users;
}
