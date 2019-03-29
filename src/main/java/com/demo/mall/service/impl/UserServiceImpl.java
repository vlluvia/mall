package com.demo.mall.service.impl;


import com.demo.mall.dto.UserDto;
import com.demo.mall.entities.User;
import com.demo.mall.mapper.UserDao;
import com.demo.mall.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    public UserDao userDao;

    @Override
    public User findUserByAccount(String account) {
        User user = userDao.findUserByAccount(account);
        return user;
    }

    @Override
    public int insertUser(UserDto user) {
        User users = new User(user);
        return userDao.insertUser(users);
    }
}
