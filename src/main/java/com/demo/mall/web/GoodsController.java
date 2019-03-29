package com.demo.mall.web;

import com.demo.mall.dto.UserDto;
import com.demo.mall.service.GoodsService;
import com.demo.mall.utils.ResultMessageBuilder;
import com.demo.mall.vo.GoodsDetailVo;
import com.demo.mall.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/api/goods/goodsList")
    public ResultMessageBuilder.ResultMessage getGoodsList() {
        List<GoodsVo> goodsVo = goodsService.getGoodsList();
        return ResultMessageBuilder.success(goodsVo);
    }
    @GetMapping("/api/goods/goodsList/{id}")
    public ResultMessageBuilder.ResultMessage getGoodsListById(@PathVariable("id") int id) {
        List<GoodsVo> goodsVo = goodsService.getGoodsListById(id);
        return ResultMessageBuilder.success(goodsVo);
    }
    @GetMapping("/api/goods/{id}")
    public ResultMessageBuilder.ResultMessage getGoodsById(@PathVariable("id") int id){
        GoodsDetailVo goodsDetailVo = goodsService.getGoodsDetailById(id);
        return ResultMessageBuilder.success(goodsDetailVo);
    }

}
