package com.demo.mall.mapper;

import com.demo.mall.entities.GoodsRange;
import com.demo.mall.utils.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodsTypeDao extends BaseMapper<GoodsRange> {
    @Select("select * from goods_range ")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "goodsType",  column = "goods_type")
    })
    List<GoodsRange> getAllCity();
    @Insert("insert into goods_range(goods_type) " +
            "values(#{goodsCityName})")
    void insertCity(String goodsCityName);
}
