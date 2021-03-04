package com.demo.mall.vo;

import com.demo.mall.entities.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class OrderVo implements Serializable {

    private int id;

    private String goodsName;

    private double goodsPrice;

    private int goodsCount;

    private double total;

    private boolean isPay;

    private boolean isSend;

    private boolean isFinish;

    private int userId;

    public OrderVo(Orders o) {

        this.id=o.getId();
        this.goodsCount = o.getGoodsCount();
        this.goodsName=o.getGoodsName();
        this.goodsPrice=o.getGoodsPrice();
        this.isFinish=o.isFinish();
        this.isPay=o.isPay();
        this.isSend=o.isSend();
        this.total=o.getTotal();
    }
}
