package com.demo.mall.mapper;

import com.demo.mall.entities.User;
import com.demo.mall.utils.BaseMapper;
import com.demo.mall.vo.UsersVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao extends BaseMapper<User> {


    @Select("select * from user where account=#{account}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "account", column = "account"),
            @Result(property = "password", column = "password"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "recipient", column = "recipients"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "address", column = "address"),
            @Result(property = "delFlag", column = "delFlag"),
            @Result(property = "userImg", column = "user_img"),
            @Result(property = "isAdmin", column = "is_admin")
    })
    User findUserByAccount(@Param("account") String account);

    @Insert("insert into user(account,password,nickname) values(#{account},#{password},#{nickname})")
    int insertUser(User users);

    @Select("select * from user where id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "account", column = "account"),
            @Result(property = "password", column = "password"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "recipient", column = "recipient"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "address", column = "address"),
            @Result(property = "delFlag", column = "delFlag"),
            @Result(property = "userImg", column = "user_img"),
    })
    User findUserById(int id);

    @Update("update user set address=#{address},nickname=#{name},password=#{password},phone=#{phone},recipients=#{recipient}" +
            " where id=#{id} and account=#{account}")
    int updateUser(@Param("id") int id, @Param("account") String account,
                   @Param("address") String address, @Param("name") String name,
                   @Param("password") String password, @Param("phone") String phone,
                   @Param("recipient") String recipient);

    @Select("select * from user where is_admin=false")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "account", column = "account"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "recipient", column = "recipient"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "address", column = "address"),
            @Result(property = "userImg", column = "user_img"),
    })
    List<UsersVo> findUsers();

    @Delete("delete from user where id=#{userId}")
    void deleteUserById(int userId);
}
