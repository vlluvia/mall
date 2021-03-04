package com.demo.mall.service;

import com.demo.mall.dto.CityAddDto;
import com.demo.mall.vo.CitysVo;

import java.util.List;


public interface CityService {

    List<CitysVo> getCitys();

    List<CitysVo> insertCity(CityAddDto cityAddDto);
}
