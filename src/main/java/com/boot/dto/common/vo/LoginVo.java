package com.boot.dto.common.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LoginVo {

    @ApiModelProperty("token")
    private String token;

    @ApiModelProperty("是否需要绑定另一半")
    private Boolean haveLove;

    @ApiModelProperty("自己的userid")
    private String id;

    @ApiModelProperty("是否清除loveId")
    private Boolean clear;

    @JsonIgnore
    private String message;


}
