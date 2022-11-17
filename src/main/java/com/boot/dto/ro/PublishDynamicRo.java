package com.boot.dto.ro;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;


@Data
public class PublishDynamicRo {


    @ApiModelProperty(value = "用户id")
    private String userId;


    @ApiModelProperty("内容")
    @NotBlank(message = "内容不能为空")
    private String content;

    @ApiModelProperty("图片")
    @NotEmpty(message = "请上传至少一张图片")
    private List<String> images;

}
