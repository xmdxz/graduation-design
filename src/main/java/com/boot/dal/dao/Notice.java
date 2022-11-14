package com.boot.dal.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.boot.common.dao.BaseTimeDeleteEntity;
import com.boot.common.enums.Type;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author YuanXin
 * @ClassName Notice
 * @Description TODO
 * @Date 2022/11/14 16:35
 */
@ApiModel(value = "notice")
@Data
@TableName(value = "`notice`")
public class Notice extends BaseTimeDeleteEntity {
    /**
     * 帖子内容
     */
    @ApiModelProperty(value = "帖子内容")
    private String content;

    @ApiModelProperty("LEIXING ")
    private Type type;
}