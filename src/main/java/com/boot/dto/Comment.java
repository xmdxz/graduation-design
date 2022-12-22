package com.boot.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.boot.enums.Type;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author YuanXin
 * @ClassName Comment
 * @Description TODO
 * @Date 2022/12/21 17:12
 */
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

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private String userId;
}