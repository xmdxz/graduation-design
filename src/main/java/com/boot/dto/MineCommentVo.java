package com.boot.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author YuanXin
 * @ClassName MineCommentVo
 * @Description TODO
 * @Date 2022/12/22 17:57
 */

@Data
public class MineCommentVo {

    private String id;


    @ApiModelProperty("评论内容")
    private String content;

    @ApiModelProperty("用户基本信息")
    private UserBasicInformation userInfo;


    @ApiModelProperty(value = "演出名字")
    private String name;

    /**
     * 演出开始时间
     */
    @ApiModelProperty(value = "演出开始时间")
    private Date startTime;

    /**
     * 演出结束时间
     */
    @ApiModelProperty(value = "演出结束时间")
    private Date stopTime;
    /**
     * 售卖价格
     */
    @ApiModelProperty(value = "售卖价格")
    private BigDecimal price;
    /**
     * 图片地址
     */
    @ApiModelProperty(value = "图片地址")
    private String imgUrl;

}
