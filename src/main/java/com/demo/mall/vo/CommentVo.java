package com.demo.mall.vo;

import com.demo.mall.entities.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CommentVo implements Serializable {

    private int id;

    private int userId;

    private String nickname;

    private String userSrc;

    private String comment;

    private Date time;

    private int starValue;

    private int goodsId;

    private String goodsName;

    public CommentVo(Comment l,String nickname,String img) {
        this.id = l.getId();
        this.comment = l.getComment();
        this.starValue = l.getStarValue();
        this.time=l.getTime();
        this.userId = l.getUserId();
        this.nickname=nickname;
        this.goodsId=l.getGoodsId();
        this.userSrc =img;
    }
}
