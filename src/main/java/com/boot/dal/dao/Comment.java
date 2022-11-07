package com.boot.dal.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.boot.common.dao.BaseTimeDeleteEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 评论
 * @author Shubo_Yang
 * @version 1.0
 * @date 2022/11/7 14:28
 */
@ApiModel(value = "`comment`")
@Schema
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "`comment`", autoResultMap = true)
@Accessors(chain = true)
public class Comment extends BaseTimeDeleteEntity {

    /**
     * 业务Id
     */
    @ApiModelProperty(value = "业务id")
    @Schema(description = "业务id")
    private String otherId;

    /**
     * 评论类型(商品，贴子)
     */
    @ApiModelProperty(value = "评论类型(商品，贴子)")
    @Schema(description = "评论类型(商品，贴子)")
    private String type;

    /**
     * 评论内容
     */
    @ApiModelProperty(value = "评论内容")
    @Schema(description = "评论内容")
    private String content;

    /**
     * 父ID
     */
    @ApiModelProperty(value = "父ID")
    @Schema(description = "父ID")
    private String pid;
}
