package com.demo.mall.web;

import com.demo.mall.dto.UserDto;
import com.demo.mall.entities.User;
import com.demo.mall.service.TokenService;
import com.demo.mall.service.UserService;
import com.demo.mall.utils.ResultMessageBuilder;
import com.demo.mall.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    @PostMapping("/api/user/login")
    public ResultMessageBuilder.ResultMessage login(@RequestBody UserDto userDto) {
        User user = userService.findUserByAccount(userDto.getAccount());
        if (user != null) {
            if(user.getPassword().equals(userDto.getPwd())) {
                String token = tokenService.getToken(userDto.getAccount(), userDto.getPwd());
                System.out.println(token);
                UserVo userVo = new UserVo();
                userVo.setToken(token);
                userVo.setNickname(user.getNickname());
                return ResultMessageBuilder.success(userVo);
            }else {
                return ResultMessageBuilder.error(401, "账号或密码错误");
            }
        } else {
            return ResultMessageBuilder.error(401, "该用户不存在");
        }
    }

    @PostMapping("/api/user/sign")
    public ResultMessageBuilder.ResultMessage sign(@RequestBody UserDto userDto) {
        User user = userService.findUserByAccount(userDto.getAccount());
        if (user != null) {
            return ResultMessageBuilder.error(401, "该用户已存在");
        }
        int i = userService.insertUser(userDto);
        if (i == 1) {
            String token = tokenService.getToken(userDto.getAccount(), userDto.getPwd());
            UserVo userVo = new UserVo();
            userVo.setToken(token);
            userVo.setNickname(userDto.getAccount());
            System.out.println(userVo.toString());
            return ResultMessageBuilder.success(userVo);
        } else {
            return ResultMessageBuilder.error(401, "无法注册该用户");
        }

    }
}
