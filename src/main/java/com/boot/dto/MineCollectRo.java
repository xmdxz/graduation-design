package com.boot.dto;

import com.boot.common.request.page.PageQuery;
import com.boot.enums.Type;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author YuanXin
 * @ClassName MineCollectRo
 * @Description TODO
 * @Date 2022/12/22 18:11
 */

@Data
public class MineCollectRo {

    private PageQuery page;

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("类型")
    private Type type;
}
