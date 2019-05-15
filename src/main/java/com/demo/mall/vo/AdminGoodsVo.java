package com.demo.mall.vo;

import com.demo.mall.dto.GoodsAddDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * vo
 * 实体类，、
 * 目标：用于封装好数据发给前端接收，同时序列化
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AdminGoodsVo implements Serializable {

    private int goodsId;

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

        private int goodsDetailId;

        private String goodsSizeName;

        private int goodsStack;

        private double goodsSizePrice;
    }
}
