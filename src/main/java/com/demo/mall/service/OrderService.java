package com.demo.mall.service;


import com.demo.mall.dto.CartAddDto;
import com.demo.mall.vo.CartsVo;
import com.demo.mall.vo.OrderVo;

import java.util.List;

public interface OrderService {
    List<OrderVo> getOrders(int id);

    int addOrders(List<CartsVo> carts, int userId);

    int buy(CartAddDto cartAddDto, int id);
}
