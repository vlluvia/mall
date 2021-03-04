package com.demo.mall.web;

import com.demo.mall.dto.CityAddDto;
import com.demo.mall.service.CityService;
import com.demo.mall.service.TokenService;
import com.demo.mall.utils.ResultMessageBuilder;
import com.demo.mall.vo.CitysVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private CityService cityService;

    @GetMapping("/admin/mall/city")
    public ResultMessageBuilder.ResultMessage getCitys() {
//        User user = tokenService.explainToken(token.getToken());
//        if (user!=null) {
        List<CitysVo> dto = cityService.getCitys();
        return ResultMessageBuilder.success(dto);
//        }else {
//            return ResultMessageBuilder.error("该用户不存在");
//        }
    }

    @GetMapping("/admin/mall/city/client")
    public ResultMessageBuilder.ResultMessage getCitysClient() {
        List<CitysVo> dto = cityService.getCitys();
        return ResultMessageBuilder.success(dto);
    }

    @PostMapping("/admin/mall/city/add")
    public ResultMessageBuilder.ResultMessage getCitys(@RequestBody CityAddDto cityAddDto) {
//        User user = tokenService.explainToken(token.getToken());
//        if (user!=null) {
        List<CitysVo> dto = cityService.insertCity(cityAddDto);
        return ResultMessageBuilder.success(dto);
//        }else {
//            return ResultMessageBuilder.error("该用户不存在");
//        }
    }
}
