package com.boot.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author YuanXin
 * @ClassName Feedback
 * @Description TODO
 * @Date 2022/12/21 17:42
 */
@ApiModel(value = "feedback")
@Data
@TableName(value = "`feedback`")
public class Feedback extends BaseTimeDeleteEntity {
    /**
     * 反馈内容
     */
    @ApiModelProperty(value = "反馈内容")
    private String content;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private String userId;
}