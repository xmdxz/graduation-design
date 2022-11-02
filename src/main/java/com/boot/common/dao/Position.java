package com.boot.common.dao;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @author YuanXin
 */
@Data
public class Position {
    @ApiModelProperty("经度")
    private String longitude;
    @ApiModelProperty("纬度")
    private String latitude;
}
