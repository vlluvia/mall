package com.demo.mall.mapper;

import com.demo.mall.entities.Orders;
import com.demo.mall.utils.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrderDao extends BaseMapper<Orders> {


    @Select("select * from orders where user_id=#{userId}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "goodsName", column = "goods_name"),
            @Result(property = "goodsPrice", column = "goods_price"),
            @Result(property = "goodsCount", column = "goods_count"),
            @Result(property = "total", column = "total"),
            @Result(property = "isPay", column = "is_pay"),
            @Result(property = "isSend", column = "is_send"),
            @Result(property = "isFinish", column = "is_finish"),
            @Result(property = "userId", column = "user_id"),
    })
    List<Orders> findOrdersById(int userId);

    @Insert("insert into orders(goods_name,goods_price,goods_count,total,is_pay,is_send,is_finish,user_id) " +
            "values(#{goodsName},#{goodsPrice},#{goodsCount},#{total},#{isPay},#{isSend},#{isFinish},#{userId})")
    void insertOrder(Orders orders);

    void insertBuy(@Param("goodsName") String goodsName,
                   @Param("goodsPrice") Double goodsSizePrice,
                   int count, double v,
                   int i,
                   int i1,
                   int i2,
                   int userId);
}
