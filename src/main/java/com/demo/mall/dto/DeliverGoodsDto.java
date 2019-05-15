package com.demo.mall.dto;

import com.demo.mall.dto.TokenDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DeliverGoodsDto extends TokenDto implements Serializable {

    private int goodsId;

}
