package com.boot.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author YuanXin
 * @ClassName Swiper
 * @Description TODO
 * @Date 2022/12/22 10:32
 */
@ApiModel(value = "swiper")
@Data
@TableName(value = "`swiper`")
public class Swiper extends BaseTimeDeleteEntity {

    /**
     * 轮播图要展示的演出id
     */
    @ApiModelProperty(value = "轮播图要展示的演出id")
    private String showId;

    /**
     * 是否展示（0不展示，1展示）
     */
    @ApiModelProperty(value = "是否展示（0不展示，1展示）")
    private Byte status;
}