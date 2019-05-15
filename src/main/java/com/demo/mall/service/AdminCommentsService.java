package com.demo.mall.service;


import com.demo.mall.vo.CommentVo;
import com.github.pagehelper.PageInfo;

/**
 * service 接口层
 * 调用和实现的分层管理
 */
public interface AdminCommentsService {
    PageInfo<CommentVo> queryComments(Integer pageNum, Integer pageSize);

    void delComment(int commentId);
}
