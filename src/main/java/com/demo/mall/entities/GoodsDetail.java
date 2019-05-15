package com.demo.mall.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class GoodsDetail {

    private int id;

    private int goodsId;

    private String goodsSizeName;

    private Double goodsSizePrice;

    private int goodsStock;

}
