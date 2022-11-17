package com.boot.dal.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.boot.common.dao.BaseTimeDeleteEntity;
import com.boot.dto.common.vo.UserBasicInformation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@ApiModel(value = "`chat`")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "`chat`", autoResultMap = true)
@Accessors(chain = true)
public class Chat extends BaseTimeDeleteEntity {

    @ApiModelProperty("用户基本信息")
    @TableField(exist = false)
    private UserBasicInformation userInfo;

    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户id")
    private String userId;


    /**
     * 聊天内容
     */
    @ApiModelProperty(value = "聊天内容")
    private String content;


    /**
     * 商品id
     */
    @ApiModelProperty(value = "商品id")
    private String goodsId;
}
