package com.boot.dal.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.boot.common.dao.BaseTimeDeleteEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author YuanXin
 * @ClassName CarouselChart
 * @Description TODO
 * @Date 2022/11/14 17:12
 */
@ApiModel(value = "carousel_chart")
@Data
@TableName(value = "`carousel_chart`")
public class CarouselChart extends BaseTimeDeleteEntity {
    /**
     * 图片
     */
    @ApiModelProperty(value = "图片")
    private String image;
}