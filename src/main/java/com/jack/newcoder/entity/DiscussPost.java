package com.jack.newcoder.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author jackjoily
 * @date 2020/10/29 9:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscussPost {
    private int id;
    private int userId;
    private String title;
    private String content;
    private int type;
    private int status;
    private Date CreateTime;
    private int commentCount;
    private double score;
}
