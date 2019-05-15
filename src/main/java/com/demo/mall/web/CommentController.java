package com.demo.mall.web;

import com.demo.mall.dto.CommentDto;
import com.demo.mall.entities.User;
import com.demo.mall.service.CommentService;
import com.demo.mall.service.TokenService;
import com.demo.mall.utils.ResultMessageBuilder;
import com.demo.mall.vo.CommentVo;
import com.demo.mall.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户评论类
 */
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private TokenService tokenService;

    /**
     * 获取指定商品的评论
     * @param id
     * @return
     */
    @GetMapping("/mall/comments/{id}")
    public ResultMessageBuilder.ResultMessage getComments(@PathVariable int id) {
        List<CommentVo> comments = commentService.getComments(id);
        return ResultMessageBuilder.success(comments);
    }

    /**
     * 用户评论接口
     * @param commentDto
     * @return
     */
    @PostMapping("/mall/comments/add")
    public ResultMessageBuilder.ResultMessage insertComment(@RequestBody CommentDto commentDto){
        User user = tokenService.explainToken(commentDto.getToken());
        if (user!=null){
            int f = commentService.addComment(user.getId(),commentDto);
            if (f==1){
            return ResultMessageBuilder.success("");
            }else {
                return ResultMessageBuilder.error("添加失败");
            }
        }else {
            return ResultMessageBuilder.error("用户不存在");
        }

    }

}
