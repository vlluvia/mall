package com.demo.mall.mapper;


import com.demo.mall.entities.Cart;
import com.demo.mall.entities.Comment;
import com.demo.mall.utils.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CartDao  extends BaseMapper<Comment> {

    @Select("select * from cart where user_id=#{id}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "goodsId",  column = "goods_id"),
            @Result(property = "unitPrice",  column = "unit_price"),
            @Result(property = "count",  column = "count"),
            @Result(property = "totalAmount",  column = "total_amount"),
            @Result(property = "userId",  column = "user_id"),
    })
    List<Cart> selectCartsById(int id);

    @Delete("delete from cart where id=#{cartId}")
    int deleteById(int cartId);

    @Insert("insert into cart(goods_id,unit_price,count,total_amount,user_id) " +
            "values(#{goodsId},#{goodsSizePrice},#{count},#{v},#{userId})")
    int insertCart(@Param("goodsId") int goodsId,@Param("goodsSizePrice") Double goodsSizePrice,
                   @Param("count") int count,@Param("v") double v,@Param("userId") int userId);
}
