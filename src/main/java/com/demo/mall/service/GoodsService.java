package com.demo.mall.service;

import com.demo.mall.dto.GoodsAddDto;
import com.demo.mall.vo.AdminGoodsVo;
import com.demo.mall.vo.GoodsDetailVo;
import com.demo.mall.vo.GoodsVo;

import java.util.List;

public interface GoodsService {

    List<GoodsVo> getGoodsList();

    GoodsDetailVo getGoodsDetailById(int id);

    List<GoodsVo> getGoodsListById(int id);

    List<GoodsVo> getGoodsListByName(String goodsName);


    void getGoodsDel(int goodsId);

    void addGoods(GoodsAddDto goodsAddDto);

    AdminGoodsVo getGoodsDetailAdminById(int id);

    List<GoodsVo> getHotGoodsList(int id);
}
