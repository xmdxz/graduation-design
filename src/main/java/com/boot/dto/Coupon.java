package com.boot.dto;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.annotation.TableName;
import com.boot.enums.CouponStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @Author YuanXin
 * @ClassName Coupon
 * @Description TODO
 * @Date 2022/12/21 17:12
 */
@ApiModel(value = "coupon")
@Data
@TableName(value = "`coupon`")
public class Coupon extends BaseTimeDeleteEntity {
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private String userId;

    /**
     * 优惠券名称
     */
    @ApiModelProperty(value = "优惠券名称")
    private String name;

    /**
     * 优惠券有效期开始
     */
    @ApiModelProperty(value = "优惠券有效期开始")
    private Timestamp startTime;

    /**
     * 优惠券有效期结束
     */
    @ApiModelProperty(value = "优惠券有效期结束")
    private Timestamp endTime;

    /**
     * 优惠券金额
     */
    @ApiModelProperty(value = "优惠券金额")
    private BigDecimal amount;

    /**
     * 状态,是否使用或其他
     */
    @ApiModelProperty(value = "状态,是否使用或其他")
    private CouponStatus status;

    /**
     * 描述信息
     */
    @ApiModelProperty(value = "描述信息")
    private String mark;

    public Boolean isExpired() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        if (ObjectUtil.isNull(startTime) || ObjectUtil.isNull(endTime)) {
            return true;
        }
        return now.compareTo(endTime) >= 0;
    }
}