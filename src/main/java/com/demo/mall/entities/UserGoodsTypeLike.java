package com.demo.mall.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserGoodsTypeLike {

    public int id;

    public int userId;

    public int goodsTypeId;
}
