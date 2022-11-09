package com.boot.dal.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.boot.common.dao.BaseTimeDeleteEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author YuanXin
 * @ClassName Comment
 * @Description TODO
 * @Date 2022/11/9 11:25
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
    private String type;

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
}