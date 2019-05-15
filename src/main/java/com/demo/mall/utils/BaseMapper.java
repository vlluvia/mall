package com.demo.mall.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * utils，
 * 静态类，基本的实体类
 * @param <T>
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T>  {
}
