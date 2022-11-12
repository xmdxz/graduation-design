package com.boot.dal.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.boot.common.dao.BaseTimeDeleteEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 聊天
 * @author Shubo_Yang
 * @version 1.0
 * @date 2022/11/7 9:26
 */

@ApiModel(value = "`chat`")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "`chat`", autoResultMap = true)
@Accessors(chain = true)
public class Chat extends BaseTimeDeleteEntity {

    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户id")
    private String userId;


    /**
     * 聊天内容
     */
    @ApiModelProperty(value = "聊天内容")
    private String content;
}
