package com.demo.mall.web;

import com.demo.mall.dto.GoodsAddDto;
import com.demo.mall.dto.TokenDto;
import com.demo.mall.dto.UserDto;
import com.demo.mall.entities.User;
import com.demo.mall.service.GoodsService;
import com.demo.mall.service.TokenService;
import com.demo.mall.utils.ResultMessageBuilder;
import com.demo.mall.vo.AdminGoodsVo;
import com.demo.mall.vo.GoodsDetailVo;
import com.demo.mall.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * 商品接口类
 */
@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private TokenService tokenService;

    /**
     * 获取商品接口
     * @return
     */
    @GetMapping("/api/goods/goodsList")
    public ResultMessageBuilder.ResultMessage getGoodsList() {
        List<GoodsVo> goodsVo = goodsService.getGoodsList();
        return ResultMessageBuilder.success(goodsVo);
    }

    /**
     * 获取用户个人热门商品、推荐商品
     * @param tokenDto
     * @return
     */
    @PostMapping("/api/goods/hotGoodsList")
    public ResultMessageBuilder.ResultMessage gethotGoodsList(@RequestBody TokenDto tokenDto) {
        User user = tokenService.explainToken(tokenDto.getToken());
        if (user != null) {
            List<GoodsVo> goodsVo = goodsService.getHotGoodsList(user.getId());
            return ResultMessageBuilder.success(goodsVo);
        } else {
            return ResultMessageBuilder.error(401, "用户不存在");
        }
    }

    /**
     * 获取商品详情
     * @param id
     * @return
     */
    @GetMapping("/api/goods/goodsList/{id}")
    public ResultMessageBuilder.ResultMessage getGoodsListById(@PathVariable("id") int id) {
        List<GoodsVo> goodsVo = goodsService.getGoodsListById(id);
        return ResultMessageBuilder.success(goodsVo);
    }

    @GetMapping("/api/goods/{id}")
    public ResultMessageBuilder.ResultMessage getGoodsById(@PathVariable("id") int id) {
        GoodsDetailVo goodsDetailVo = goodsService.getGoodsDetailById(id);
        return ResultMessageBuilder.success(goodsDetailVo);
    }

    @GetMapping("/api/goods/goodsList/name/{goodsName}")
    public ResultMessageBuilder.ResultMessage getGoodsByName(@PathVariable("goodsName") String goodsName) {
        List<GoodsVo> goodsVo = goodsService.getGoodsListByName(goodsName);
        return ResultMessageBuilder.success(goodsVo);
    }

    /**
     * 删除商品
     * @param goodsId
     * @return
     */
    @GetMapping("/api/goods/del/{goodsId}")
    public ResultMessageBuilder.ResultMessage getGoodsByName(@PathVariable("goodsId") int goodsId) {
        goodsService.getGoodsDel(goodsId);
        return ResultMessageBuilder.success("删除成功");
    }

    /**
     * 添加商品
     * @param goodsAddDto
     * @return
     */
    @PostMapping("/api/goods/add")
    public ResultMessageBuilder.ResultMessage addGoods(@RequestBody GoodsAddDto goodsAddDto) {
        goodsService.addGoods(goodsAddDto);
        return ResultMessageBuilder.success("添加成功");
    }


    /**
     * 管理员获取商品
     * @param id
     * @return
     */
    @GetMapping("/api/admin/goods/{id}")
    public ResultMessageBuilder.ResultMessage getGoodsAdminById(@PathVariable("id") int id) {
        AdminGoodsVo adminGoodsVo = goodsService.getGoodsDetailAdminById(id);
        return ResultMessageBuilder.success(adminGoodsVo);
    }
}
