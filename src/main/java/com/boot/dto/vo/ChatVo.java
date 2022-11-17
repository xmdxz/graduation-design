package com.boot.dto.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


@Data
public class ChatVo {
    @ApiModelProperty(value = "商品名称")
    private String name;
    @ApiModelProperty(value = "商品图片")
    private List<String> images;
    @ApiModelProperty(value = "聊天内容")
    private String content;
    @ApiModelProperty(value = "商品编号")
    private String goodsId;
}
