package com.demo.mall.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Table(name = "goods")
public class Goods {

    @Column(name = "id")
    private int id;

    @Column(name = "goods_type_id")
    private int goodsTypeId;

    @Column(name = "goods_name")
    private String goodsName;

    @Column(name = "goods_src")
    private String goodsSrc;

    @Column(name = "goods_desc")
    private String goodsDesc;

    @Column(name = "price")
    private double price;
}
