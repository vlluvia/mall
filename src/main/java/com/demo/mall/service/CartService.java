package com.demo.mall.service;


import com.demo.mall.dto.CartAddDto;
import com.demo.mall.vo.CartsVo;

import java.util.List;

public interface CartService {


    List<CartsVo> getCarts(int id);

    int deletCart(int cartId);

    int addCart(CartAddDto cartAddDto, int id);

    int buy(CartAddDto cartAddDto, int id);
}
