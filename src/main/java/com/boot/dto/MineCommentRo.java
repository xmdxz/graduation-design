package com.boot.dto;

import com.boot.common.request.page.PageQuery;
import com.boot.enums.Type;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author YuanXin
 * @ClassName MineCommentRo
 * @Description TODO
 * @Date 2022/12/22 17:59
 */

@Data
public class MineCommentRo {

    private PageQuery page;


    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("类型")

    private Type type;
}
