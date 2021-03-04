package com.demo.mall.mapper;

import com.demo.mall.dto.CommentDto;
import com.demo.mall.entities.Comment;
import com.demo.mall.utils.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

public interface CommentDao extends BaseMapper<Comment> {


    @Select("select * from comment where goods_id=#{id} ")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "userId",  column = "user_id"),
            @Result(property = "starValue",  column = "star_value"),
            @Result(property = "comment",  column = "comment"),
            @Result(property = "time",  column = "time"),
    })
    List<Comment> getComments(int id);

    @Insert("insert into comment(user_id,star_value,comment,time,goods_id) " +
            "value(#{userId},#{c.starValue},#{c.comment},#{time},#{c.goodsId})")
    int addComment(@Param("userId") int userId, @Param("c") CommentDto commentDto, @Param("time") Date date);

    @Delete("delete from comment where user_id=#{userId}")
    void deleteCommentByUserId(int userId);

    @Delete("delete from comment where user_id=#{goodsId}")
    void deleteCommentByGoodsId(int goodsId);
}
