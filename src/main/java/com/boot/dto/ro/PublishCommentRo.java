package com.boot.dto.ro;

import com.boot.common.enums.Type;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class PublishCommentRo {

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("业务id")
    private String id;

    @ApiModelProperty("type")
    private Type type;

    @ApiModelProperty("评论内容")
    private String content;
}
