package com.demo.mall.web;

import com.demo.mall.dto.DeliverGoodsDto;
import com.demo.mall.entities.User;
import com.demo.mall.service.AdminOrdersService;
import com.demo.mall.service.TokenService;
import com.demo.mall.utils.ResultMessageBuilder;
import com.demo.mall.vo.OrderVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 管理员订单管理类
 */
@RestController
public class AdminOrdersController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AdminOrdersService adminOrdersService;

    /**
     * 获取订单
     * @param id
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/admin/orders")
    public ResultMessageBuilder.ResultMessage getOrders(String id,
                                                        Integer pageNum,
                                                        Integer pageSize) {
        PageInfo<OrderVo> res = adminOrdersService.queryOrders(id, pageNum, pageSize);
        return ResultMessageBuilder.success(res);
    }

    /**
     * 订单发货接口
     * @param deliverGoodsDto
     * @return
     */
    @PostMapping("/admin/deliver/goods")
    public ResultMessageBuilder.ResultMessage deliverGoods(@RequestBody DeliverGoodsDto deliverGoodsDto) {
        User user = tokenService.explainToken(deliverGoodsDto.getToken());
        if (user != null) {
            adminOrdersService.deliverGoods(deliverGoodsDto.getGoodsId());
            return ResultMessageBuilder.success("发货成功");
        } else {
            return ResultMessageBuilder.error("该用户不存在");
        }
    }
}
