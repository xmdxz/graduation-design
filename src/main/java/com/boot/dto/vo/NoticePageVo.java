package com.boot.dto.vo;

import com.boot.common.enums.Type;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @Author YuanXin
 * @ClassName NoticePageVo
 * @Description TODO
 * @Date 2022/11/14 16:41
 */

@Data
public class NoticePageVo {


    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("创建时间")
    private Timestamp createTime;

    /**
     * 帖子内容
     */
    @ApiModelProperty(value = "帖子内容")
    private String content;

    @ApiModelProperty("类型")
    private Type type;

}
