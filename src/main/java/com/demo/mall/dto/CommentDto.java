package com.demo.mall.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CommentDto {

    private String token;

    private int starValue;

    private String comment;

    private int goodsId;

}
