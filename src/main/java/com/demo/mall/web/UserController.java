package com.demo.mall.web;

import com.demo.mall.dto.TokenDto;
import com.demo.mall.dto.UserDeleteDao;
import com.demo.mall.dto.UserDto;
import com.demo.mall.dto.UserInfoDto;
import com.demo.mall.entities.User;
import com.demo.mall.service.TokenService;
import com.demo.mall.service.UserService;
import com.demo.mall.utils.ResultMessageBuilder;
import com.demo.mall.vo.UserInfoVo;
import com.demo.mall.vo.UserVo;
import com.demo.mall.vo.UsersVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户管理接口
 */
@RestController
public class UserController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    /**
     * 用户基于token登录
     * @param userDto
     * @return
     */
    @PostMapping("/api/user/login")
    public ResultMessageBuilder.ResultMessage login(@RequestBody UserDto userDto) {
        User user = userService.findUserByAccount(userDto.getAccount());
        if (user != null) {
            if(user.getPassword().equals(userDto.getPwd())) {
                String token = tokenService.getToken(userDto.getAccount(), userDto.getPwd());
                UserVo userVo = new UserVo();
                userVo.setToken(token);
                userVo.setNickname(user.getNickname());
                userVo.setAdmin(user.isAdmin());
                return ResultMessageBuilder.success(userVo);
            }else {
                return ResultMessageBuilder.error(401, "账号或密码错误");
            }
        } else {
            return ResultMessageBuilder.error(401, "该用户不存在");
        }
    }

    /**
     * 用户注册
     * @param userDto
     * @return
     */
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

    /**
     *
     * @param tokenDto
     * @return
     */
    @PostMapping("/mall/data")
    public ResultMessageBuilder.ResultMessage getData(@RequestBody TokenDto tokenDto) {
        User user = tokenService.explainToken(tokenDto.getToken());
        if (user != null) {
            String[] userLike = userService.getUserGoodsTypeLike(user.getId());
            UserInfoVo userVo = new UserInfoVo(user,userLike);
            return ResultMessageBuilder.success(userVo);
        }else {
            return ResultMessageBuilder.error(401, "用户不存在");
        }
    }

    /**
     * 用户信息更新
     * @param userInfoDto
     * @return
     */
    @PostMapping("/mall/data/update")
    public ResultMessageBuilder.ResultMessage updateData(@RequestBody UserInfoDto userInfoDto) {
        User user = tokenService.explainToken(userInfoDto.getToken());
        if (user != null) {
            int s = userService.updateUser(userInfoDto,user.getId());
            if (user.getPassword().equals(userInfoDto.getPassword())) {
                return ResultMessageBuilder.success("");
            }else {
                return ResultMessageBuilder.success("logout");
            }
        }else {
            return ResultMessageBuilder.error(401, "用户不存在");
        }
    }

    /**
     * 管理员获取用户
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/admin/users")
    public ResultMessageBuilder.ResultMessage  queryUsers(Integer pageNum,
                                                          Integer pageSize) {
        PageInfo<UsersVo> userVoList = userService.queryUsers(pageNum, pageSize);
        return ResultMessageBuilder.success(userVoList);
    }

    /**
     * 管理员删除用户
     * @param userDeleteDao
     * @return
     */
    @PostMapping("/admin/del/user")
    public ResultMessageBuilder.ResultMessage delUser(@RequestBody UserDeleteDao userDeleteDao) {
        User user = tokenService.explainToken(userDeleteDao.getToken());
        if (user != null) {
            userService.delUser(userDeleteDao.getUserId());
            return ResultMessageBuilder.success("删除成功");
        } else {
            return ResultMessageBuilder.error("该用户不存在");
        }
    }
}
