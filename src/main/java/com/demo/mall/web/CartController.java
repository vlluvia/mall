package com.demo.mall.web;

import com.demo.mall.dto.CartAddDto;
import com.demo.mall.dto.CartDeleteDto;
import com.demo.mall.dto.TokenDto;
import com.demo.mall.entities.User;
import com.demo.mall.service.CartService;
import com.demo.mall.service.TokenService;
import com.demo.mall.utils.ResultMessageBuilder;
import com.demo.mall.vo.CartsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 购物车接口控制类
 */
@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private TokenService tokenService;

    /**
     * 获取个人购物车详情
     * @param token
     * @return
     */
    @PostMapping("/mall/carts")
    public ResultMessageBuilder.ResultMessage selectCarts(@RequestBody TokenDto token){
        User user = tokenService.explainToken(token.getToken());
        if (user!=null) {
            List<CartsVo> dto = cartService.getCarts(user.getId());
            return ResultMessageBuilder.success(dto);
        }else {
            return ResultMessageBuilder.error("该用户不存在");
        }
    }

    /**
     * 购物车删除
     * @param cartDeleteDto
     * @return
     */
    @PostMapping("/mall/cart/delete")
    public ResultMessageBuilder.ResultMessage deletCart(@RequestBody CartDeleteDto cartDeleteDto){
        User user = tokenService.explainToken(cartDeleteDto.getToken());
        if (user!=null) {
            int i = cartService.deletCart(cartDeleteDto.getCartId());
            return ResultMessageBuilder.success("删除成功");
        }else {
            return ResultMessageBuilder.error("该用户不存在");
        }
    }

    /**
     * 添加购物车
     * @param cartAddDto
     * @return
     */
    @PostMapping("/mall/cart/add")
    public ResultMessageBuilder.ResultMessage addCart(@RequestBody CartAddDto cartAddDto){
        User user = tokenService.explainToken(cartAddDto.getToken());
        if (user!=null) {
            int i = cartService.addCart(cartAddDto,user.getId());
            return ResultMessageBuilder.success("添加成功");
        }else {
            return ResultMessageBuilder.error("该用户不存在");
        }
    }

}
