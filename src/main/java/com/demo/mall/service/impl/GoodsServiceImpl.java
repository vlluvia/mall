package com.demo.mall.service.impl;

import com.demo.mall.dto.GoodsAddDto;
import com.demo.mall.entities.Goods;
import com.demo.mall.entities.GoodsDetail;
import com.demo.mall.entities.UserGoodsTypeLike;
import com.demo.mall.mapper.CommentDao;
import com.demo.mall.mapper.GoodsDao;
import com.demo.mall.mapper.UserGoodsTypeLikeDao;
import com.demo.mall.service.GoodsService;
import com.demo.mall.vo.AdminGoodsVo;
import com.demo.mall.vo.GoodsDetailVo;
import com.demo.mall.vo.GoodsVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsDao goodsDao;

    @Resource
    CommentDao commentDao;

    @Resource
    UserGoodsTypeLikeDao userGoodsTypeLikeDao;

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
    public List<GoodsVo> getHotGoodsList(int id) {

        List<UserGoodsTypeLike> likes = userGoodsTypeLikeDao.getUserGoodsTypeLike(id);
        Random ra =new Random();
        int i =0;
        if (likes.size()!=0){
            i = ra.nextInt(likes.size());
        }
        List<Goods> goods = goodsDao.findByGoodsTypeId(i==0?1:i);
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

    @Override
    public List<GoodsVo> getGoodsListByName(String goodsName) {
        List<Goods> goods = goodsDao.findAllByName("%"+goodsName+"%");
        List<GoodsVo> goodsVos = new ArrayList<>();
        if (goods.size()==0){
            return goodsVos;
        }
        goods.forEach(g->{
            GoodsVo goodsVo = new GoodsVo(g);
            goodsVos.add(goodsVo);
        });
        return goodsVos;
    }

    @Override
    public void getGoodsDel(int goodsId) {
        goodsDao.deleteById(goodsId);
        commentDao.deleteCommentByGoodsId(goodsId);
    }

    @Override
    public void addGoods(GoodsAddDto goodsAddDto) {

        Goods goods = new Goods();
        goods.setGoodsDesc(goodsAddDto.getGoodsDesc());
        goods.setGoodsName(goodsAddDto.getGoodsName());
        goods.setGoodsSrc(goodsAddDto.getGoodsSrc());
        goods.setGoodsTypeId(Integer.parseInt(goodsAddDto.getGoodsTypeId()));
        goods.setPrice(goodsAddDto.getGoodsDetail().get(0).getGoodsSizePrice());

        goodsDao.addGoods(goods);
        int goodsId = goodsDao.selectByGoodsName(goods.getGoodsName());

        goodsAddDto.getGoodsDetail().forEach(g -> {
            GoodsDetail goodsDetail = new GoodsDetail();
            goodsDetail.setGoodsId(goodsId);
            goodsDetail.setGoodsSizeName(g.getGoodsSizeName());
            goodsDetail.setGoodsSizePrice(g.getGoodsSizePrice());
            goodsDetail.setGoodsStock(g.getGoodsStack());
            goodsDao.addGoodsDetail(goodsDetail);
        });
    }

    @Override
    public AdminGoodsVo getGoodsDetailAdminById(int id) {
        Goods goods = goodsDao.findGoodsById(id);
        List<GoodsDetail> goodsDetails = goodsDao.findGoodsDetailByGoodsId(id);

        AdminGoodsVo goodsDetailVo = new AdminGoodsVo();
        goodsDetailVo.setGoodsDesc(goods.getGoodsDesc());
        goodsDetailVo.setGoodsId(goods.getId());
        goodsDetailVo.setGoodsName(goods.getGoodsName());
        goodsDetailVo.setGoodsSrc(goods.getGoodsSrc());
        List<AdminGoodsVo.GoodsDetail> goodsDetails1 = new ArrayList<>();
        goodsDetails.forEach(g->{
            AdminGoodsVo.GoodsDetail specs1 = new AdminGoodsVo.GoodsDetail();
            specs1.setGoodsSizeName(g.getGoodsSizeName());
            specs1.setGoodsSizePrice(g.getGoodsSizePrice());
            specs1.setGoodsStack(g.getGoodsStock());
            specs1.setGoodsDetailId(g.getId());
            goodsDetails1.add(specs1);
        });
        goodsDetailVo.setGoodsDetail(goodsDetails1);

        return goodsDetailVo;
    }


}
