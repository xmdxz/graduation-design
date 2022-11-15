package com.boot.dto.vo;

import com.boot.dto.common.vo.UserBasicInformation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Author YuanXin
 * @ClassName DynamicPageVo
 * @Description TODO
 * @Date 2022/11/13 15:52
 */

@Data
public class DynamicPageVo {

    private Timestamp createTime;

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

    private Boolean isCollect;


}
