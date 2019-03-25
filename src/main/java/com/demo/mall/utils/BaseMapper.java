package com.demo.mall.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
/**
 * @Author viento
 * @Date 2019/3/25 12:50
 * @Description
 * @Link 3576993219
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T>  {
}
