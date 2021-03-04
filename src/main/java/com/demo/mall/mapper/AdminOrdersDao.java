package com.demo.mall.mapper;


import com.demo.mall.entities.Orders;
import com.demo.mall.utils.BaseMapper;
import com.demo.mall.vo.OrderVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AdminOrdersDao extends BaseMapper<Orders> {

    @Select("select * from orders")
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
    List<OrderVo> queryOrdersAll();

    @Select("select * from orders where is_pay=#{payFlag} and is_send=#{sendFlag}")
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
    List<OrderVo> queryOrdersByIsPay(@Param("payFlag") boolean payFlag, @Param("sendFlag")  boolean sendFlag);

    @Select("select * from orders where is_pay=#{payFlag} and is_send=#{sendFlag} and is_finish=#{finishFlag}")
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
    List<OrderVo> queryOrdersByIsSend(@Param("payFlag") boolean payFlag,
                                      @Param("sendFlag")  boolean sendFlag,
                                      @Param("finishFlag")  boolean finishFlag);

    @Select("select * from orders where is_finish=#{flag}")
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
    List<OrderVo> queryOrdersByIsFinish(boolean b);

    @Update("update orders set is_send = 1 where id=#{goodsId}")
    void deliverGoods(int goodsId);
}
