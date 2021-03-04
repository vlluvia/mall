package com.demo.mall.vo;

import com.demo.mall.entities.GoodsDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class GoodsDetailVo implements Serializable {

    private int goodsId;

    private String goodsName;

    private String goodsDesc;

    private String goodsPic;

    private List<Specs> specs;


    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class Specs{
        private int id;
        private String specName;
        private int stockNum;
        private double price;

        public Specs(GoodsDetail g) {
            this.id = g.getId();
            this.price=g.getGoodsSizePrice();
            this.specName = g.getGoodsSizeName();
            this.stockNum = g.getGoodsStock();
        }
    }
}
