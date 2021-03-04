package com.demo.mall.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsersVo  implements Serializable {

    private int id;

    private String account;

    private String nickname;

    private String recipient;

    private String phone;

    private String address;

    private String userImg;
}
