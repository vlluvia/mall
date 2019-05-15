package com.demo.mall.service;

import com.demo.mall.dto.CommentDto;
import com.demo.mall.vo.CommentVo;

import java.util.List;

public interface CommentService {


    List<CommentVo> getComments(int id);

    int addComment(int userId, CommentDto commentDto);
}
