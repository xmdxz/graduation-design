package com.boot.dto.vo;

import com.boot.dto.common.vo.UserBasicInformation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author YuanXin
 * @ClassName UserDataVo
 * @Description TODO
 * @Date 2022/11/9 9:48
 */

@Data
public class UserDataVo {


    @ApiModelProperty("用户基本信息")
    private UserBasicInformation userInfo;


    @ApiModelProperty("收藏数")
    private Integer collect;

    @ApiModelProperty("贴子数")
    private Integer dynamic;

    @ApiModelProperty("我的发布")
    private Integer publish;

    @ApiModelProperty("我的卖出")
    private Integer sold;

    @ApiModelProperty("我的买入")
    private Integer buy;


}
