package com.boot.dto;

import com.boot.enums.CouponStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author YuanXin
 * @ClassName CouponListVo
 * @Description TODO
 * @Date 2022/12/23 20:24
 */

@Data
public class CouponListVo {

    @ApiModelProperty("优惠券,正常")
    private List<CouponVo> normal;

    @ApiModelProperty("优惠券,过期或已使用")
    private List<CouponVo> other;

    @Data
    public static class CouponVo {
        private String id;

        /**
         * 优惠券名称
         */
        @ApiModelProperty(value = "优惠券名称")
        private String name;

        /**
         * 优惠券有效期开始
         */
        @ApiModelProperty(value = "优惠券有效期开始")
        private Long startTime;

        /**
         * 优惠券有效期结束
         */
        @ApiModelProperty(value = "优惠券有效期结束")
        private Long endTime;

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
    }
}
