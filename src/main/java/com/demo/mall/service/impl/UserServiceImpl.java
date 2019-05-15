package com.demo.mall.service.impl;


import com.demo.mall.dto.UserDto;
import com.demo.mall.dto.UserInfoDto;
import com.demo.mall.entities.User;
import com.demo.mall.entities.UserGoodsTypeLike;
import com.demo.mall.mapper.CommentDao;
import com.demo.mall.mapper.UserDao;
import com.demo.mall.mapper.UserGoodsTypeLikeDao;
import com.demo.mall.service.UserService;
import com.demo.mall.vo.UsersVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    CommentDao commentDao;

    @Resource
    public UserDao userDao;

    @Resource
    UserGoodsTypeLikeDao userGoodsTypeLikeDao;

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

    @Override
    public int updateUser(UserInfoDto userInfoDto,int userId) {

        String[] s = userInfoDto.getUserGoodsTypeLike();
        userGoodsTypeLikeDao.deleteByUserId(userId);
        for (String s1:s){
            UserGoodsTypeLike userGoodsTypeLike = new UserGoodsTypeLike();
            userGoodsTypeLike.setGoodsTypeId(Integer.parseInt(s1));
            userGoodsTypeLike.setUserId(userId);
            userGoodsTypeLikeDao.insertLike(userGoodsTypeLike);
        }

        return userDao.updateUser(userInfoDto.getId(),
                userInfoDto.getAccount(),
                userInfoDto.getAddress(),
                userInfoDto.getName(),
                userInfoDto.getPassword(),
                userInfoDto.getPhone(),
                userInfoDto.getRecipient());

    }

    @Override
    public PageInfo<UsersVo> queryUsers(Integer pageNum,
                                        Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UsersVo> userVos = userDao.findUsers();
        return new PageInfo<>(userVos);
    }

    @Override
    public void delUser(int userId) {
        userDao.deleteUserById(userId);
        commentDao.deleteCommentByUserId(userId);
    }

    @Override
    public String[] getUserGoodsTypeLike(int id) {
        List<UserGoodsTypeLike> likes = userGoodsTypeLikeDao.getUserGoodsTypeLike(id);
        String[] a = new String[likes.size()];
        for (int i=0;i<likes.size();i++){
            a[i] = String.valueOf(likes.get(i).getGoodsTypeId());
        }
        return a;
    }
}
