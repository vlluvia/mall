package com.demo.mall.mapper;

import com.demo.mall.entities.Test;
import com.demo.mall.entities.User;
import com.demo.mall.utils.BaseMapper;
import org.apache.ibatis.annotations.*;

public interface UserDao  extends BaseMapper<User> {


    @Select("select * from user where account=#{account}")
    User findUserByAccount(@Param("account") String account);

    @Insert("insert into user(account,password,nickname) values(#{account},#{password},#{nickname})")
    int insertUser(User users);

    @Select("select * from user where id = #{id}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "account",  column = "account"),
            @Result(property = "password",  column = "password"),
            @Result(property = "nickname",  column = "nickname"),
            @Result(property = "recipient",  column = "recipient"),
            @Result(property = "phone",  column = "phone"),
            @Result(property = "address",  column = "address"),
            @Result(property = "delFlag",  column = "delFlag"),
            @Result(property = "userImg",  column = "user_img"),
    })
    User findUserById(int id);
}
