package com.demo.mall.service.impl;

import com.demo.mall.dto.CityAddDto;
import com.demo.mall.entities.GoodsRange;
import com.demo.mall.mapper.GoodsTypeDao;
import com.demo.mall.service.CityService;
import com.demo.mall.vo.CitysVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Resource
    private GoodsTypeDao goodsTypeDao;

    @Override
    public List<CitysVo> getCitys() {
        List<GoodsRange> goodsRanges = goodsTypeDao.getAllCity();
        List<CitysVo> citysVoList = new ArrayList<>();
        goodsRanges.forEach(v -> {
            citysVoList.add(new CitysVo(v));
        });
        return citysVoList;
    }

    @Override
    public List<CitysVo> insertCity(CityAddDto cityAddDto) {
        goodsTypeDao.insertCity(cityAddDto.getCity_name());
        List<GoodsRange> goodsRanges = goodsTypeDao.getAllCity();
        List<CitysVo> citysVoList = new ArrayList<>();
        goodsRanges.forEach(v -> {
            citysVoList.add(new CitysVo(v));
        });
        return citysVoList;
    }
}
