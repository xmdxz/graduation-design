package com.boot.dto.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @Author YuanXin
 * @ClassName UserPageVo
 * @Description TODO
 * @Date 2022/11/14 15:09
 */

@Data
public class UserPageVo {

    @ApiModelProperty("id")
    private String id;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String phone;


    private Timestamp createTime;

}