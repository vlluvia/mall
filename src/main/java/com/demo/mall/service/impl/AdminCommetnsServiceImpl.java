package com.demo.mall.service.impl;

import com.demo.mall.mapper.AdminCommentsDao;
import com.demo.mall.service.AdminCommentsService;
import com.demo.mall.vo.CommentVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * impl层，具体的代码实现区域
 * service的具体实现
 */
@Service
public class AdminCommetnsServiceImpl implements AdminCommentsService {

    @Resource
    AdminCommentsDao adminCommentsDao;

    @Override
    public PageInfo<CommentVo> queryComments(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<CommentVo> list = adminCommentsDao.queryComments();
        return  new PageInfo<>(list);
    }

    @Override
    public void delComment(int commentId) {
        adminCommentsDao.deleteComment(commentId);
    }
}
