package com.boot.dto.vo;

import com.boot.common.enums.Type;
import com.boot.dto.common.vo.UserBasicInformation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @Author YuanXin
 * @ClassName CommentVo
 * @Description TODO
 * @Date 2022/11/12 19:39
 */

@Data
public class CommentVo {

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("创建时间")
    private Timestamp createTime;

    /**
     * 评论类型(商品，帖子)
     */
    @ApiModelProperty(value = "评论类型(商品，帖子)")
    private Type type;

    /**
     * 评论内容
     */
    @ApiModelProperty(value = "评论内容")
    private String content;


    @ApiModelProperty("用户信息")
    private UserBasicInformation userInfo;
}
