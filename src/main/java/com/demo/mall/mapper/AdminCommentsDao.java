package com.demo.mall.mapper;

import com.demo.mall.entities.Comment;
import com.demo.mall.utils.BaseMapper;
import com.demo.mall.vo.CommentVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * dao，数据交互层
 * 以注解的形式，方便开发
 */
public interface AdminCommentsDao  extends BaseMapper<Comment> {

    @Select("select * from comment c, goods g, user u where c.user_id=u.id and g.id=c.goods_id")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "userId",  column = "user_id"),
            @Result(property = "nickname",  column = "nickname"),
            @Result(property = "userSrc",  column = "user_img"),
            @Result(property = "starValue",  column = "star_value"),
            @Result(property = "comment",  column = "comment"),
            @Result(property = "time",  column = "time"),
            @Result(property = "goodsName",  column = "goods_name"),
    })
    List<CommentVo> queryComments();

    @Delete("delete from comment where id=#{commentId}")
    void deleteComment(int commentId);
}
