package com.boot.dal.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.boot.common.dao.BaseTimeDeleteEntity;
import com.boot.common.dao.UploadFile;
import com.boot.common.enums.EndpointEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author YuanXin
 * @ClassName User
 * @Description
 * @Date 2022/8/28 11:46
 */
@ApiModel(value = "`user`")
@Schema
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "`user`", autoResultMap = true)
@Accessors(chain = true)
public class User extends BaseTimeDeleteEntity {

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    @Schema(description = "用户名")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    @Schema(description = "密码")
    private String password;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    @Schema(description = "手机号")
    private String phone;

    @ApiModelProperty("登录平台")
    @TableField(exist = false)
    private EndpointEnum endpoint;

    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    @Schema(description = "头像")
    @TableField(typeHandler = JacksonTypeHandler.class)
    private UploadFile avatar;

    /**
     * 微信openid
     */
    @ApiModelProperty(value = "微信openid")
    @Schema(description = "微信openid")
    private String wxOpenId;

    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    @Schema(description = "性别")
    private String sex;

    /**
     * 情侣
     */
    @ApiModelProperty(value = "情侣")
    @Schema(description = "情侣")
    private String loveId;
    

    @ApiModelProperty("微信公众平台openid")
    private String wxPublicOpenId;

}