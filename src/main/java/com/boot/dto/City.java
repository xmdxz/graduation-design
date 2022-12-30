package com.boot.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author YuanXin
 * @ClassName City
 * @Description TODO
 * @Date 2022/12/22 10:32
 */
@ApiModel(value = "city")
@Data
@TableName(value = "`city`")
public class City extends BaseTimeDeleteEntity {
    /**
     * 城市名
     */
    @ApiModelProperty(value = "城市名")
    private String cityName;

    /**
     * 城市编码
     */
    @ApiModelProperty(value = "城市编码")
    private String cityCode;

    @ApiModelProperty(value = "是否热门")
    private int isHot;

    @ApiModelProperty(value = "拼音")
    private String spell;
}
