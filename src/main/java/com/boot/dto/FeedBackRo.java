package com.boot.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author YuanXin
 * @ClassName FeedBackRo
 * @Description TODO
 * @Date 2022/12/21 17:44
 */

@Data
public class FeedBackRo {

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("内容")
    @NotBlank(message = "请输入反馈内容")
    private String content;
}
