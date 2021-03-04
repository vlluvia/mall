package com.demo.mall.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * dto
 * 实体类：
 * 获取前端传给后台的数据
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class AdminCommentDelDao extends TokenDto {

    private int commentId;
}
