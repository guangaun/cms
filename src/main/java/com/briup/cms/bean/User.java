package com.briup.cms.bean;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name ="cms_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
//    @ApiModelProperty(value = "用户",position = 1)
    @Column(name = "username",nullable = false,unique = true)
    private String username;
//    @ApiModelProperty(value = "密码",position = 2)
    @Column(name = "psssword",nullable = false)
    private String password;
    private String phone;
    @Column(name = "realname")
    private String realName;
    private String gender;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;
    @Column(name = "register_time")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date registerTime;
    @Column(name = "status", nullable = false)
    private String status;
    private String image;
    @ManyToOne
    private Role role;






}
