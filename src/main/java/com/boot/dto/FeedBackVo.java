package com.boot.dto;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @Author YuanXin
 * @ClassName FeedBackVo
 * @Description TODO
 * @Date 2022/12/29 11:08
 */

@Data
public class FeedBackVo {

    private String id;


    private String content;


    private String username;

    private String phone;

    private Timestamp createTime;
}
