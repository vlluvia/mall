package com.demo.mall.vo;

import com.demo.mall.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserInfoVo implements Serializable {

    private int id;

    private String account;

    private String password;

    private String name;

    private String recipient;

    private String phone;

    private String address;

    private String[] userGoodsTypeLike;

    public UserInfoVo(User user, String[] userLike) {
        this.id = user.getId();
        this.account = user.getAccount();
        this.address = user.getAddress();
        this.name = user.getNickname();
        this.phone = user.getPhone();
        this.recipient = user.getRecipient();
        this.password = user.getPassword();
        this.userGoodsTypeLike = userLike;
    }
}
