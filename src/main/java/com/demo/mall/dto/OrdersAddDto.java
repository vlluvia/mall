package com.demo.mall.dto;

import com.demo.mall.vo.CartsVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class OrdersAddDto extends TokenDto {

    private List<CartsVo> carts;
}
