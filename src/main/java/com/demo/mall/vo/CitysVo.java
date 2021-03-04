package com.demo.mall.vo;

import com.demo.mall.entities.GoodsRange;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CitysVo {

    private int id;
    private String name;

    public CitysVo(GoodsRange v) {
        this.name = v.getGoodsType();
        this.id = v.getId();
    }
}
