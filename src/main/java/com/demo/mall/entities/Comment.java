package com.demo.mall.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Comment {

    private int id;

    private int userId;

    private int starValue;

    private String comment;

    private Date time;

    private int goodsId;
}
