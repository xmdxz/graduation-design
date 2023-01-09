package com.boot.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author YuanXin
 * @ClassName Show
 * @Description TODO
 * @Date 2022/12/22 10:32
 */
@ApiModel(value = "`show`")
@Data
@TableName(value = "`show`")
public class Show extends BaseTimeDeleteEntity {
    /**
     * 演出名字
     */
    @ApiModelProperty(value = "演出名字")
    private String name;

    /**
     * 演出的类型（话剧，脱口秀等）
     */
    @ApiModelProperty(value = "演出的类型（话剧，脱口秀等）")
    private String type;

    /**
     * 演出开始时间
     */
    @ApiModelProperty(value = "演出开始时间")
    @JsonFormat(pattern = "yyyy年MM月dd日 HH时mm分")
    private Date startTime;

    /**
     * 演出结束时间
     */
    @ApiModelProperty(value = "演出结束时间")
    @JsonFormat(pattern = "yyyy年MM月dd日 HH时mm分")
    private Date stopTime;

    /**
     * 主演人
     */
    @ApiModelProperty(value = "主演人")
    private String author;

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

    /**
     * 城市
     */
    @ApiModelProperty(value = "城市")
    private String city;

    /**
     * 演出描述信息
     */
    @ApiModelProperty(value = "演出描述信息")
    private String description;

    /**
     * 限购规则
     */
    @ApiModelProperty(value = "限购规则")
    private String buyRule;

    /**
     * 入场规则
     */
    @ApiModelProperty(value = "入场规则")
    private String joinRule;

    /**
     * 发票说明
     */
    @ApiModelProperty(value = "发票说明")
    private String invoiceIntro;

    /**
     * 观影须知
     */
    @ApiModelProperty(value = "观影须知")
    private String viewRule;

    @ApiModelProperty("观影地点")
    private String showPlace;
}
