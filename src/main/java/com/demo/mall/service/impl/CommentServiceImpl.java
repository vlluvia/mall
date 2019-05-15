package com.demo.mall.service.impl;

import com.demo.mall.dto.CommentDto;
import com.demo.mall.entities.Comment;
import com.demo.mall.entities.User;
import com.demo.mall.mapper.CommentDao;
import com.demo.mall.mapper.UserDao;
import com.demo.mall.service.CommentService;
import com.demo.mall.vo.CommentVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentDao commentDao;

    @Resource
    private UserDao userDao;

    @Override
    public List<CommentVo> getComments(int id) {
        List<Comment> list = commentDao.getComments(id);
        List<CommentVo> commentVos = new ArrayList<>();
        list.forEach(l->{
            User user = userDao.findUserById(l.getUserId());
            CommentVo commentVo = new CommentVo(l,user.getNickname(),user.getUserImg());
            commentVos.add(commentVo);
        });
        return commentVos;
    }

    @Override
    public int addComment(int userId, CommentDto commentDto) {
        return  commentDao.addComment(userId,commentDto,new Date());
    }
}
