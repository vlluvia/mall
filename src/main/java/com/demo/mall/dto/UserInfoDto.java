package com.demo.mall.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class UserInfoDto extends TokenDto {
    private int id;

    private String account;

    private String password;

    private String name;

    private String recipient;

    private String phone;

    private String address;

    private String[] userGoodsTypeLike;
}
