package com.demo.mall.service;

import com.demo.mall.vo.GoodsDetailVo;
import com.demo.mall.vo.GoodsVo;

import java.util.List;

public interface GoodsService {

    List<GoodsVo> getGoodsList();

    GoodsDetailVo getGoodsDetailById(int id);

    List<GoodsVo> getGoodsListById(int id);
}
