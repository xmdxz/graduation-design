package com.boot.dal.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.boot.common.dao.BaseTimeDeleteEntity;
import com.boot.common.enums.Type;
import com.boot.dto.common.vo.UserBasicInformation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@ApiModel(value = "`comment`")
@Data
@TableName(value = "`comment`")
public class Comment extends BaseTimeDeleteEntity {

    /**
     * 业务id
     */
    @ApiModelProperty(value = "业务id")
    private String otherId;

    /**
     * 评论类型(商品，帖子)
     */
    @ApiModelProperty(value = "评论类型(商品，帖子)")
    private Type type;

    /**
     * 评论内容
     */
    @ApiModelProperty(value = "评论内容")
    private String content;

    /**
     * 父id
     */
    @ApiModelProperty(value = "父id")
    private String pid;

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("用户信息")
    @TableField(exist = false)
    private UserBasicInformation userInfo;

}