package com.demo.mall.service;

import com.demo.mall.dto.UserDto;
import com.demo.mall.entities.User;

public interface UserService {

    public User findUserByAccount(String account);

    int insertUser(UserDto user);
}
