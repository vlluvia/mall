package com.demo.mall.vo;

import com.demo.mall.entities.Cart;
import com.demo.mall.entities.Goods;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CartsVo implements Serializable {

    private int id;

    private String goodsName;

    private double goodsPrice;

    private int goodsCount;

    private double total;

    public CartsVo(Cart c, Goods goods) {
        this.goodsCount=c.getCount();
        this.goodsName=goods.getGoodsName();
        this.goodsPrice=c.getUnitPrice();
        this.total = c.getTotalAmount();
        this.id=c.getId();
    }
}
