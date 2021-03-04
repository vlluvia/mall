package com.demo.mall.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author viento
 * @Date 2019/3/25 13:15
 * @Description
 * @Link 3576993219
 */
@AllArgsConstructor
@Data
@TableName("test")
public class Test{

    private int id;

    private String name;

}
