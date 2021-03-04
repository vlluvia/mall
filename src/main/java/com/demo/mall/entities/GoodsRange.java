package com.demo.mall.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class GoodsRange {

    public GoodsRange(String goodsType) {
        this.goodsType = goodsType;
    }

    private  int id;
    private String goodsType;
}
