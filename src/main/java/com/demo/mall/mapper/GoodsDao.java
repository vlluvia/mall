package com.demo.mall.mapper;

import com.demo.mall.entities.Goods;
import com.demo.mall.entities.GoodsDetail;
import com.demo.mall.entities.Test;
import com.demo.mall.utils.BaseMapper;
import org.apache.ibatis.annotations.*;

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

    @Select("select * from goods where goods_name like #{goodsName}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "goodsTypeId",  column = "goods_type_id"),
            @Result(property = "goodsName",  column = "goods_name"),
            @Result(property = "goodsSrc",  column = "goods_src"),
            @Result(property = "goodsDesc",  column = "goods_desc"),
            @Result(property = "price",  column = "goods_price"),
    })
    List<Goods> findAllByName(@Param("goodsName") String goodsName);

    @Delete("delete from goods where id = #{goodsId}")
    void deleteById(int goodsId);

    @Insert("insert into goods(goods_type_id,goods_name,goods_src,goods_desc,goods_price)" +
            " values(#{goodsTypeId},#{goodsName},#{goodsSrc},#{goodsDesc},#{price})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int addGoods(Goods goods);

    @Insert("insert into goods_detail(goods_id,goods_size_name,goods_size_price,goods_stock)" +
            " values(#{goodsId},#{goodsSizeName},#{goodsSizePrice},#{goodsStock})")
    void addGoodsDetail(GoodsDetail goodsDetail);

    @Select("select id from goods where goods_name=#{goodsName}")
    @Results({
            @Result(property = "id",  column = "id"),
    })
    int selectByGoodsName(String goodsName);

    @Select("select * from goods where id=#{goodsId}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "goodsTypeId",  column = "goods_type_id"),
            @Result(property = "goodsName",  column = "goods_name"),
            @Result(property = "goodsSrc",  column = "goods_src"),
            @Result(property = "goodsDesc",  column = "goods_desc"),
            @Result(property = "price",  column = "goods_price"),
    })
    Goods findAllByGoodsId(int goodsId);

    @Update("update goods_detail set goods_stock =#{count} where id=#{id}")
    void cutSpecCount(@Param("count")int count,@Param("id") int id);

    @Select("select * from goods where goods_type_id=#{i}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "goodsTypeId",  column = "goods_type_id"),
            @Result(property = "goodsName",  column = "goods_name"),
            @Result(property = "goodsSrc",  column = "goods_src"),
            @Result(property = "goodsDesc",  column = "goods_desc"),
            @Result(property = "price",  column = "goods_price"),
    })
    List<Goods> findByGoodsTypeId(int i);
}
