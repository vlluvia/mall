package com.demo.mall.service.impl;


import com.demo.mall.dto.CartAddDto;
import com.demo.mall.entities.Goods;
import com.demo.mall.entities.GoodsDetail;
import com.demo.mall.entities.Orders;
import com.demo.mall.mapper.CartDao;
import com.demo.mall.mapper.GoodsDao;
import com.demo.mall.mapper.OrderDao;
import com.demo.mall.service.OrderService;
import com.demo.mall.vo.CartsVo;
import com.demo.mall.vo.OrderVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private CartDao cartDao;

    @Resource
    private OrderDao orderDao;

    @Resource
    private GoodsDao goodsDao;

    @Override
    public List<OrderVo> getOrders(int userId) {
        List<Orders> list = orderDao.findOrdersById(userId);
        List<OrderVo> orderVos = new ArrayList<>();
        list.forEach(o -> {
            OrderVo order = new OrderVo(o);
            orderVos.add(order);
        });
        return orderVos;
    }

    @Override
    public int addOrders(List<CartsVo> carts, int userId) {
        carts.forEach(c -> {
            Orders orders = new Orders();
            orders.setGoodsCount(c.getGoodsCount());
            orders.setGoodsName(c.getGoodsName());
            orders.setGoodsPrice(c.getGoodsPrice());
            orders.setTotal(c.getTotal());
            orders.setUserId(userId);
            orders.setPay(false);
            orders.setFinish(false);
            orders.setSend(false);
            orderDao.insertOrder(orders);
            cartDao.deleteById(c.getId());
        });

        return 1;
    }

    @Override
    public int buy(CartAddDto cartAddDto, int userId) {
        Goods goods = goodsDao.findAllByGoodsId(cartAddDto.getGoodsId());
        GoodsDetail goodsDetail = goodsDao.findGoodsDetailByDetailsId(cartAddDto.getSpecId());
        Orders orders = new Orders();
        orders.setSend(false);
        orders.setFinish(false);
        orders.setPay(true);
        orders.setUserId(userId);
        orders.setTotal(cartAddDto.getCount()*goodsDetail.getGoodsSizePrice());
        orders.setGoodsPrice(goodsDetail.getGoodsSizePrice());
        orders.setGoodsName(goods.getGoodsName());
        orders.setGoodsCount(cartAddDto.getCount());
        orderDao.insertOrder(orders);
        goodsDao.cutSpecCount(goodsDetail.getGoodsStock()-cartAddDto.getCount(),cartAddDto.getSpecId());
        return 0;
    }
}
