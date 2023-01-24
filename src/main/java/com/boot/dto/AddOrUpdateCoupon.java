package com.boot.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @Author YuanXin
 * @ClassName AddOrUpdateCoupon
 * @Description TODO
 * @Date 2023/1/12 16:50
 */

@Data
public class AddOrUpdateCoupon {


    /**
     * 优惠券名称
     */
    @ApiModelProperty(value = "优惠券名称")
    @NotBlank(message = "优惠券名称不能为空")
    private String name;

    /**
     * 优惠券有效期开始
     */
    @ApiModelProperty(value = "优惠券有效期开始")
    @NotNull(message = "有效期不能为空")
    private Timestamp startTime;

    /**
     * 优惠券有效期结束
     */
    @ApiModelProperty(value = "优惠券有效期结束")
    @NotNull(message = "有效期不能为空")
    private Timestamp endTime;

    /**
     * 优惠券金额
     */
    @ApiModelProperty(value = "优惠券金额")
    @NotNull(message = "优惠金额不能为空")
    private BigDecimal amount;

    /**
     * 描述信息
     */
    @ApiModelProperty(value = "描述信息")
    private String mark;

}
