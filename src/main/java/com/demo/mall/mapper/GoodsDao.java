package com.demo.mall.mapper;

import com.demo.mall.entities.Goods;
import com.demo.mall.entities.GoodsDetail;
import com.demo.mall.entities.Test;
import com.demo.mall.utils.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodsDao  extends BaseMapper<Goods> {

    @Select("select * from goods ")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "goodsTypeId",  column = "goods_type_id"),
            @Result(property = "goodsName",  column = "goods_name"),
            @Result(property = "goodsSrc",  column = "goods_src"),
            @Result(property = "goodsDesc",  column = "goods_desc"),
            @Result(property = "price",  column = "goods_price"),
    })
    List<Goods> findAll();

    @Select("select * from goods where id = #{id}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "goodsTypeId",  column = "goods_type_id"),
            @Result(property = "goodsName",  column = "goods_name"),
            @Result(property = "goodsSrc",  column = "goods_src"),
            @Result(property = "goodsDesc",  column = "goods_desc"),
            @Result(property = "price",  column = "goods_price"),
    })
    Goods findGoodsById(@Param("id") int id);

    @Select("select * from goods_detail where goods_id=#{id}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "goodsId",  column = "goods_id"),
            @Result(property = "goodsSizeName",  column = "goods_size_name"),
            @Result(property = "goodsSizePrice",  column = "goods_size_price"),
            @Result(property = "goodsStock",  column = "goods_stock"),
    })
    List<GoodsDetail> findGoodsDetailByGoodsId(int id);

    @Select("select * from goods where goods_type_id=#{id}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "goodsTypeId",  column = "goods_type_id"),
            @Result(property = "goodsName",  column = "goods_name"),
            @Result(property = "goodsSrc",  column = "goods_src"),
            @Result(property = "goodsDesc",  column = "goods_desc"),
            @Result(property = "price",  column = "goods_price"),
    })
    List<Goods> findAllById(int id);

    @Select("select * from goods_detail where id=#{specId}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "goodsId",  column = "goods_id"),
            @Result(property = "goodsSizeName",  column = "goods_size_name"),
            @Result(property = "goodsSizePrice",  column = "goods_size_price"),
            @Result(property = "goodsStock",  column = "goods_stock"),
    })
    GoodsDetail findGoodsDetailByDetailsId(int specId);
}
