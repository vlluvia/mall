package com.demo.mall.service;

import com.demo.mall.dto.UserDto;
import com.demo.mall.dto.UserInfoDto;
import com.demo.mall.entities.User;
import com.demo.mall.vo.UserVo;
import com.demo.mall.vo.UsersVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {

    public User findUserByAccount(String account);

    int insertUser(UserDto user);

    int updateUser(UserInfoDto userInfoDto,int id);

    PageInfo<UsersVo> queryUsers(Integer pageNum,
                                 Integer pageSize);

    void delUser(int userId);

    String[] getUserGoodsTypeLike(int id);
}
