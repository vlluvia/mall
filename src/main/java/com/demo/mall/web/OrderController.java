package com.demo.mall.web;

import com.demo.mall.dto.CartAddDto;
import com.demo.mall.dto.OrdersAddDto;
import com.demo.mall.dto.TokenDto;
import com.demo.mall.entities.User;
import com.demo.mall.service.OrderService;
import com.demo.mall.service.TokenService;
import com.demo.mall.utils.ResultMessageBuilder;
import com.demo.mall.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户订单接口类
 */
@RestController
public class OrderController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private OrderService orderService;

    /**
     * 获取用户订单详情
     * @param token
     * @return
     */
    @PostMapping("/mall/orders")
    public ResultMessageBuilder.ResultMessage selectCarts(@RequestBody TokenDto token) {
        User user = tokenService.explainToken(token.getToken());
        if (user != null) {
            List<OrderVo> orders = orderService.getOrders(user.getId());
            return ResultMessageBuilder.success(orders);
        } else {
            return ResultMessageBuilder.error("该用户不存在");
        }
    }

    /**
     * 用户下单
     * @param ordersAddDto
     * @return
     */
    @PostMapping("/mall/order/add")
    public ResultMessageBuilder.ResultMessage addOrder(@RequestBody OrdersAddDto ordersAddDto) {
        User user = tokenService.explainToken(ordersAddDto.getToken());
        if (user != null) {
            int orders = orderService.addOrders(ordersAddDto.getCarts(),user.getId());
            return ResultMessageBuilder.success("添加成功");
        } else {
            return ResultMessageBuilder.error("该用户不存在");
        }
    }


    /**
     * 用户购买商品
     * @param cartAddDto
     * @return
     */
    @PostMapping("/mall/order/buy")
    public ResultMessageBuilder.ResultMessage buy(@RequestBody CartAddDto cartAddDto){
        User user = tokenService.explainToken(cartAddDto.getToken());
        if (user!=null) {
            int i = orderService.buy(cartAddDto,user.getId());
            return ResultMessageBuilder.success("添加成功");
        }else {
            return ResultMessageBuilder.error("该用户不存在");
        }
    }
}
