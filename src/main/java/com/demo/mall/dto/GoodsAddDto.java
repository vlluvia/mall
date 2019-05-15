package com.demo.mall.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class GoodsAddDto {

    private String goodsName;

    private String goodsTypeId;

    private String goodsSrc;

    private String goodsDesc;

    private List<GoodsDetail> goodsDetail;

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @ToString
    public static class GoodsDetail {
        private String goodsSizeName;

        private int goodsStack;

        private double goodsSizePrice;
    }
}