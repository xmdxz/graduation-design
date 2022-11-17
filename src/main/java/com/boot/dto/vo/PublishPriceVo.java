package com.boot.dto.vo;

import com.boot.dto.common.vo.UserBasicInformation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;


@Data
public class PublishPriceVo {

    @ApiModelProperty("时间")
    private Timestamp createTime;

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("用户基本信息")
    private UserBasicInformation userInfo;

    @ApiModelProperty("出价")
    private BigDecimal price;
}
