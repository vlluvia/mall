package com.demo.mall.entities;

import com.demo.mall.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Table(name = "user")
public class User {

    @Column(name = "id")
    private int id;

    @Column(name = "account")
    private String account;

    @Column(name = "password")
    private String password;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "recipient")
    private String recipient;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "delFlag")
    private int delFlag;

    @Column(name = "user_img")
    private String userImg;

    private boolean isAdmin;

    public User(UserDto user) {
        this.account = user.getAccount();
        this.password = user.getPwd();
        this.nickname = user.getAccount();
        this.delFlag =0;
    }
}
