package com.demo.mall.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CartAddDto extends TokenDto{


    private int goodsId;

    private int specId;

    private int count;

}
