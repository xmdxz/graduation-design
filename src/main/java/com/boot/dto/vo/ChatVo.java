package com.boot.dto.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Shubo_Yang
 * @version 1.0
 * @date 2022/11/15 12:45
 */
@Data
public class ChatVo {
    @ApiModelProperty(value = "商品名称")
    private String name;
    @ApiModelProperty(value = "商品图片")
    private List<String> images;
    @ApiModelProperty(value = "聊天内容")
    private String content;
}
