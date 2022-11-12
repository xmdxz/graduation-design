package com.boot.dto.vo;

import com.boot.dto.common.vo.UserBasicInformation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author YuanXin
 * @ClassName CollectDynamicPageVo
 * @Description TODO
 * @Date 2022/11/11 16:47
 */

@Data
public class CollectDynamicPageVo {


    @ApiModelProperty("用户基本信息")
    private UserBasicInformation userInfo;

    @ApiModelProperty("帖子id")
    private String id;

    /**
     * 帖子内容
     */
    @ApiModelProperty(value = "帖子内容")
    private String content;

    /**
     * 图片数组
     */
    @ApiModelProperty(value = "图片数组")
    private List<String> images;

}
