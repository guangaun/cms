package com.briup.cms.bean;


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
    @Column(name = "username",nullable = false,unique = true)
    private String username;
    @Column(name = "psssword",nullable = false)
    private String password;
    private String phone;
    @Column(name = "realname")
    private String realName;
    private String gender;
    private Date birthday;
    @Column(name = "register_time")
    private Date registerTime;
    @Column(name = "status", nullable = false)
    private String status;
    private String image;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private Role role;






}
