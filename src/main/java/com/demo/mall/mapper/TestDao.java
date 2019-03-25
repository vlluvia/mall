package com.demo.mall.mapper;

import com.demo.mall.entities.Test;
import com.demo.mall.utils.BaseMapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface TestDao extends BaseMapper<Test> {

    @Select("select * from test where id =#{id}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "name",  column = "name")
    })
    Test queryTest(int id);
}
