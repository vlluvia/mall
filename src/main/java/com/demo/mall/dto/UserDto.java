package com.demo.mall.dto;

import com.demo.mall.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class UserDto implements Serializable {

    private String account;

    private String pwd;

}
