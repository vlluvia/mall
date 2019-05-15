package com.demo.mall.service;


import com.demo.mall.vo.OrderVo;
import com.github.pagehelper.PageInfo;

public interface AdminOrdersService {
    PageInfo<OrderVo> queryOrders(String id, Integer pageNum, Integer pageSize);

    void deliverGoods(int goodsId);
}
