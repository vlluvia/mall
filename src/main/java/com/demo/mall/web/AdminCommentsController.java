package com.demo.mall.web;

import com.demo.mall.dto.AdminCommentDelDao;
import com.demo.mall.entities.User;
import com.demo.mall.service.AdminCommentsService;
import com.demo.mall.service.TokenService;
import com.demo.mall.utils.ResultMessageBuilder;
import com.demo.mall.vo.CommentVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * web包 用于接口调用
 * 管理员评论管理类
 */
@RestController
public class AdminCommentsController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    AdminCommentsService adminCommentsService;

    /**
     * 获取全部评论
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/admin/comment")
    public ResultMessageBuilder.ResultMessage getComments(Integer pageNum,
                                                          Integer pageSize) {
        PageInfo<CommentVo> res = adminCommentsService.queryComments(pageNum, pageSize);
        return ResultMessageBuilder.success(res);
    }

    /**
     * 删除指定评论
     * @param adminCommentDelDao
     * @return
     */
    @PostMapping("/admin/del/comment")
    public ResultMessageBuilder.ResultMessage delComment(@RequestBody AdminCommentDelDao adminCommentDelDao) {
        User user = tokenService.explainToken(adminCommentDelDao.getToken());
        if (user != null) {
            adminCommentsService.delComment(adminCommentDelDao.getCommentId());
            return ResultMessageBuilder.success("删除成功");
        } else {
            return ResultMessageBuilder.error("该用户不存在");
        }
    }
}
