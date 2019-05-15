package com.demo.mall.mapper;

import com.demo.mall.entities.UserGoodsTypeLike;
import com.demo.mall.utils.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface UserGoodsTypeLikeDao extends BaseMapper<UserGoodsTypeLikeDao> {

    @Select("select * from user_goods_type_like where user_id=#{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "goodsTypeId", column = "goods_type_id"),
    })
    List<UserGoodsTypeLike> getUserGoodsTypeLike(int id);


    @Insert("insert into user_goods_type_like(user_id,goods_type_id) values(#{userId},#{goodsTypeId})")
    void insertLike(UserGoodsTypeLike userGoodsTypeLike);

    @Delete("delete from user_goods_type_like where user_id=#{userId}")
    void deleteByUserId(int userId);

}
