package com.boot.dal.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.boot.common.dao.BaseTimeDeleteEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel(value = "`dynamic`")
@Data
@TableName(value = "`dynamic`")
public class Dynamic extends BaseTimeDeleteEntity {

    /**
     * 帖子内容
     */
    @ApiModelProperty(value = "帖子内容")
    private String content;

    /**
     * 图片数组
     */
    @ApiModelProperty(value = "图片数组")
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> images;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private String userId;
}