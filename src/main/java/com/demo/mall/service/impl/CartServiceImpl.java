package com.demo.mall.service.impl;

import com.demo.mall.dto.CartAddDto;
import com.demo.mall.entities.GoodsDetail;
import com.demo.mall.vo.CartsVo;
import com.demo.mall.entities.Cart;
import com.demo.mall.entities.Goods;
import com.demo.mall.mapper.CartDao;
import com.demo.mall.mapper.GoodsDao;
import com.demo.mall.service.CartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Resource
    private CartDao cartDao;

    @Resource
    private GoodsDao goodsDao;

    @Override
    public List<CartsVo> getCarts(int id) {
        List<Cart> carts = cartDao.selectCartsById(id);
        List<CartsVo> cartsDtos = new ArrayList<>();
        carts.forEach(c->{
            Goods goods = goodsDao.findGoodsById(c.getGoodsId());
            CartsVo cartsDto = new CartsVo(c,goods);
            cartsDtos.add(cartsDto);
        });
        return cartsDtos;
    }

    @Override
    public int deletCart(int cartId) {

        return cartDao.deleteById(cartId);
    }

    @Override
    public int addCart(CartAddDto cartAddDto, int userId) {

        GoodsDetail goodsDetail = goodsDao.findGoodsDetailByDetailsId(cartAddDto.getSpecId());
        if (goodsDetail!=null){
            int i = cartDao.insertCart(cartAddDto.getGoodsId(),
                    goodsDetail.getGoodsSizePrice(),
                    cartAddDto.getCount(),
                    cartAddDto.getCount()*goodsDetail.getGoodsSizePrice(),
                    userId);
            return i;
        }

        return 0;
    }

    @Override
    public int buy(CartAddDto cartAddDto, int userId) {

        GoodsDetail goodsDetail = goodsDao.findGoodsDetailByDetailsId(cartAddDto.getSpecId());
        if (goodsDetail!=null){
            int i = cartDao.insertCart(cartAddDto.getGoodsId(),
                    goodsDetail.getGoodsSizePrice(),
                    cartAddDto.getCount(),
                    cartAddDto.getCount()*goodsDetail.getGoodsSizePrice(),
                    userId);
            return i;
        }

        return 0;
    }
}
