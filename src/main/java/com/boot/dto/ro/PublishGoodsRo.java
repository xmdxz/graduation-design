package com.boot.dto.ro;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Author YuanXin
 * @ClassName PublishGoodsRo
 * @Description TODO
 * @Date 2022/11/13 13:47
 */

@Data
public class PublishGoodsRo {


    @ApiModelProperty("用户id")
    private String userId;

    @NotBlank(message = "标题不能为空")
    @ApiModelProperty("标题")
    private String name;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("价格")
    private BigDecimal price;

    @ApiModelProperty("图片数组")
    @NotEmpty(message = "至少上传一张图片")
    private List<String> images;
}
