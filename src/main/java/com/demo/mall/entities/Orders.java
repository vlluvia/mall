package com.demo.mall.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Orders {

    @Column(name = "id")
    private int id;

    @Column(name = "goods_name")
    private String goodsName;

    @Column(name = "goods_price")
    private double goodsPrice;

    @Column(name = "goods_count")
    private int goodsCount;

    @Column(name = "total")
    private double total;

    @Column(name = "is_pay")
    private boolean isPay;

    @Column(name = "is_send")
    private boolean isSend;

    @Column(name = "is_finish")
    private boolean isFinish;

    @Column(name = "user_id")
    private int userId;
}
