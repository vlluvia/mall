package com.demo.mall.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 实体类：
 * 与数据库表对应，形成映射关系，方便数据获取
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Cart {

    private int id;

    private int goodsId;

    private double unitPrice;

    private int count;

    private double totalAmount;

    private int userId;

}
