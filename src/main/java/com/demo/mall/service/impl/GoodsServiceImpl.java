package com.demo.mall.service.impl;

import com.demo.mall.entities.Goods;
import com.demo.mall.entities.GoodsDetail;
import com.demo.mall.mapper.GoodsDao;
import com.demo.mall.service.GoodsService;
import com.demo.mall.vo.GoodsDetailVo;
import com.demo.mall.vo.GoodsVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsDao goodsDao;

    @Override
    public List<GoodsVo> getGoodsList() {
        List<Goods> goods = goodsDao.findAll();
        List<GoodsVo> goodsVos = new ArrayList<>();
        goods.forEach(g->{
            GoodsVo goodsVo = new GoodsVo(g);
            goodsVos.add(goodsVo);
        });
        return goodsVos;
    }

    @Override
    public GoodsDetailVo getGoodsDetailById(int id) {
        Goods goods = goodsDao.findGoodsById(id);
        List<GoodsDetail> goodsDetails = goodsDao.findGoodsDetailByGoodsId(id);

        GoodsDetailVo goodsDetailVo = new GoodsDetailVo();
        goodsDetailVo.setGoodsDesc(goods.getGoodsDesc());
        goodsDetailVo.setGoodsId(goods.getId());
        goodsDetailVo.setGoodsName(goods.getGoodsName());
        goodsDetailVo.setGoodsPic(goods.getGoodsSrc());
        List<GoodsDetailVo.Specs> specs = new ArrayList<>();
        goodsDetails.forEach(g->{
            GoodsDetailVo.Specs specs1 = new GoodsDetailVo.Specs(g);
            specs.add(specs1);
        });
        goodsDetailVo.setSpecs(specs);

        return goodsDetailVo;
    }

    @Override
    public List<GoodsVo> getGoodsListById(int id) {
        List<Goods> goods = goodsDao.findAllById(id);
        List<GoodsVo> goodsVos = new ArrayList<>();
        goods.forEach(g->{
            GoodsVo goodsVo = new GoodsVo(g);
            goodsVos.add(goodsVo);
        });
        return goodsVos;
    }
}
