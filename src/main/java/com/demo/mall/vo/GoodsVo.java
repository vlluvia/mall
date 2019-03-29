package com.demo.mall.vo;

import com.demo.mall.entities.Goods;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GoodsVo implements Serializable {

    private int id;

    private int typeId;

    private String name;

    private String img;

    private String goodsDesc;

    private double price;

    public GoodsVo(Goods g) {

        this.id = g.getId();
        this.goodsDesc = g.getGoodsDesc();
        this.name = g.getGoodsName();
        this.img = g.getGoodsSrc();
        this.typeId = g.getGoodsTypeId();
        this.price = g.getPrice();

    }
}
